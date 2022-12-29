package ZULALogins.ZULAFetch;

import java.sql.*;
import java.util.*;

public class customerFetch {
	public static List<CustRide> data(int userID)
	{
		List<CustRide> res= new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/curr";
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root", "Priyalini@2");
            String query="Select source, destination, customerid,fare from history where customerid=?;";
            PreparedStatement curr=con.prepareStatement(query);
            curr.setInt(1, userID);
            ResultSet currentHistory=curr.executeQuery();
            
            while(currentHistory.next())
            {
            	CustRide temp= new CustRide();
            	temp.setSource(currentHistory.getString("source"));
            	temp.setDestination(currentHistory.getString("destination"));
            	temp.setCabid(currentHistory.getInt("customerid"));
            	temp.setFare(currentHistory.getInt("fare"));
            	res.add(temp);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
	}
}
