package testrunner;

import base.Setup;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends Setup {

    LoginPage loginPage;

    @Test(priority = 1)
    public void clickOnLoginWithoutEnterUsernameOrPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://itera-qa.azurewebsites.net/");
        Pair<String, String> textResult = loginPage.clickOnLoginButtonWithoutEnterAnyCredentials();
        String actualTextForSuggestToEnterUsername = textResult.getLeft();
        String actualTextForSuggestToEnterPassword = textResult.getRight();
        String expectedForTextSuggestToEnterUsername = "Please enter username";
        String expectedTextForSuggestToEnterPassword = "Please enter password";
        Assert.assertEquals(actualTextForSuggestToEnterUsername , expectedForTextSuggestToEnterUsername);
        Assert.assertEquals(actualTextForSuggestToEnterPassword , expectedTextForSuggestToEnterPassword);
    }

 /*   @Test(priority = 2)
    public void loginWithoutGivePassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.clickOnLoginButtonWithoutGivePassword();
        String expectedText = "Please enter password";
        Assert.assertEquals(actualText , expectedText);
    }

    @Test(priority = 3)
    public void loginWithoutGiveUsername() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.clickOnLoginButtonWithoutGiveUsername();
        String expectedText = "Please enter username";
        Assert.assertEquals(actualText , expectedText);
    }

    @Test(priority = 4)
    public void giveUsernameAndPasswordAndClickOnClearButton() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.giveUsernameAndPasswordAndClickOnClearButton();
        String expectedText = "";
        Assert.assertEquals(actualText , expectedText);
    }

    @Test(priority = 5)
    public void loginWithInvalidUsername() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.clickOnLoginButtonWithInvalidUsername();
        String expectedText = "Wrong username or password";
        Assert.assertEquals(actualText , expectedText);
    }

    @Test(priority = 6)
    public void loginWithInvalidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.clickOnLoginButtonWithInvalidPassword();
        String expectedText = "Wrong username or password";
        Assert.assertEquals(actualText , expectedText);
    }

    @Test(priority = 7)
    public void loginWithInvalidUsernamePassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actualText = loginPage.clickOnLoginButtonWithInvalidPassword();
        String expectedText = "Wrong username or password";
        Assert.assertEquals(actualText , expectedText);
    } */

    @Test(priority = 8)
    public void loginSuccessfulInTheWebsite() throws InterruptedException {
        loginPage = new LoginPage(driver);
        boolean logoutButtonFoundOrNotFound = loginPage.successfullyLoginToTheWebsiteWithValidUsernameAndPassword();
        Assert.assertEquals(logoutButtonFoundOrNotFound , true);
    }
}
