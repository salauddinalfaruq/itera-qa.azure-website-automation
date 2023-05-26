package testrunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.Utils;

import java.io.IOException;

public class SignupTestRunner extends Setup {

    SignupPage signupPage;
    Utils utils;

    @Test(priority = 1)
    public void clickOnSubmitButtonWithoutFillAnyCredentials() throws InterruptedException {
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
        String username = utils.generateRandomData();
        utils.writeUserInfo(username);
        String actualSuccessfulText = signupPage.successfullyRegisterToTheWebsite(username);
        String expectedSuccessfulText = "Registration Successful";
        Assert.assertEquals(actualSuccessfulText , expectedSuccessfulText);
    }
}
