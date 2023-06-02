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
    WebElement suggestMessageForEnterPassword;
    @FindBy(xpath = "//label[normalize-space()='Wrong username or password']")
    WebElement errorMessageForEnterWrongUsernameOrPassword;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutButton;

    WebDriver driver;

    // PageFactory

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // All positive and negative test steps for login

    public Pair<String , String> clickOnLoginButtonWithoutEnterAnyCredentials() throws InterruptedException {
        linkLogin.click();
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String suggestTextForEnterUserName = suggestMessageForEnterUserName.getText();
        Thread.sleep(1500);
        String suggestTextForEnterPassword = suggestMessageForEnterPassword.getText();
        Thread.sleep(1500);
        return Pair.of(suggestTextForEnterUserName , suggestTextForEnterPassword);
    }

    public String clickOnLoginButtonWithoutGivePassword() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("esteban.reinge");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String textForSuggestPassword = suggestMessageForEnterPassword.getText();
        return textForSuggestPassword;
    }

    public String clickOnLoginButtonWithoutGiveUsername() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("12345678");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String textForSuggestUsername = suggestMessageForEnterUserName.getText();
        return textForSuggestUsername;
    }

    public String giveUsernameAndPasswordAndClickOnClearButton() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("Shahriar");
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("12345678");
        Thread.sleep(1500);
        clearButtonForRemoveUsernamePassword.click();
        Thread.sleep(1500);
        String textFromUsernameFiled = usernameFieldForLogin.getText();
        return textFromUsernameFiled;
    }

    public String clickOnLoginButtonWithInvalidUsername() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("esteban.");
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("12345678");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String errorTextForLogin = errorMessageForEnterWrongUsernameOrPassword.getText();
        return errorTextForLogin;
    }

    public String clickOnLoginButtonWithInvalidPassword() throws InterruptedException {
        Thread.sleep(1500);
        clearButtonForRemoveUsernamePassword.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("esteban.reinge");
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("1234");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String errorTextForLogin = errorMessageForEnterWrongUsernameOrPassword.getText();
        return errorTextForLogin;
    }

    public String clickOnLoginButtonWithInvalidUserNameAndPassword() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("esteban.");
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("1234");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        String errorTextForLogin = errorMessageForEnterWrongUsernameOrPassword.getText();
        return errorTextForLogin;
    }

    public boolean successfullyLoginToTheWebsiteWithValidUsernameAndPassword() throws InterruptedException {
        Thread.sleep(1500);
        linkLogin.click();
        Thread.sleep(1500);
        usernameFieldForLogin.sendKeys("esteban.reinger");
        Thread.sleep(1500);
        passwordFieldForLogin.sendKeys("12345678");
        Thread.sleep(1500);
        loginButtonToTheWebsite.click();
        Thread.sleep(1500);
        boolean logoutButtonFoundOrNotFound = logoutButton.isDisplayed();
        return logoutButtonFoundOrNotFound;
    }
}
