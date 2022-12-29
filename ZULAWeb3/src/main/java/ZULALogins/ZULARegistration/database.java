package ZULALogins.ZULARegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ZULALogins.ZULAVerify.customerLoginCheck;

public class database {
	
	static int customerID=customerLoginCheck.userID;
	static String url_curr="jdbc:mysql://localhost:3306/curr";
    static String url_zula="jDbc:mysql://localhost:3306/zula";
    
    public static Statement conEst(String option) throws SQLException, ClassNotFoundException
    {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con_curr = DriverManager.getConnection(url_curr,"root", "Priyalini@2");
			Connection con_zula=DriverManager.getConnection(url_zula,"root", "Priyalini@2");
			Statement curr=con_curr.createStatement();
			Statement zula=con_zula.createStatement();
			if(option.compareTo("curr")==0)return curr;
			else if (option.compareTo("zula")==0)return zula;
			else return null;

    }
    public static Connection conEstPre(String option) throws SQLException, ClassNotFoundException
    {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con_curr = DriverManager.getConnection(url_curr,"root", "Priyalini@2");
			Connection con_zula=DriverManager.getConnection(url_zula,"root", "Priyalini@2");
			if(option.compareTo("curr")==0)return con_curr;
			else if (option.compareTo("zula")==0)return con_zula;
			else return null;
    }
    
    
}
