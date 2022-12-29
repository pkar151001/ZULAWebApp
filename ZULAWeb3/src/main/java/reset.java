import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import ZULALogins.adminLogin;

import java.io.IOException;
import java.sql.*;

public class reset extends HttpServlet{
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		String url="jdbc:mysql://localhost:3306/curr";
	    String url_zula="jdbc:mysql://localhost:3306/zula";
	    Connection con,con2;
	    if(adminLogin.access==1)
	    {
	    	try 
		    {
		    	Class.forName("com.mysql.jdbc.Driver");
		        con = DriverManager.getConnection(url,"root", "Priyalini@2");
		        con2= DriverManager.getConnection(url_zula, "root", "Priyalini@2");
		        Statement curr=con.createStatement();
		        Statement zula=con2.createStatement();
		        curr.executeUpdate("delete from cabstatus");
		        curr.executeUpdate("insert into cabstatus values (1,'D',0,'ready');");
		        curr.executeUpdate("insert into cabstatus values (2,'G',0,'ready');");
		        curr.executeUpdate("insert into cabstatus values (3,'H',0,'ready');");
		        curr.executeUpdate("insert into cabstatus values (4,'A',0,'ready');");
		        curr.executeUpdate("delete from history");
		        zula.executeUpdate("delete from customers where id>4");
		        zula.executeUpdate("delete from cabd where id>4");
		        RequestDispatcher rd= req.getRequestDispatcher("adminReset.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
	    }
	}
}
