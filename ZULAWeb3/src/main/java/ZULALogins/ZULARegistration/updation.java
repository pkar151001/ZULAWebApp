package ZULALogins.ZULARegistration;

import java.sql.SQLException;
import java.sql.Statement;


public class updation  {
    
	public static void initUpdate() throws SQLException, ClassNotFoundException
	{
		Statement curr=database.conEst("curr");
		curr.executeUpdate("Update cabstatus set rest='ready' where rest='at rest';");
		curr.executeUpdate("Update cabstatus set rest='at rest' where rest='booked';");

	}
	public static void finalUpdate() throws SQLException, ClassNotFoundException
	{
		int min_rides=rideRegistration.min_rides;
		int cab=rideRegistration.cab;
		String dest=rideRegistration.destination;
		Statement curr=database.conEst("curr");
		curr.executeUpdate("Update cabstatus set rest='booked' where id="+cab+";");
        curr.executeUpdate("Update cabstatus set rides="+(min_rides+1)+" where id="+cab+";");
        curr.executeUpdate("Update cabstatus set currloc='"+dest+"' where id="+cab+";");
	}
	public static void historyUpdate(Report r) throws SQLException, ClassNotFoundException
	{
		Statement curr=database.conEst("curr");
		curr.executeUpdate("insert into history values( "+r.getCabId()+",'"+r.getDriverName()+"',"+r.getCustomerId()+",'"+r.getCustomerName()+"','"+r.getSource()+"','"+r.getDest()+"',"+r.getFare()+","+r.getComm()+");");
	}
	
}
