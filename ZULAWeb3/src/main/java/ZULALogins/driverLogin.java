package ZULALogins;
import ZULALogins.ZULAFetch.*;
import ZULALogins.ZULAVerify.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class driverLogin extends HttpServlet{
	
	public void service (ServletRequest req, ServletResponse res) throws IOException
	{
		//res.setContentType("text/html");
		
		String userName=req.getParameter("userName");
		int userPass=Integer.parseInt(req.getParameter("userPass"));
		if (driverLoginCheck.validate(userName,userPass))
		{
			int cabID=driverLoginCheck.userID;
			List<Ride> ResultList=driverFetchData.data(cabID);
			req.setAttribute("result", ResultList);
			RequestDispatcher rd= req.getRequestDispatcher("driverPage.jsp");
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
			//res.getWriter().print("Wrong Credentials.....Re-Login again");
			RequestDispatcher rd= req.getRequestDispatcher("driverLogin.html");
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

