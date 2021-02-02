package com.bridgelab.demo;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_WhenProper_ShouldReturnValid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("Sampad");
        Assert.assertEquals("Valid",result);
    }
    @Test
    public void givenFirstName_WhenInproper_ShouldReturnInvalid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("sampad");
        Assert.assertEquals("Invalid",result);
    }
    @Test
    public void givenLastName_WhenProper_ShouldReturnValid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("Rahul");
        Assert.assertEquals("Valid",result);
    }
    @Test
    public void givenLastName_WhenInproper_ShouldReturnInvalid() {
        UserValidation userValidation = new UserValidation();
        String result=userValidation.validateFirstAndLastName("rahul");
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
