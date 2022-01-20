package jfsd.lesson2.emailvalidation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
	private final String[] authorizedEmails =
		{
				"person1@email.com",
				"person2@email.com",
				"person3@email.com",
				"person4@email.com",
				"person5@email.com"
		};

	public boolean grantAccess(String input) {
		String regex = "^(.+)@(.+)\\.(.+)$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches()) {
			if(Arrays.asList(authorizedEmails).contains(input))	{
				System.out.println("Access Granted!!!");
				return true;
			}
			else {
				System.out.println("Access Denied!!!");
				return false;
			}
		}
		else {
			System.out.println("Invalid email.");
			return false;
		}
	}

	public static void main(String[] args) {
		EmailValidation pv = new EmailValidation();
		Scanner sc = new Scanner(System.in);

		String input;

		try	{
			do {
				System.out.println("Enter your email (Type Q to quit):");
				input = sc.next();
				
				if(input.toLowerCase().equals("q"))
					break;
			} 
			while (!pv.grantAccess(input));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally	{
			sc.close();
		}

		System.out.println("\nBye!!");
	}
}
