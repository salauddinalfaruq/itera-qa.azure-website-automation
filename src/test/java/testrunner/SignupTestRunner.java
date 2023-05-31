package testrunner;

import base.Setup;
import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;

public class SignupTestRunner extends Setup {

    SignupPage signupPage;
    Utils utils;


    @Test(priority = 1)
    public void clickOnSubmitButtonWithoutFillAnyCredentials() throws InterruptedException, IOException, ParseException {
        signupPage = new SignupPage(driver);
        driver.get("https://itera-qa.azurewebsites.net/");
        String actualErrorText = signupPage.clickOnSubmitButtonWithoutFillAnyFiled();
        String expectedErrorText = "Please enter first name";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }

    @Test(priority = 2)
    public void clickOnSubmitButtonWithOnlyFillFirstName() throws InterruptedException {
        signupPage = new SignupPage(driver);
        String actualErrorText = signupPage.clickOnSubmitButtonWithOnlyFillFirstName();
        String expectedErrorText = "Please enter surname";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }


    @Test(priority = 3)
    public void clickOnSubmitButtonWithFillFirstAndSurName() throws InterruptedException {
        signupPage = new SignupPage(driver);
        String actualErrorText = signupPage.clickOnSubmitButtonWithFillingFirstAndSurName();
        String expectedErrorText = "Please enter username";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }

    @Test(priority = 4)
    public void clickOnSubmitButtonWithFillingFirstnameSurnameAndUsername() throws InterruptedException {
        signupPage = new SignupPage(driver);
        String actualErrorText = signupPage.clickOnSubmitButtonWithFillingFirstSurnameAndUsername();
        String expectedErrorText = "Please enter password";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }

    @Test(priority = 5)
    public void clickOnSubmitButtonWithoutFillingConfirmPassword() throws InterruptedException {
        signupPage = new SignupPage(driver);
        String actualErrorText = signupPage.clickOnSubmitButtonWithoutFillConfirmPassword();
        String expectedErrorText ="'Confirm password' and 'Password' do not match.";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }

    @Test(priority = 6)
    public void clickOnSubmitButtonWithoutMatchConfirmPassword() throws InterruptedException {
        signupPage = new SignupPage(driver);
        String actualErrorText = signupPage.clickONSubmitButtonWithoutMatchConfirmPassword();
        String expectedErrorText = "'Confirm password' and 'Password' do not match.";
        Assert.assertEquals(actualErrorText , expectedErrorText);
    }

    @Test(priority = 7)
    public void successfullyRegisterInTheWebsite() throws InterruptedException, IOException, ParseException {
        signupPage = new SignupPage(driver);
        utils = new Utils();

        String filePath = "./src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(filePath));
        JSONArray userArray = (JSONArray) object;


        String username = utils.generateRandomData();
//        String username = "delmar.mraz";
        boolean usernameExist = false;

        for (int i = 0; i <= userArray.size() - 1; i++) {

            JSONObject userObject = (JSONObject) userArray.get(i);
            String usernameFromJson = (String) userObject.get("username");

            if (username.equals(usernameFromJson)){
                usernameExist = true;
                break;
            }
        }

        if(usernameExist){
            Pair<String , String> result = signupPage.successfullyRegisterToTheWebsite(username);
            String actualUsernameExistText = result.getRight();
            System.out.println(actualUsernameExistText);
            String expectedUsernameExistText = "Username already exist";
            Assert.assertEquals(actualUsernameExistText , expectedUsernameExistText);
            System.out.println("User Already Exist");
        }
        else {
            System.out.println(username);
            utils.writeUserInfo(username);
            Pair<String , String> result = signupPage.successfullyRegisterToTheWebsite(username);
            String actualSuccessfulText = result.getLeft();
            String expectedSuccessfulText = "Registration Successful";
            Assert.assertEquals(actualSuccessfulText , expectedSuccessfulText);
            System.out.println("New user created");
        }
    }
}
