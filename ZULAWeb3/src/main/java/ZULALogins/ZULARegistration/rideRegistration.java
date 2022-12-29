package ZULALogins.ZULARegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ZULALogins.ZULAVerify.customerLoginCheck;

public class rideRegistration {
	public static int min_rides;
	public static int cab;
	public static String destination;
	public static Report booking(String source, String dest) throws SQLException, ClassNotFoundException
	{
		int customerID=customerLoginCheck.userID;
		Report finalRes= new Report();
		
		Connection con_zula=database.conEstPre("zula");
		Statement zula=database.conEst("zula");
		Statement curr=database.conEst("curr");
		
		if(customerID!=0)
		{
			String querySource="Select org_dist from location where name=?;";
	        PreparedStatement source_stmt=con_zula.prepareStatement(querySource);
	        source_stmt.setString(1, source);
	        ResultSet sourceDist=source_stmt.executeQuery();
	        int sourcedist=0;
	        while(sourceDist.next())
	        sourcedist=sourceDist.getInt("org_dist");
	        
	        String queryDest="Select org_dist from location where name=?;";
	        PreparedStatement dest_stmt=con_zula.prepareStatement(queryDest);
	        dest_stmt.setString(1, dest);
	        ResultSet DestDist=dest_stmt.executeQuery();
	        int destdist=0;
	        while(DestDist.next())
	        destdist=DestDist.getInt("org_dist");
	        
	        int min_dist=100;
	        min_rides=1000;
	        cab=0;
	        int cabdist=0;
	        
	        destination=dest;
	        ResultSet availableCabs=curr.executeQuery("Select * from cabstatus where rest='ready';");
	        
	        while(availableCabs.next())

	            {
	                ResultSet cabDist=zula.executeQuery("Select org_dist from location where name='"+ availableCabs.getString("currloc")+"';");
	                while(cabDist.next())
	                cabdist=cabDist.getInt("org_dist");

	                if(Math.abs(cabdist-sourcedist) < min_dist || (Math.abs(cabdist-sourcedist)==min_dist && min_rides>=availableCabs.getInt("rides")))
	                {
	                    min_dist=Math.abs(cabdist-sourcedist);
	                    cab=availableCabs.getInt("id");
	                    min_rides=availableCabs.getInt("rides");
	                }

	            }
	        
	        finalRes.setCabId(cab);
	        finalRes.setCustomerId(customerID);
	        

	        ResultSet driName=zula.executeQuery("select * from cabd where id="+cab+";");
	        while(driName.next())
	            finalRes.setDriverName(driName.getString("name"));
	        
	        String query="select * from customers where id=?;";
	        PreparedStatement customer=con_zula.prepareStatement(query);
	        customer.setInt(1,customerID);
	        ResultSet custName=customer.executeQuery();
	        while(custName.next())
	        	finalRes.setCustomerName(custName.getString("name"));
	        
	        //Fare Calculation
	        finalRes.setSource(source);
	        finalRes.setDest(dest);
	        finalRes.setDist(Math.abs(sourcedist-destdist));
	        finalRes.setFare(finalRes.getDist()*10);
	        finalRes.setComm((int) (finalRes.getFare()*0.3));
	        
		}
        return finalRes;
	}
}
