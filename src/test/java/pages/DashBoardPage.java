package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage {
    
    @FindBy(id = "searching")
    WebElement searchField;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;
}
