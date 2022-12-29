package ZULALogins;

import ZULALogins.ZULAVerify.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class customerLogin extends HttpServlet{
	
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{	
		if(req.getParameter("userName")!="" && req.getParameter("userPass")!="")
		{
			String userName=req.getParameter("userName");
			int userPass=Integer.parseInt(req.getParameter("userPass"));
			if (customerLoginCheck.validate(userName,userPass))
			{
				RequestDispatcher rd= req.getRequestDispatcher("customerPage.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				RequestDispatcher rd= req.getRequestDispatcher("customerReLogin.jsp");
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
		}
		else
		{
			//res.getWriter().print("Wrong Credentials.....Re-Login again");
			RequestDispatcher rd= req.getRequestDispatcher("customerReLogin.jsp");
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
		
	}
}


