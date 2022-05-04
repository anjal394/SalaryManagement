package SalaryMananement;
import java.util.*;


class Login{
	private static Scanner sc = new Scanner(System.in);
	static void login() {
		
		
		int user = sc.nextInt();
		switch(user) {
		case 1:
			AdminLogin.login();
			break;
		case 2:
			EmployeeLogin.login();
			break;
		default:
	
		System.out.println("Unauthorized user");
		}
		
		
	}
}


public class UserAccess {

	public static void main(String[] args) {
		System.out.println("Please select user access option. 1) admin. 2) employee");
		Login login =new Login();
		Login.login();

	}

}
