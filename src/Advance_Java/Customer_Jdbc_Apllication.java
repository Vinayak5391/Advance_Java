package Advance_Java;
import java.sql.*;
import java.util.*;

 

/*(Construct JDBC Application to perform the following Operations on Customer-table)
1.AddCustomer
2.ViewAllCustomers
3.ViewCustomerBasedOnId*/

public class Customer_Jdbc_Apllication 
{
  public static void main(String[] args) throws SQLException 
	{
       Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","tiger");
             Statement stm = con.createStatement();
			 ResultSet rs = stm.executeQuery("select * from Customer70");
			 while(true) 
			 {
				  
				 System.out.println("******Operation choice******");
				 System.out.println("\t1.AddCustomer" 
				 + "\n\t2.viewAllcustomers"
				 + "\n\t3.ViewCustomerbyid"
				 + "\n\t4.Exit");
				 System.out.println("Enter your choice:");
				 int choice = Integer.parseInt(sc.nextLine());
				 switch(choice)
				 {
				 case 1:
					 System.out.println("-----customer Details-----");
					 System.out.println("Enter customer id");
					 int id = Integer.parseInt(sc.nextLine());
					 System.out.println("Enter customer name ");
					 String name = sc.nextLine();
					 System.out.println("Enter customer city");
					 String city = sc.nextLine();
					 System.out.println("Enter customer MailId");
					 String mail = sc.nextLine();
					 System.out.println("Enter customer Phno");
					 long phNo = Long.parseLong(sc.nextLine());
					 
					 int k = stm.executeUpdate("insert into customer70 values("+id+"','"+name+"','"+city+"','"+mail+"','"+phNo+");");
					 if(k>0)
					 {
					System.out.println("Customer Added Successfully");
					ResultSet rs4 = stm.executeQuery("select * from customer70");
					 while (rs4.next()) {
						 System.out.println(rs4.getInt(1)+"\t"
					 +rs4.getString(2)+"\t"
					 +rs4.getString(3)+"\t"
					 +rs4.getString(4)+"\t"
					 +rs4.getLong(5));
					 }
					 }
					 break;
				 case 2:
					 ResultSet rs1 = stm.executeQuery("Select * from customer70");
					 System.out.println("Customer Details ");
					 while (rs1.next()) {
						 System.out.println(rs1.getInt(1)+"\t"
					 +rs1.getString(2)+"\t"
					 +rs1.getString(3)+"\t"
					 +rs1.getString(4)+"\t"
					 +rs1.getLong(5));
					 }// end of loop
					 break;
				 case 3:
					 System.out.println("Enter customer Id :");
					 int cid = Integer.parseInt(sc.nextLine());
					 ResultSet rs2 = stm.executeQuery("select * from customer whereid = "+cid+"");
					 if(rs2.next()) {
						 System.out.println(rs2.getInt(1)+"\t"
								 +rs2.getString(2)+"\t"
								 +rs2.getString(3)+"\t"
								 +rs2.getString(4)+"\t"
								 +rs2.getLong(5));
					 }else {
						 System.out.println("Invalid customer id ");
					 }
					 break;
					 
				 case 4:
					 System.out.println("operation stopped....");
					 System.exit(0);
					 default:
						 System.out.println("Invalid choice....");
				 }//End of switch;
			 }//End of loop
		}catch (SQLIntegrityConstraintViolationException sq) 
		 {
				 System.out.println("customer details already available ...");
		 }catch (Exception e ) {
			 e.printStackTrace();
		 }
		}
	}

