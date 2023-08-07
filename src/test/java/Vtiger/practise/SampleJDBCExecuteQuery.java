package Vtiger.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable {
		
		//Get driver in mysql jar and register this in driver manager
		Driver driverRef=new Driver();
		
		// step 1--  Register the driver
		DriverManager.registerDriver(driverRef);
		
		// step 2-- Get the connection with driver--provide DB name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
		
		// step 3-- issue create statement
		Statement state = con.createStatement();
		
		// step 4-- execute the query -- provide table name
		
		String query= "insert into sampletable values('tom', 6, 'california');";
		int result=state.executeUpdate(query);
		
		//validate
		if(result==1)
		{
			System.out.println("Data added");
		}
		else
		{
			System.out.println("data not added");
		}
		
		
		ResultSet res = state.executeQuery("select * from sampletable");
		while(res.next())
		{
			System.out.println(res.getString(1)+" " +res.getString(2)+" " +res.getString(3));
		}
		// step 5-- close the database 
		con.close();

	}

}
