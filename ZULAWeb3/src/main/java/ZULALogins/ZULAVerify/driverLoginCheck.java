package ZULALogins.ZULAVerify;

import java.sql.*;

public class driverLoginCheck {
	public static int userID=0;
	public static boolean validate (String name, int pass)
	{
		boolean res=false;
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/zula";
			Connection con=DriverManager.getConnection(url,"root", "Priyalini@2");
            String query="select * from cabd where name=? and pass=?;";
            PreparedStatement zula=con.prepareStatement(query);
            zula.setString(1, name);
            zula.setInt(2, pass); 
			ResultSet rs=zula.executeQuery();  
			res=rs.next();
			userID=rs.getInt("id");
			}
		catch(Exception e)
		{
			System.out.println(e);
		}  
			return res;  
	}
}