package com.bridgelab.demo;


import org.junit.Assert;
import org.junit.Test;

import com.bridgelab.demo.UserValidationException.ExceptionType;

public class UserValidationTest
{

	UserValidation userValidation = new UserValidation();

	@Test
	public void PrintWelcomeMessage() {
		userValidation.PrintWelcomeMessage();
	}

	@Test
	public void given_FirstName_NULL_return_Null_Not_Allowed_Try_Again()throws UserValidationException {
		boolean result;
		try {
			result = userValidation.ValidateFirstName(null);
		} catch(UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_NULL , e.type );
		}
	}

	@Test
	public void given_FirstName_Empty_return_EmptyName_not_Allowed() throws UserValidationException {
		boolean result ;
		try {
			result = userValidation.ValidateFirstName("");
		}catch(UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_EMPTY , e.type );
		}
	}

	@Test
	public void given_FirstName_Alphanumeric_return_false() throws UserValidationException {
		boolean result;
			result = userValidation.ValidateFirstName("Mar6sh");
			Assert.assertEquals( false, result );
	}

	@Test
	public void given_LastName_CapitalLetter_return_true() throws UserValidationException {
		boolean result = false;
			result = userValidation.ValidateLastName("Shah");
			Assert.assertEquals(true, result );
	}

	@Test
	public void given_Email_when_given_Empty_return_EmptyInputNotAllowed() throws UserValidationException{
		boolean result;
		try {
			result = userValidation.ValidateEmail("");
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_EMPTY , e.type );
		}
	}

	@Test
	public void given_Email_when_given_Null_return_NullNotAllowed() throws UserValidationException{
		boolean result;
		try {
			result = userValidation.ValidateEmail(null);
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_NULL , e.type );
		}
	}

	@Test
	public void given_Email_when_emailStartswithDot_return_InvalidEmail() throws UserValidationException {
		boolean result = userValidation.ValidateEmail(".abc@gmail.com");
		Assert.assertEquals( false, result);
	}

	@Test
	public void given_PhoneNumber_with_NullValue_return_NullNotAllowed() throws UserValidationException
	{
		boolean result;
		try {
			result = userValidation.ValidatePhoneNumber(null);
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_NULL, e.type );
		}
	}

	@Test
	public void given_PhoneNumber_with_EmptyValue_return_Empty() throws UserValidationException
	{
		boolean result;
		try {
			result = userValidation.ValidatePhoneNumber("");
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_EMPTY, e.type );
		}
	}

	@Test
	public void given_PhoneNumber_with_Invalid_countryCode_return_INVALID() throws UserValidationException
	{
		boolean result = userValidation.ValidatePhoneNumber("789 4928472842");
		Assert.assertEquals(false, result );

	}

	@Test
	public void given_Strong_Password_when_given_NULL_return_NullNotAllowed() throws UserValidationException
	{
		boolean result ;
		try {
			result = userValidation.ValidatePassword(null);
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_NULL, e.type );
		}

	}

	@Test
	public void given_Strong_Password_when_given_Empty_return_EmptyInputNotAllowed() throws UserValidationException
	{
		boolean result ;
		try {
			result = userValidation.ValidatePassword("");
		} catch (UserValidationException e) {
			System.out.println(e.type+" will give message  "+ e.getMessage());
			Assert.assertEquals(UserValidationException.ExceptionType.GIVEN_EMPTY, e.type );
		}


	}

	@Test
	public void given_Strong_Password_when_given_Wrongpassword_return_InvalidPassword() throws UserValidationException
	{
		boolean result ;
			result = userValidation.ValidatePassword("cmdjbhsur8766&");
			Assert.assertEquals( false, result );
	}


	@Test
	public void given_FirstName_CapitalLetter_return_true() throws UserValidationException
	{
		boolean result = userValidation.ValidateFirstName("Rahul");
		Assert.assertEquals( true,result );
	}

	@Test
	public void given_FirstName_withMixedAlphabets_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidateFirstName("raHul");
		Assert.assertEquals( false, result );
	}


	@Test
	public void given_LastName_withMixedAlphabets_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidateLastName("Rahul");
		Assert.assertEquals(false,result );
	}


	@Test
	public void given_Email_when_given_CountryDomain_return_true() throws UserValidationException
	{
		boolean result = userValidation.ValidateEmail("abc@abc.com.au");
		Assert.assertTrue( result );
	}

	@Test
	public void given_Email_when_emailStartswithDot_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidateEmail(".abc@gmail.com");
		Assert.assertFalse( result );
	}

	@Test
	public void given_Email_containsOptional_Special_Character_return_true() throws UserValidationException
	{
		boolean result = userValidation.ValidateEmail("abc@%*.com.com");
		Assert.assertEquals( false, result );
	}

	@Test
	public void given_PhoneNumber_with_valid_countryCode_return_true() throws UserValidationException
	{
		boolean result = userValidation.ValidatePhoneNumber("91 9348239407");
		Assert.assertTrue( result );
	}

	@Test
	public void given_PhoneNumber_with_No_countryCode_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePhoneNumber("948239407");
		Assert.assertFalse( result );
	}
	@Test
	public void given_PhoneNumber_with_Invalid_countryCode_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePhoneNumber("091 9348239407");
		Assert.assertFalse( result );
	}

	@Test
	public void given_Strong_Password_when_given_correct_return_true() throws UserValidationException
	{
		boolean result = userValidation.ValidatePassword("zcsfkasHds98&");
		Assert.assertTrue( result);
	}

	@Test
	public void given_Strong_Password_when_given_incorrect_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds98&");
		Assert.assertFalse( result);
	}

	@Test
	public void given_Strong_Password_when_given_more_than_one_Specialcharacter_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds9&5%8&");
		Assert.assertEquals( result, false);
	}

	@Test
	public void given_Strong_Password_when_given_No_UpperCharacter_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds9&5");
		Assert.assertEquals( result, false);
	}

	@Test
	public void given_Strong_Password_when_given_No_Digit_return_false() throws UserValidationException
	{
		boolean result = userValidation.ValidatePassword("zCsfkasds&");
		Assert.assertEquals( result, false);
	}
}
