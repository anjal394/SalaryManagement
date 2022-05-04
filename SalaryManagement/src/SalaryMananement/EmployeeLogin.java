package SalaryMananement;


import java.sql.*;
import java.util.Scanner;


public class EmployeeLogin {
	private static Connection c =null;
	private static Statement s;
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/Salarymanagement";
			String user="root";
			String password="Anjali@2903";
			c=DriverManager.getConnection(url,user,password);
			s=c.createStatement();
			System.out.println("Please enter 1 to get your payslips");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				payslips();
				break;
			default:
				System.out.println("please enter correct input");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		

		
	}
	public static void payslips() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int a=sc.nextInt();
		String sq="Select employeedetails.emp_name, employeedetails.emp_id, employeedetails.emp_designation, employeedetails.emp_doj, employeesalary.base_salary, employeesalary.increment, employeesalary.total_salary from employeedetails join employeesalary where employeedetails.emp_id = "+a + " and employeesalary.emp_id="+a;
		PreparedStatement preparedStatement=c.prepareStatement(sq);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet!=null) {
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.println("Employee id |EmploIndexesyee Name|Employee Designation|Employee Category" );
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
		}
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("employeedetails.emp_id")+"          "+resultSet.getString("employeedetails.emp_name")+"          "+resultSet.getString("employeedetails.emp_designation")+"          "+resultSet.getDouble("employeesalary.base_salary")+"          "+resultSet.getDouble("employeesalary.increment")+"          "+resultSet.getDouble("employeesalary.total_salary"));
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		
	}
	
}

	

