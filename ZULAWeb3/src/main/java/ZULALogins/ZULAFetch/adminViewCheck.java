package ZULALogins.ZULAFetch;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class adminViewCheck extends HttpServlet{
	public Total totalObj=new Total();
	public List<Ride> res=new ArrayList<Ride>();
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		adminViewCheck finalObj= new adminViewCheck();
		int cabID=Integer.parseInt(req.getParameter("cabID"));
		String url="jdbc:mysql://localhost:3306/curr";
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root", "Priyalini@2");
            
            String fareQuery="select sum(fare) from history where cabid=?;";
            PreparedStatement sumFare=con.prepareStatement(fareQuery);
            sumFare.setInt(1, cabID);
            ResultSet fare=sumFare.executeQuery();
            fare.next();
            finalObj.totalObj.setTotalFare(fare.getInt(1));
            System.out.println(finalObj.totalObj.getTotalFare());
            
            String commQuery="select sum(comm) from history where cabid=?;";
            PreparedStatement sumComm=con.prepareStatement(commQuery);
            sumComm.setInt(1, cabID);
            ResultSet comm=sumComm.executeQuery();
            comm.next();
            finalObj.totalObj.setTotalComm(comm.getInt(1));
            
            
            String countQuery="select count(*) from history where cabid=?";
            PreparedStatement tCount=con.prepareStatement(countQuery);
            tCount.setInt(1, cabID);
            ResultSet count=tCount.executeQuery();
            count.next();
            finalObj.totalObj.setTotalCount(count.getInt(1));
            

            String historyQuery="select * from history where cabid=?";
            PreparedStatement history=con.prepareStatement(historyQuery);
            history.setInt(1, cabID);
            ResultSet currentHistory=history.executeQuery();
            finalObj.res= new ArrayList<Ride>();
            
            while(currentHistory.next())
            {
            	Ride temp= new Ride();
            	temp.setSource(currentHistory.getString("source"));
            	temp.setDest(currentHistory.getString("destination"));
            	temp.setCustomerId(currentHistory.getInt("customerid"));
            	temp.setComm(currentHistory.getInt("comm"));
            	temp.setFare(currentHistory.getInt("fare"));
            	finalObj.res.add(temp);
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        req.setAttribute("result", finalObj);
        RequestDispatcher rd= req.getRequestDispatcher("adminViewResult.jsp");
		try {
			rd.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
