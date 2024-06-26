package CRMTestng.Locators;

import CRMTestng.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUplocators extends Base {
    public SignUplocators(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[contains(text(),'Sign Up')]")
    protected WebElement SignUpButton;
    @FindBy(id = "signup-username-input")
    protected WebElement fullName;
    @FindBy(xpath = "//input[@type='email']")
    protected WebElement email;
    @FindBy(id = "signup-password-input")
    protected WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement submitButton;
    @FindBy(id ="rc-anchor-container")
    protected WebElement captcha;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    protected WebElement frameCaptcha;
    @FindBy(xpath = "//body[1]/div[5]/button[1]")
    protected WebElement crossButton;

}
