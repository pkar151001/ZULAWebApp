package ZULALogins.ZULAFetch;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class adminResult extends HttpServlet{
	List<Ride> resList= new ArrayList<Ride>();
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		String url="jdbc:mysql://localhost:3306/curr";
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root", "Priyalini@2");
            String query="Select * from history;";
            PreparedStatement curr=con.prepareStatement(query);
            ResultSet currentHistory=curr.executeQuery();
            while(currentHistory.next())
            {
            	Ride temp= new Ride();
            	temp.setCabId(currentHistory.getInt("cabid"));
            	temp.setCustomerId(currentHistory.getInt("customerid"));
            	temp.setCustomerName(currentHistory.getString("customername"));
            	temp.setDriverName(currentHistory.getString("drivername"));
            	temp.setSource(currentHistory.getString("source"));
            	temp.setDest(currentHistory.getString("destination"));
            	temp.setFare(currentHistory.getInt("fare"));
            	temp.setComm(currentHistory.getInt("comm"));
            	resList.add(temp);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        req.setAttribute("result", resList);
        RequestDispatcher rd= req.getRequestDispatcher("adminResult.jsp");
		try {
			rd.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
