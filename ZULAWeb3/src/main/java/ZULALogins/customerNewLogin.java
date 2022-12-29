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

public class customerNewLogin extends HttpServlet{
	public static void dispatcher(ServletRequest req, ServletResponse res)
	{
		RequestDispatcher rd= req.getRequestDispatcher("customerReNewLogin.jsp");
		try 
		{
			rd.forward(req, res);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		Statement zula;
		if(req.getParameter("userName")!="" && req.getParameter("userPass")!="" && req.getParameter("userPass2")!="" && req.getParameter("age")!="")
		{
			try 
			{
				zula = database.conEst("zula");
				String userName=req.getParameter("userName");
				int age=Integer.parseInt(req.getParameter("age"));
				int userPass=Integer.parseInt(req.getParameter("userPass"));
				int rePass=Integer.parseInt(req.getParameter("userPass2"));
				if (userPass==rePass)
				{
					RequestDispatcher rd= req.getRequestDispatcher("customerLogin.html");
					try {
						rd.forward(req, res);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					ResultSet totalRows=zula.executeQuery("select count(*) from customers;");
		            totalRows.next();
		            int rows = totalRows.getInt(1);
		            rows++;
		            zula.executeUpdate("insert into customers values ("+rows+",'"+userName+"',"+userPass+","+age+")");
				} 
				else
				{
					dispatcher(req,res);
				}}
			
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
			dispatcher(req,res);
		}
		}		
		
	}

