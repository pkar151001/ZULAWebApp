import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import ZULALogins.ZULARegistration.Report;
import ZULALogins.ZULARegistration.curr;
import ZULALogins.ZULARegistration.printStatus;
import ZULALogins.ZULARegistration.rideRegistration;
import ZULALogins.ZULARegistration.updation;
import ZULALogins.ZULAVerify.customerLoginCheck;

public class customerRide extends HttpServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException 
	{
		customerRide finalProd= new customerRide();
		int customerID=customerLoginCheck.userID;
		String source=req.getParameter("source");
		String dest=req.getParameter("destination");
        
		if(customerLoginCheck.userID!=0 && source.compareTo(dest)!=0 )
		{
			try {
				updation.initUpdate();
				List<curr> init=printStatus.status();
				req.setAttribute("init", init );
				Report rep=rideRegistration.booking(source,dest);
				req.setAttribute("result", rep);
		 	    updation.finalUpdate();
		 	    List<curr> fin=printStatus.status();
		 	    req.setAttribute("fin", fin);
		        updation.historyUpdate(rep);
		        
				RequestDispatcher rd= req.getRequestDispatcher("customerBookReport.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			
			catch (SQLException | ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(source.compareTo(dest)==0)
		{
			RequestDispatcher rd= req.getRequestDispatcher("customerReRide.jsp");
			try {
				rd.forward(req, res);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
