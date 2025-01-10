package Advance_Java;
import java.sql.*; 
import java.util.*; 
import java.lang.*; 

public class Startof_JDBC {

	public static void main(String[] args)throws Exception
	{
		 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","tiger");

		//JDBC Obj fro Statement

		Statement st = con.createStatement();

		//write the query

		String query = "select * from customer70";

		//create JDBC ResultSet obj

		ResultSet rs = st.executeQuery(query);

		while(rs.next()){

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getLong(5));

		}

		rs.close();

		st.close();

		con.close();
		}
}
	

