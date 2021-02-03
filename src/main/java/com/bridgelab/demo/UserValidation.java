package com.bridgelab.demo;

public class UserValidation {

	public void PrintWelcomeMessage() {
		System.out.println("Welcome to the User Validation Problem");
	}

	public void IsEmptyorNullString(String input) throws UserValidationException {
		try {
			if (input.length() == 0) {
				throw new UserValidationException( UserValidationException.ExceptionType.GIVEN_EMPTY, " Empty Input Not Allowed Please Enter Again");
			}
		}
		catch(NullPointerException e)
		{
			throw new UserValidationException( UserValidationException.ExceptionType.GIVEN_NULL, "Null Not Allowed Please Enter Again ");

		}
	}

	public boolean ValidateFirstName(String firstName) throws UserValidationException {
		IsEmptyorNullString(firstName);
		boolean  matcher = firstName.matches("([A-Z][a-z]{2,})");
		if(matcher == true) {
			return matcher;
		}
		return matcher;
	}

	public boolean ValidateLastName(String lastName) throws UserValidationException {
		IsEmptyorNullString(lastName);
		boolean matcher = lastName.matches("([A-Z][a-z]{2,})");
		if(matcher == true) {
			return matcher;
		}
		return matcher;

	}

	public boolean ValidateEmail(String email) throws UserValidationException {
		IsEmptyorNullString(email);
		boolean matcher = email.matches( "^[a-zA-Z]+([._+-]{0,1}[a-zA-Z0-9]+)*@[a-zA-Z0-9]+.[a-zA-Z]{2,4}+(?:\\.[a-z]{2,}){0,1}$");
		if(matcher == true) {
			return matcher;
		}
		else
			return matcher;
	}

	public boolean ValidatePhoneNumber(String phoneNumber) throws UserValidationException {
		IsEmptyorNullString(phoneNumber);
		boolean matcher = phoneNumber.matches("(([0-9]{2})?)[ ][0-9]{10}");
		if(matcher) {
			System.out.println("Valid Mobile Number");
			return matcher;
		}
		return false;

	}

	public boolean ValidatePassword(String password) throws UserValidationException {
		IsEmptyorNullString(password);
		boolean matcher = password.matches("(^(?=.*[A-Z]))(?=.*[0-9])(?=.*[a-z])(?=.*[@*&^%#-*+!]{1}).{8,}$");

		if(matcher) {
			System.out.println("Valid Password");
			return matcher;
		}
		return false;

	}
}
