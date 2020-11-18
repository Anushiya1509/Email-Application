package mini;

import java.util.Scanner;

public class EmailApp {
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		Email user = null;
		
		while(true) {
			
			System.out.println("1 - New User\n"
					+ "2 - Change Mailbox capacity\n"
					+ "3 - Change password\n"
					+ "4 - Display\n"
					+ "0 - Exit");
			
			System.out.println("Enter your choice : ");
			int choice = s.nextInt();
			s.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter First name : ");
				String Fn = s.nextLine();
				System.out.println("Enter Last name : ");
				String Ln = s.nextLine();
				user = new Email(Fn, Ln);
				break;
			case 2:
				if(user==null)
					System.out.println("Error: First create an user");
				else
					user.changeMailBoxCapacity();
				break;
			case 3:	
				if(user==null)
					System.out.println("Error: First create an user");
				else
					user.changePassword();
				break;
			case 4:
				if(user==null)
					System.out.println("Error: First create an user");
				else
					user.display();
				break;
			case 0:
				System.exit(0);
			}
		}
		
	}

}
