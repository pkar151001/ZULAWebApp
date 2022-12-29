package ZULALogins.ZULARegistration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class printStatus {
	public static List<curr> status() throws SQLException, ClassNotFoundException
	{
		Statement curr=database.conEst("curr");
		ResultSet currentStatus=curr.executeQuery("Select * from cabstatus;");
		List<curr> res= new ArrayList<curr>();
		while(currentStatus.next())
        {
        	curr temp= new curr();
        	temp.setId(currentStatus.getInt("id"));
        	temp.setCurrloc(currentStatus.getString("currloc"));
        	temp.setRides(currentStatus.getInt("rides"));
        	temp.setStatus(currentStatus.getString("rest"));
        	res.add(temp);
        }
		return res;
	}

}
