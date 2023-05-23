package pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    // All element locators for signup page

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    WebElement signupButton;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//td[@class='btn btn-link']")
    WebElement buttonForSignupFromLoginPage;
    @FindBy(name = "FirstName")
    WebElement FirstName;
    @FindBy(name = "Surname")
    WebElement surnameFiled;
    @FindBy(id = "E_post")
    WebElement ePostField;
    @FindBy(id = "Mobile")
    WebElement mobileNumberField;
    @FindBy(id = "Username")
    WebElement userNameField;
    @FindBy(id = "Password")
    WebElement passwordField;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;
    @FindBy(id = "submit")
    WebElement submitButton;


    WebDriver driver;

    // PageFactory

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // All steps/method for signup page

    public void clickOnSubmitButtonWithoutFillAnyFiled(){
        signupButton.click();
        submitButton.click();
    }
}
