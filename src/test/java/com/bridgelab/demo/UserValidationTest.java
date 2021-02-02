package com.bridgelab.demo;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_WhenProper_ShouldReturnValid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("Shraddha");
        Assert.assertEquals("Valid",result);
    }
    @Test
    public void givenFirstName_WhenInproper_ShouldReturnInvalid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("shraddha");
        Assert.assertEquals("Invalid",result);
    }
    @Test
    public void givenLastName_WhenProper_ShouldReturnValid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("Meshram");
        Assert.assertEquals("Valid",result);
    }
    @Test
    public void givenLastName_WhenInproper_ShouldReturnInvalid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("meshram");
        Assert.assertEquals("Invalid",result);
    }
    @Test
    public void givenEmail_WhenProper_ShouldReturnValid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateEmail("abc@yahoo.com");
        Assert.assertEquals("Valid",result);
    }
    @Test
    public void givenEmail_WhenInproper_ShouldReturnInvalid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateEmail("abc@%*.com");
        Assert.assertEquals("Invalid",result);
    }
}
