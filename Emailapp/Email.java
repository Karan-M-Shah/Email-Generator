package Emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String company = "company.com";
	
	//Constructor 
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		
		this.password = generatePassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password);
		
		//Combine properties to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + company; 
	}
	
	//Ask for the department
	private String setDepartment()
	{
		System.out.print("DEPARTMENT CODES\n1 for sales\n2 for development\n3 for accounting\n0 for none\nEnter department Code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1)
		{
			return "Sales";
		}
		else if (deptChoice == 2)
		{
			return "Development";
		}
		else if (deptChoice == 3)
		{
			return "Accounting";
		}
		else
		{
			return "Nothing";
		}
	}
	
	//Generate password
	private String generatePassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set mailbox capacity
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	
	//Set alternate email
	public void setAltEmail(String altEmail)
	{
		this.alternateEmail = altEmail;
	}
	
	//Change password
	public void changePass(String password)
	{
		this.password = password;
	}
	
	public int getMailboxCapacity()
	{
		return mailboxCapacity;
	}
	
	public String getAlternateEmail()
	{
		return alternateEmail;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String showInfo()
	{
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity;
	}
}
