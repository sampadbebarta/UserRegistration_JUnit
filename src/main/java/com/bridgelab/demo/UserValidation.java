package com.bridgelab.demo;

public class UserValidation {

	public String AnalyseMood(String message) {
		if(message.contains("Sad"))
			return "SAD";
		return "HAPPY";
	}

	public void PrintWelcomeMessage() {
		System.out.println("Welcome to the User Validation Problem");
	}

	public boolean ValidateFirstName(String firstName) {
		return firstName.matches("([A-Z][a-z]{2,})");
	}

	public boolean ValidateLastName(String lastName) {
		return lastName.matches("([A-Z][a-z]{2,})");
	}

	public boolean ValidateEmail(String email) {
		return email.matches("(^[a-zA-Z]+([._+-]{0,1}[a-zA-Z0-9]+)*@[a-zA-Z0-9]+.[a-zA-Z]{2,4}+(?:\\.[a-z]{2,}){0,1}$)");
	}

	public boolean ValidatePhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(([0-9]{2})?)[ ][0-9]{10}");
	}

	public boolean ValidatePassword(String password) {
		return password.matches("((^(?=.*[A-Z]))(?=.*[0-9])(?=.*[a-z])(?=.*[@*&^%#-*+!]{1}).{8,}$)");
	}


}
