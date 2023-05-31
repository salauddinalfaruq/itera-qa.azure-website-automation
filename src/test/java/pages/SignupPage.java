package pages;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.Optional;

public class SignupPage{

    // All element locators for signup page

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    WebElement signupButton;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//td[@class='btn btn-link']")
    WebElement buttonForSignupFromLoginPage;
    @FindBy(name = "FirstName")
    WebElement firstNameField;
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
    @FindBy(id = "FirstName-error")
    WebElement firstNameErrorText;
    @FindBy(id = "Surname-error")
    WebElement surNameErrorText;
    @FindBy(id = "Username-error")
    WebElement userNameErrorText;
    @FindBy(id = "Password-error")
    WebElement passwordErrorText;
    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordErrorText;
    @FindBy(className = "label-success")
    WebElement successfulTextForRegistration;
    @FindBy(className = "label-danger")
    WebElement usernameAlreadyExistMessage;

    Utils utils;

    WebDriver driver;

    // PageFactory

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // All steps/method for signup page

    public String clickOnSubmitButtonWithoutFillAnyFiled() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scroll(0,100);");
//        js.executeScript("window.scroll(0,150);");
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        String errorTextForFirstName = firstNameErrorText.getText();
        System.out.println(errorTextForFirstName);
        return errorTextForFirstName;
    }

    public String clickOnSubmitButtonWithOnlyFillFirstName() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        String errorTextForSurName = surNameErrorText.getText();
        System.out.println(errorTextForSurName);
        return errorTextForSurName;
    }

    public String clickOnSubmitButtonWithFillingFirstAndSurName() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        surnameFiled.sendKeys("Tonoy");
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(1500);
        String errorTextForUserName = userNameErrorText.getText();
        System.out.println(errorTextForUserName);
        return errorTextForUserName;
    }

    public String clickOnSubmitButtonWithFillingFirstSurnameAndUsername() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        surnameFiled.sendKeys("Tonoy");
        Thread.sleep(1500);
        userNameField.sendKeys("tajbirtonoy");
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(1500);
        String errorTextForPassword = passwordErrorText.getText();
        System.out.println(errorTextForPassword);
        return errorTextForPassword;
    }

    public String clickOnSubmitButtonWithoutFillConfirmPassword() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        surnameFiled.sendKeys("Tonoy");
        Thread.sleep(1500);
        userNameField.sendKeys("tajbirtonoy");
        Thread.sleep(1500);
        passwordField.sendKeys("12345678");
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(1500);
        String errorTextForConfirmPassword = confirmPasswordErrorText.getText();
        System.out.println(errorTextForConfirmPassword);
        return errorTextForConfirmPassword;
    }

    public String clickONSubmitButtonWithoutMatchConfirmPassword() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        surnameFiled.sendKeys("Tonoy");
        Thread.sleep(1500);
        userNameField.sendKeys("tajbirtonoy");
        Thread.sleep(1500);
        passwordField.sendKeys("12345678");
        Thread.sleep(1500);
        confirmPasswordField.sendKeys("1234567");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(1500);
        String errorTextForConfirmPassword = confirmPasswordErrorText.getText();
        System.out.println(errorTextForConfirmPassword);
        return errorTextForConfirmPassword;
    }

    public Pair<String , String> successfullyRegisterToTheWebsite(String username) throws InterruptedException {
        signupButton.click();
        Thread.sleep(1500);
        firstNameField.sendKeys("Tajbir");
        Thread.sleep(1500);
        surnameFiled.sendKeys("Tonoy");
        Thread.sleep(1500);
        userNameField.sendKeys(username);
        Thread.sleep(1500);
        passwordField.sendKeys("12345678");
        Thread.sleep(1500);
        confirmPasswordField.sendKeys("12345678");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(1500);
        String successfulRegistrationText = successfulTextForRegistration.getText();
        String usernameAlreadyExistText = usernameAlreadyExistMessage.getText();
        js.executeScript("arguments[0].scrollIntoView();", successfulTextForRegistration);
        Thread.sleep(1500);
        return Pair.of(successfulRegistrationText , usernameAlreadyExistText);
    }
}

