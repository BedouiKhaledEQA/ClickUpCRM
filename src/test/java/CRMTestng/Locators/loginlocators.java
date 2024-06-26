package CRMTestng.Locators;

import CRMTestng.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginlocators extends Base {
    public loginlocators(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login-email-input")
    protected WebElement email;
    @FindBy(id = "login-password-input")
    protected WebElement password;
    @FindBy(xpath ="//button[@type='submit']")
    protected WebElement loginButton;
    @FindBy(xpath ="//*[contains(text(),'Log in')]")
    protected WebElement mainloginButton;
    @FindBy(xpath ="//*[@data-test='user-main-settings-menu__dropdown-toggle']")
    protected WebElement loggedIn;

}
