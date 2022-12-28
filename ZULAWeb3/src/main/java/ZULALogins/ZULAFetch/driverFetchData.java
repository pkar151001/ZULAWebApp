package ZULALogins.ZULAFetch;

import java.sql.*;
import java.util.*;

public class driverFetchData {
	public static List<Ride> data(int userID)
	{
		List<Ride> res= new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/curr";
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root", "Priyalini@2");
            String query="Select source, destination, customerid,fare,comm from history where cabid=?;";
            PreparedStatement curr=con.prepareStatement(query);
            curr.setInt(1, userID);
            ResultSet currentHistory=curr.executeQuery();
            
            while(currentHistory.next())
            {
            	Ride temp= new Ride();
            	temp.setSource(currentHistory.getString("source"));
            	temp.setDest(currentHistory.getString("destination"));
            	temp.setCustomerId(currentHistory.getInt("customerid"));
            	temp.setComm(currentHistory.getInt("comm"));
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
