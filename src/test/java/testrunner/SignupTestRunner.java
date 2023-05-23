package testrunner;

import base.Setup;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTestRunner extends Setup {

    @Test
    public void clickOnSubmitButtonWithoutFillAnyCredentials(){
        SignupPage signupPage = new SignupPage(driver);
        driver.get("https://itera-qa.azurewebsites.net/");
        signupPage.clickOnSubmitButtonWithoutFillAnyFiled();
    }
}
