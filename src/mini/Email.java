package mini;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity;
	private String alternateEmail;
	final private int passwordLength = 10;
	
	private static Scanner s = new Scanner(System.in);
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		this.password = randomPassword(this.passwordLength);
		this.email = setEmail();
		this.mailBoxCapacity = setMailBoxCapacity();
		this.alternateEmail = getAlternateEmail();
		display();
		System.out.println("User created");
	}
	
	private String setDepartment() {
		System.out.println("Departments :-\n1. Sales\n2. Development\n3. Accounting\nEnter your Department : ");
		int dept = s.nextInt();
		s.nextLine();
		switch(dept) {
		case 1:
			return "Sales";
		case 2:
			return "Development";
		case 3:
			return "Accounting";
		default:
			System.out.println("Invalid Department\n");
			return setDepartment();
		}
	}
	
	private String randomPassword(int len) {
		String password = "";
		char[] passwordSet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0','!','@','$','%','&'};
		for(int i=0; i<len; i++)
			password += passwordSet[(int)Math.floor(Math.random()*passwordSet.length)];
		return password;
	}
	
	private String setEmail() {
		return this.firstName + "." + this.lastName + "@" + department + ".company.com";
	}
	
	private int setMailBoxCapacity() {
		System.out.println("Enter mailbox capacity : ");
		int cap = s.nextInt();
		s.nextLine();
		return cap;
	}
	
	public void changeMailBoxCapacity() {
		this.mailBoxCapacity = setMailBoxCapacity();
		System.out.println("Mail box capacity changed successfully!");
		display();
	}
	
	private String getAlternateEmail() {
		System.out.println("Enter your alternate email : ");
		return s.nextLine();
	}
	
	public void changePassword() {
		int choice;
		System.out.println("Enter your current password : ");
		String str = s.nextLine();
		if(str.equals(this.password)) {
			System.out.println("Enter your new password : ");
			this.password = s.nextLine();
			System.out.println("Password changed successfully!");
			display();
		}
		else {
			System.out.println("Error : Current password is incorrect\nPress 1 to try again ");
			choice = s.nextInt();
			s.nextLine();
			if(choice == 1)
				changePassword();
		}
	}
	
	public void display() {
		System.out.println("First name : " + this.firstName + "\n"
				+ "Last name : " + this.lastName + "\n"
						+ "Password : " + this.password + "\n"
								+ "Department : " + this.department + "\n"
										+ "Company Email : " + this.email + "\n"
												+ "Mailbox Capacity : " + this.mailBoxCapacity + "\n"
														+ "Alternate email : " + this.alternateEmail);
	}
}
