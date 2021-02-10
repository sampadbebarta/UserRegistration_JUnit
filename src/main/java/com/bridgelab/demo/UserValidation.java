package com.bridgelab.demo;

import java.util.regex.Pattern;
@FunctionalInterface
interface IUserValidation {

    boolean validateUser(String userInput,String pattern);
}
public class UserValidation {
    private static Pattern FIRST_NAME_PATTERN = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern LAST_NAME_PATTERN = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern EMAIL = Pattern.compile("^[\\w-_\\.?+]{2,}[\\w]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    private static Pattern PHONE_NUMBER =Pattern.compile("^[1-9]{2}[-][6-9][0-9]{9}$");
    private static Pattern PASSWORD_FIRST_RULE =Pattern.compile("^[a-zA-Z0-9]{8,}");
    private static Pattern PASSWORD_SECOND_RULE = Pattern.compile("^[A-Z]{1,}[a-zA-Z0-9]{7,}");
    private static Pattern PASSWORD_THIRD_RULE = Pattern.compile("^[0-9]{1,}[a-zA-Z0-9]{7,}");
    private static Pattern PASSWORD_FOURTH_RULE = Pattern.compile("^[A-Z0-9a-z.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");

    boolean isValid = false;
    static boolean isValidEmail=false;
    public boolean validateUserFirstName(String firstName) throws MyException {
        isValid=FIRST_NAME_PATTERN.matcher(firstName).matches();
        if(!isValid){
            throw new MyException("FirstNameShouldStartsWithCapsLetter");
        }

        return isValid;
    }

    public boolean validateUserLastName(String lastName) throws MyException {
        isValid=LAST_NAME_PATTERN.matcher(lastName).matches();
        if(!isValid){
            throw new MyException("LastNameShouldStartsWithCapsLetter");
        }
        return isValid;
    }

    public static boolean validateEmail(String email)throws MyException {
        isValidEmail = EMAIL.matcher(email).matches();
        if(!isValidEmail){
            throw new MyException("EmailFormatBeProper");
        }
        return isValidEmail;

    }
    public boolean validateUserMobileNumber(String mobileNumber)throws MyException {
        isValid=PHONE_NUMBER.matcher(mobileNumber).matches();
        if (!isValid){
            throw new MyException("giveProperPhoneNumber");
        }
        return isValid;
    }
    public boolean validatePasswordFirstRule(String password)throws MyException{
        isValid=PASSWORD_FIRST_RULE.matcher(password).matches();
        if (!isValid){
            throw new MyException("PasswordShouldBeMinimumEightCharacter");
        }
        return isValid;
    }
    public boolean validatePasswordSecondRuleAtleastOneUpperCase(String password)throws MyException {
        isValid=PASSWORD_SECOND_RULE.matcher(password).matches();
        if (!isValid){
            throw new MyException("PasswordAtLeastContainOneUpperCaseLetter");
        }
        return isValid;
    }
    public boolean validatePasswordThirdRuleAtleastOneNumericNumber(String password)throws MyException{
        isValid=PASSWORD_THIRD_RULE.matcher(password).matches();
        if (!isValid){
            throw new MyException("PasswordAtLeastContainNumericLetter");
        }
        return isValid;
    }
    public boolean validatePasswordFourthRuleExactlyOneSpecialCharacter(String password)throws MyException{
        isValid=PASSWORD_FOURTH_RULE.matcher(password).matches();
        if (!isValid){
            throw new MyException("PasswordAtLeastContainSpecialCharacter");
        }
        return isValid;
    }
    public boolean validation(String name,String Pattern){
        IUserRegistration iUserRegistration = ((userInput, pattern) -> userInput.matches(pattern));
        return iUserRegistration.validateUser(name,Pattern);
    }

}
