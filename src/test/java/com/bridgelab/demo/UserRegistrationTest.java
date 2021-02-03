package com.bridgelab.demo;

import org.junit.Assert;
import org.junit.Test;

public class UserValidationTest
{

	UserValidation userValidation = new UserValidation();

	@Test
	public void PrintWelcomeMessage() {
		userValidation.PrintWelcomeMessage();
	}

	@Test
	public void Given_Message_When_Sad_Should_Return_Sad() {
		String mood = userValidation.AnalyseMood("This is a Sad Message");
		Assert.assertEquals("SAD", mood);
	}

	@Test
	public void Given_Message_When_Happy_Should_Return_Happy() {
		String mood = userValidation.AnalyseMood("This is a Happy Message");
		Assert.assertEquals("HAPPY", mood);
	}

	@Test
	public void given_FirstName_CapitalLetter_return_true()
	{
		boolean result = userValidation.ValidateFirstName("Sampad");
		Assert.assertTrue( result );
	}

	@Test
	public void given_FirstName_withMixedAlphabets_return_false()
	{
		boolean result = userValidation.ValidateFirstName("SAmpad");
		Assert.assertFalse( result );
	}

	@Test
	public void given_FirstName_Alphanumeric_return_false()
	{
		boolean result = userValidation.ValidateFirstName("Sam6ad");
		Assert.assertFalse( result );
	}

	@Test
	public void given_LastName_CapitalLetter_return_true()
	{
		boolean result = userValidation.ValidateLastName("Rahul");
		Assert.assertTrue( result );
	}

	@Test
	public void given_LastName_withMixedAlphabets_return_false()
	{
		boolean result = userValidation.ValidateLastName("RAhul");
		Assert.assertFalse( result );
	}

	@Test
	public void given_LastName_Alphanumeric_return_false()
	{
		boolean result = userValidation.ValidateLastName("Ra6ul");
		Assert.assertEquals( result, false );
	}

	@Test
	public void given_Email_when_given_CountryDomain_return_true()
	{
		boolean result = userValidation.ValidateEmail("abc@abc.com.au");
		Assert.assertTrue( result );
	}

	@Test
	public void given_Email_when_emailStartswithDot_return_false()
	{
		boolean result = userValidation.ValidateEmail(".abc@gmail.com");
		Assert.assertFalse( result );
	}

	@Test
	public void given_Email_containsOptional_Special_Character_return_true()
	{
		boolean result = userValidation.ValidateEmail("abc@%*.com.com");
		Assert.assertEquals( false, result );
	}

	@Test
	public void given_PhoneNumber_with_valid_countryCode_return_true()
	{
		boolean result = userValidation.ValidatePhoneNumber("91 9348239407");
		Assert.assertTrue( result );
	}

	@Test
	public void given_PhoneNumber_with_No_countryCode_return_false()
	{
		boolean result = userValidation.ValidatePhoneNumber("9348239407");
		Assert.assertFalse( result );
	}
	@Test
	public void given_PhoneNumber_with_Invalid_countryCode_return_false()
	{
		boolean result = userValidation.ValidatePhoneNumber("091 9348239407");
		Assert.assertFalse( result );
	}

	@Test
	public void given_Strong_Password_when_given_correct_return_true()
	{
		boolean result = userValidation.ValidatePassword("zcsfkasHds98&");
		Assert.assertTrue( result);
	}

	@Test
	public void given_Strong_Password_when_given_incorrect_return_false()
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds98&");
		Assert.assertFalse( result);
	}

	@Test
	public void given_Strong_Password_when_given_more_than_one_Specialcharacter_return_false()
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds9&5%8&");
		Assert.assertEquals( result, false);
	}

	@Test
	public void given_Strong_Password_when_given_No_UpperCharacter_return_false()
	{
		boolean result = userValidation.ValidatePassword("zcsfkasds9&5");
		Assert.assertEquals( result, false);
	}

	@Test
	public void given_Strong_Password_when_given_No_Digit_return_false()
	{
		boolean result = userValidation.ValidatePassword("zCsfkasds&");
		Assert.assertEquals( result, false);
	}
}
