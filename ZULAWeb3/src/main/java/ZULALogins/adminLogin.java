package ZULALogins;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class adminLogin extends HttpServlet{
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		String userName=req.getParameter("userName");
		int userPass=Integer.parseInt(req.getParameter("userPass"));
		if (userName.compareTo("Priyavarthan N")==0 && userPass==1510)
		{
			RequestDispatcher rd= req.getRequestDispatcher("adminPage.jsp");
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
			RequestDispatcher rd= req.getRequestDispatcher("adminLogin.html");
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

