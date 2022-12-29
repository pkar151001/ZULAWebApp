package ZULALogins.ZULAFetch;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import ZULALogins.ZULAVerify.customerLoginCheck;

public class customerView extends HttpServlet{
	public void service(ServletRequest req, ServletResponse res) throws IOException
	{
		int customerID=customerLoginCheck.userID;
		List<CustRide> ResultList=customerFetch.data(customerID);
		req.setAttribute("result", ResultList);
		RequestDispatcher rd= req.getRequestDispatcher("customerView.jsp");
		try {
			rd.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
