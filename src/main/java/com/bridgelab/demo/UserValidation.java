package com.bridgelab.demo;

public class UserValidation {
    public static void main(String[] args) {
        System.out.println("WELCOME TO USER REGISTRATION");
    }
    public static String validateFirstAndLastName(String fname) {
        String firstNamePattern = "^[A-Z]{1}[a-zA-Z]{3,}$";
        if (fname.matches(firstNamePattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public static String validateEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9]{3,}([+-._]{1}[a-zA-Z0-9]+)?[@]{1}[a-zA-Z0-9]+[.]{1}[a-z]{2,3}([.]{1}[a-zA-Z]{2,3})?$";
        if (email.matches(emailPattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public static String validateMobileNumber(String mobilenumber) {
        String mobileNumberPattern = "^[1-9]{1,3}[ ][0-9]{10}$";
        if (mobilenumber.matches(mobileNumberPattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public static String validateEightCharacterPassword(String password) {
        String passwordRuleOnePattern = "^[a-zA-Z]{8,}";
        if (password.matches(passwordRuleOnePattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public String validatePasswordWithAtLeastOneCapitalLetter(String password) {
        String passwordRuleTwoPattern="^(?=.*[A-Z])[a-zA-Z]{8,}$";
        if (password.matches(passwordRuleTwoPattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public static String validatePasswordWithAtLeastOneNumericNumber(String password) {
        String passwordRuleThreePattern = "^(?=.*[A-Z])(?=.*[\\d])[a-zA-Z0-9]{8,}$";
        if (password.matches(passwordRuleThreePattern)) {
            return "Valid";
        }
        return "Invalid";
    }
    public String validatePasswordWithAtLeastOneSpecialCharacter(String password) {
        String passwordRuleFourPattern= "^((?=[^\\W]*[\\W][^\\W]*$))(?=.*[A-Z])(?=.*[\\d])(?=.*[a-z])[A-za-z0-9\\W].{8,}$";
        if (password.matches(passwordRuleFourPattern))
        {
            return "Valid";
        }
        return "Invalid";
    }
}
