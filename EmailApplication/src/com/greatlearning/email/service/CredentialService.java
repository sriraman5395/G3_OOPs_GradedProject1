package com.greatlearning.email.service;

import java.util.Random;

import com.greatlearning.email.model.Employee;


public class CredentialService implements ICredentialService{
	
	private String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lower = "abcdefghijklmnopqrstuvwxyz";
	private String number = "0123456789";
	private String splChar = "!@#$%^&*()_+=?:";
	private String passwordChars = upper + lower + number + splChar;
	private Random random = new Random();
	
	@Override
	public void generateEmail(Employee employee) {
		String emailAddress = employee.getFirstName().toLowerCase()+employee.getLastName().toLowerCase()
								+"@"+employee.getDepartment()+".gl.in";
		employee.setEmailAddress(emailAddress);
	}

	@Override
	public void generatePassword(Employee employee) {
		String password = "";
		for(int i=0;i<8;i++) {
			password = password + passwordChars.charAt(random.nextInt(passwordChars.length()));
		} // String passwordChars = "ABC..abc..012..!@#$"; char ch = data.charAt(); //random.nextInt(77) -- 0...76 -- 33
		employee.setPassword(password);
		for(int i=0;i<8;i++) {
			password = password +  (char) (random.nextInt(126 -33) + 33 );
		} 
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Dear "+ employee.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email\t\t: "+ employee.getEmailAddress());
		System.out.println("Password\t: "+ employee.getPassword());
	}
	
}
