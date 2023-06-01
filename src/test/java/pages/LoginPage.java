package pages;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement linkLogin;
    @FindBy(id = "Username")
    WebElement usernameFieldForLogin;
    @FindBy(id = "Password")
    WebElement passwordFieldForLogin;
    @FindBy(name = "login")
    WebElement loginButtonToTheWebsite;
    @FindBy(name = "clear")
    WebElement clearButtonForRemoveUsernamePassword;
    @FindBy(xpath = "//span[normalize-space()='Please enter username']")
    WebElement suggestMessageForEnterUserName;
    @FindBy(xpath = "//span[normalize-space()='Please enter password']")
    WebElement getSuggestMessageForEnterPassword;
    @FindBy(xpath = "//label[normalize-space()='Wrong username or password']")
    WebElement errorMessageForEnterWrongUsernameOrPassword;

    WebDriver driver;

    // PageFactory

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Pair<String , String> clickOnLoginButtonWithoutEnterAnyCredentials() throws InterruptedException {
        linkLogin.click();
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String suggestTextForEnterUserName = suggestMessageForEnterUserName.getText();
        Thread.sleep(1500);
        String suggestTextForEnterPassword = getSuggestMessageForEnterPassword.getText();
        Thread.sleep(1500);
        return Pair.of(suggestTextForEnterUserName , suggestTextForEnterPassword);
    }
}
