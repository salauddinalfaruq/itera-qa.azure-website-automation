package testrunner;

import base.Setup;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends Setup {

    LoginPage loginPage;

    @Test
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
}
