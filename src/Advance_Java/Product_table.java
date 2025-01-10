package Advance_Java;
import java.sql.*;
import java.util.*;
import java.lang.*;


/*Construct JDBC Application to perform the following operations on Product table
1.AddProduct
2.ViewAllProducts
3.ViewProductByCode*/

public class Product_table 
{
	public static void main(String[] args) throws SQLException 
	{
	Scanner sc = new Scanner(System.in);
	try(sc;){
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","tiger");
	    Statement st = con.createStatement();

	    ResultSet rs1 = st.executeQuery("select * from product70");
	    while(true) {
	    	System.out.println("----product Details----");
	    	System.out.println("\t1.AddProduct" 
					 + "\n\t2.viewAllProduct"
					 + "\n\t3.Viewproductbycode"
					 + "\n\t4.Exit");
	    System.out.println("Enter your choice");
	    int choice = Integer.parseInt(sc.nextLine());
	    switch (choice) {
	    case 1:
	    	System.out.println("-----product Details-----");
			 System.out.println("Enter product code");
			 int code = Integer.parseInt(sc.nextLine());
			 System.out.println("Enter product name ");
			 String name = sc.nextLine();
			 System.out.println("Enter price price");
			 String price = sc.nextLine();
			 System.out.println("Enter product Qty");
			 String Qty = sc.nextLine();
			   
			 int k = st.executeUpdate("insert into product70 values("+code+"','"+name+"','"+price+"','"+Qty+");");
			 if(k>0)
			 {
			System.out.println("product Added Successfully");
			ResultSet rs2 = st.executeQuery("select * from product70");
			 while (rs2.next()) {
				 System.out.println(rs2.getString(1)+"\t"
			 +rs2.getString(2)+"\t"
			 +rs2.getInt(3)+"\t"
			 +rs2.getInt(4));
			 }
			 }
	    	break;
	    case 2:
	    	ResultSet rs3 = st.executeQuery("select * from product70");
	    	while (rs3.next()) {
	    		System.out.println(rs3.getString(1)+"\t"
	    	+ rs3.getString(2)+"\t"
	        + rs3.getInt(3)+"\t"
	    	+rs3.getInt(4));
	    	}
	    	break;
	    case 3:
	    	 System.out.println("Enter customer Id :");
			 int pc = Integer.parseInt(sc.nextLine());
			
	    	ResultSet rs4 = st.executeQuery("select * from product70 whereid ="+pc+"");
	    	if(rs4.next()) {
	    		System.out.println(rs4.getString(1)+"\t"
	    	+ rs4.getString(2)+"\t"
	        + rs4.getInt(3)+"\t"
	    	+rs4.getInt(4));
	    	}else {
	    		System.out.println("Invalid code :");
	    	}
	    	break;
	    case 4:
	    	System.exit(0);
	    	break;
	    	default:
	    		System.out.println("invalid choice");
	    		}
	    
	    }
	    
	}catch(java.sql.SQLSyntaxErrorException sq) {
		System.out.println("Something is missing");
	}
	catch (SQLIntegrityConstraintViolationException sq) {
		System.out.println("customer already exits");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}
