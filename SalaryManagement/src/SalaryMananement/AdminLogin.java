package SalaryMananement;

import java.sql.*;
import java.util.Scanner;

class AdminLogin {
	private static Connection c = null;
	private Statement s;
	public static void login() {
//		Connection c;
//		Statement s;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/Salarymanagement";
			String user="root";
			String password="Anjali@2903";
			c=DriverManager.getConnection(url,user,password);
			//s=c.createStatement();
			System.out.println("Please enter from 1-3 for:");
			System.out.println("1. Employee Details  2. Employee Salary Details");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("select option to 1. insert");
				int select1 = sc.nextInt();
				switch(select1) {
				case 1:
					insertRecordInToEmployeeDetails();
					break;
				
				default:
					System.out.println("Wrong input");
					
				}
	
		
				
			case 2:
				System.out.println("select option to 1. insert, 2. update, 3. delete");
				int select2 = sc.nextInt();
				switch(select2) {
				case 1:
					insertRecordInToEmployeeSalaryDetails();
					break;
				case 2:
					updateRecordInToEmployeeSalaryDetails();
					break;
				case 3:
					deleteRecordInEmployeeSalaryDetails();
					break;
				default:
					System.out.println("Wrong input");
					
				}
				
				
			
				
			default:
				System.out.println("please enter correct input");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//*********************************************************************************************************************
	
	
	private static void insertRecordInToEmployeeDetails() throws Exception {
		String s1="insert into employeedetails values(?,?,?,?,?,?)";
		PreparedStatement pre= c.prepareStatement(s1);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Employee ID");
		int emp_id = sc.nextInt();
		pre.setInt(1, emp_id);
		System.out.println();
		sc.nextLine();
		
		System.out.println("Employee Name");
		String emp_name = sc.nextLine();
		pre.setString(2, emp_name);
		
		System.out.println();
		
		System.out.println("Employee Designation");
		String emp_desig = sc.nextLine();
		pre.setString(3, emp_desig);
		
		System.out.println();
		
		System.out.println("Employee Ddate of birth");
		String emp_dob = sc.nextLine();
		pre.setString(4, emp_dob);
		
		System.out.println();
		
		System.out.println("Employee Date of joining");
		String emp_doj = sc.nextLine();
		pre.setString(5, emp_doj);
		
		System.out.println();
	
		
		System.out.println("Employee Gender");
		String emp_gender = sc.nextLine();
		pre.setString(6, emp_gender);
		
		System.out.println();
		
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Employee Record inserted succesfully");
		}
		
	}
	
	
	//*********************************************************************************************************************
	
	
	
	private static void insertRecordInToEmployeeSalaryDetails() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		String s1="insert into employeesalary values(?,?,?,?,?,?)";
		PreparedStatement pre= c.prepareStatement(s1);
		
		System.out.println("Employee ID");
		int emp_id = sc.nextInt();
		pre.setInt(1, emp_id);
		
		System.out.println("Month Number");
		int month_no = sc.nextInt();
		pre.setInt(2, month_no);

		
		System.out.println("Employee's Attendance in that month");
		int emp_attend = sc.nextInt();
		pre.setInt(3, emp_attend);
		
		System.out.println("Employee's Basic salary per month");
		double emp_grosssalary_permonth = sc.nextDouble();
		pre.setDouble(4, emp_grosssalary_permonth);
		
		double a = emp_grosssalary_permonth/10;
		
		pre.setDouble(5, a);
		
		double b = a+emp_grosssalary_permonth;
		
		pre.setDouble(6, b);
		
		
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Employee salary record inserted succesfully");
		}
	}



	//*********************************************************************************************************************
	
	
	
	
	private static void updateRecordInToEmployeeSalaryDetails() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int emp_id = sc.nextInt();
		System.out.println("Enter employee new salary");
		int emp_sal = sc.nextInt();
		String sq1="update employeesalary set base_salary="+emp_sal+" where emp_id = "+emp_id;
		PreparedStatement pq =c.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record updated succesfully");
		}
		String sq="select * from employeesalary";
		Statement st= c.createStatement();
		ResultSet rt=st.executeQuery(sq);

		
	}
	

	
	//*********************************************************************************************************************
	
	private static void deleteRecordInEmployeeSalaryDetails() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id that you want to delete");
		int emp_id = sc.nextInt();
		
		
		String sq1="delete from employeesalary where emp_id="+emp_id;
		PreparedStatement pq =c.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record deleted succesfully");
		}
		String sq="select * from employeesalary";
		Statement st= c.createStatement();
		ResultSet rt=st.executeQuery(sq);
		while(rt.next()) {
			String employee_id = rt.getString("emp_id");
			System.out.println(employee_id);
	
		}
		
	}
	
	//************************************************************************************************************************
}


