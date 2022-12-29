package ZULALogins;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import ZULALogins.ZULARegistration.database;

public class newDriver extends HttpServlet{
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		Statement zula;
		Statement curr;
		if((req.getParameter("userName")!="" && req.getParameter("userPass")!="") && (req.getParameter("age")!=""))
		{
			try 
			{
				zula = database.conEst("zula");
				curr = database.conEst("curr");
				String userName=req.getParameter("userName");
				int age=Integer.parseInt(req.getParameter("age"));
				int userPass=Integer.parseInt(req.getParameter("userPass"));
				RequestDispatcher rd= req.getRequestDispatcher("adminNewDriver.jsp");
				ResultSet totalRows=zula.executeQuery("select count(*) from cabd;");
		        totalRows.next();
		        int rows = totalRows.getInt(1);
		        rows++;
		        zula.executeUpdate("insert into cabd values ("+rows+",'"+userName+"',"+userPass+","+age+");");
		        curr.executeUpdate("insert into cabstatus values ("+rows+",'"+req.getParameter("init")+"',0,'ready');");
				try 
				{
					rd.forward(req, res);
				} catch (ServletException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				}
				
				}
			
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		}
		else
		{
			RequestDispatcher rd= req.getRequestDispatcher("reNewDriver.jsp");
			try 
			{
				rd.forward(req, res);
			} catch (ServletException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
			
			}
		}		
	}


