package com.bridgelab.demo;
import org.junit.*;

public class UserRegistrationTest {
    UserRegistration userRegistration;

    public static final String firstNamePattern ="^[A-Z][a-z]{2,}$";
    public static String lastNamePattern = "^[A-Z][a-z]{2,}$";
    private static String email = "^[\\w-_\\.?+]{2,}[\\w]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static String phoneNumber ="^[1-9]{2}[-][6-9][0-9]{9}$";

    private static String passwordFirstRule ="^[a-zA-Z0-9]{8,}";
    private static String passwordSecondRule = "^[A-Z]{1,}[a-zA-Z0-9]{7,}";
    private static String passwordThirdRule = "^[0-9]{1,}[a-zA-Z0-9]{7,}";

    @Before
    public void setup(){
        userRegistration =new UserRegistration();
    }
    @Test
    public void givenFirstName_whenProper_shouldReturnTrue() {
        try {
            String firstName = "Sampad";
            boolean userFirstName = userRegistration.validateUserFirstName(firstName);
            Assert.assertTrue(userFirstName);
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
    }

    @Test
    public void givenFirstName_startingWithSmallerLetter_shouldReturnFalse() {
        try {
            String firstName = "sampad";
            boolean userFirstName = userRegistration.validateUserFirstName(firstName);
            Assert.assertFalse(userFirstName);
        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }

    }

    @Test
    public void givenFirstName_byLengthWhenInvalid_shouldReturnFalse(){
        String firstName="Sa";
        boolean userFirstName= false;
        try {
            userFirstName = userRegistration.validateUserFirstName(firstName);
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        Assert.assertFalse(userFirstName);
    }
    @Test
    public void givenLastName_whenProper_shouldReturnTrue(){
        String lastName="Bebarta";
        boolean userLastName= false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException myException) {
            myException.printStackTrace();
        }
        Assert.assertTrue(userLastName);
    }

    @Test
    public void givenLastName_startingWithSmallerLetter_shouldReturnFalse(){
        String lastName="bebarta";
        boolean userLastName= false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException myException) {
            myException.printStackTrace();
        }
        Assert.assertFalse(userLastName);
    }
    @Test
    public void givenLastName_byLengthWhenInvalid_shouldReturnFalse() {
        String lastName = "Be";
        boolean userLastName = false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException myException) {
            myException.printStackTrace();
        }
        Assert.assertFalse(userLastName);
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() {
        String email = "abc.xyz@bl.co.in";
        boolean userEmail = true;
        try{
            userEmail = userRegistration.validateEmail(email);

        }catch (MyException myException){
           myException.printStackTrace();
        }
        Assert.assertTrue(userEmail);
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnFalse() {
        String email = "567@bl";
        boolean userEmail = false;
        try{
            userEmail = userRegistration.validateEmail(email);

        }catch (MyException myException){
            myException.printStackTrace();
        }
        Assert.assertFalse(userEmail);
    }
    public void givenMobileNumberWithCountryCode_whenProper_shouldReturnTrue() {
        String mobileNumber="91-9348239407";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(userMobileNumber);
    }
    @Test
    public void givenMobileNumberWithoutCountryCode_whenInvalid_shouldReturnFalse() {
        String mobileNumber="9348239407";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException myexception) {
            myexception.printStackTrace();
        }
        Assert.assertFalse(userMobileNumber);
    }
    @Test
    public void givenMobileNumberLessThenTenDigit_whenInvalid_shouldReturnFalse() {
        String mobileNumber="91-934823940";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException myexception) {
            myexception.printStackTrace();
        }
        Assert.assertFalse(userMobileNumber);
    }

    @Test
    public void givenPasswordHavingMinimumEightCharacters_whenValid_shouldReturnTrue(){
        String password="dgfghhhjA";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordFirstRule(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingLessThenEightCharacters_whenInvalid_shouldReturnFalse(){
        String password="dghjA";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordFirstRule(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingAtleastOneUpperCase_whenValid_shouldReturnTrue(){
        String password="Aghhhjjj";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingNotUpperCase_whenInvalid_shouldReturnFalse(){
        String password="rghhhjjj";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingNumericValue_whenInvalid_shouldReturnFalse(){
        String password="23456789";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }

    @Test
    public void givenPasswordHavingAtleastNumericNumber_whenValid_shouldReturnTrue(){
        String password="1ghhhjjj";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingNumericNumber_whenInvalid_shouldReturnFalse(){
        String password="ywwidjAjj";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingEightCharacters_whenInvalid_shouldReturnFalse(){
        String password="123456";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingExactlyOneSpecialCharacters_whenValid_shouldReturnTrue(){
        String password="#14AAa94@aayu";
        boolean passwordRule = false;
        try {
            passwordRule = userRegistration.validatePasswordFourthRuleExactlyOneSpecialCharacter(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordRule);
    }
    @Test
    public void givenFirstname_whenProper_shouldReturnTrue(){
        boolean result= userRegistration .validation("Sampad" ,firstNamePattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenFirstname_startingWithSmallerLetter_shouldReturnFalse() {
        boolean result= userRegistration.validation("sampad" ,firstNamePattern);
        Assert.assertFalse(result);
    }

    @Test
    public void givenFirstname_byLengthWhenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("Sa" ,firstNamePattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenLastname_whenProper_shouldReturnTrue(){
        boolean result= userRegistration.validation("Bebarta" ,lastNamePattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastname_startingWithSmallerLetter_shouldReturnFalse() {
        boolean result= userRegistration.validation("bebarta" ,lastNamePattern);
        Assert.assertFalse(result);
    }

    @Test
    public void givenLastname_byLengthWhenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("Be",lastNamePattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenMobilenumberWithCountryCode_whenProper_shouldReturnTrue() {
        boolean result= userRegistration.validation("91-9348239407" ,phoneNumber);
        Assert.assertTrue(result);
    }
    @Test
    public void givenMobilenumberWithoutCountryCode_whenInvalid_shouldReturnFalse() {
        boolean result= userRegistration.validation("9348239407" ,phoneNumber);
        Assert.assertFalse(result);
    }
    @Test
    public void givenMobilenumberLessThenTenDigit_whenInvalid_shouldReturnFalse() {
        boolean result= userRegistration.validation("91-934823940" ,phoneNumber);
        Assert.assertFalse(result);

    }
    @Test
    public void givenPasswordHavingMinimumeightCharacters_whenValid_shouldReturnTrue(){
        boolean result= userRegistration.validation("adghhfrt" ,passwordFirstRule);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPasswordHavingLessTheneightCharacters_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("afrt" ,passwordFirstRule);
        Assert.assertFalse(result);
    }
    @Test
    public void givenPasswordHavingatleastOneUpperCase_whenValid_shouldReturnTrue(){
        boolean result= userRegistration.validation("Abcdefghi" ,passwordSecondRule);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPasswordHavingnotUpperCase_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("abcdefghi" ,passwordSecondRule);
        Assert.assertFalse(result);
    }
    @Test
    public void givenPasswordHaving_NumericValue_whenInvalid_shouldReturnFalse() {
        boolean result = userRegistration.validation("23456789", passwordSecondRule);
        Assert.assertFalse(result);
    }


    @Test
    public void givenPasswordHavingatleastNumericNumber_whenValid_shouldReturnTrue(){
        boolean result= userRegistration.validation("2dfghijk" ,passwordThirdRule);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_NotHavingNumericNumber_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("dfghijkty" ,passwordThirdRule);
        Assert.assertFalse(result);
    }
    @Test
    public void givenPassword_NotHavingEightCharacters_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("dfgh2" ,passwordThirdRule);
        Assert.assertFalse(result);
    }

}
