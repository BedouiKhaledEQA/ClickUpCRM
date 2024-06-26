package CRMTestng.Pages;

import CRMTestng.Locators.SignUplocators;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends SignUplocators {
    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }
    private static SignUpPage instance;
    UserPage userPage;

    public static SignUpPage getInstance(){
        if(instance == null ) {
            instance = new SignUpPage();
        }return instance;

        }
    public void performSignUp() throws InterruptedException {
        userPage=new UserPage();
        SignUpButton.click();
        email.sendKeys(userPage.getEmail());
        submitButton.click();
        Thread.sleep(3000);
        fullName.sendKeys(userPage.getFullName());
        password.sendKeys(userPage.getPassword());
        submitButton.click();

       //driver.switchTo().frame(frameCaptcha);
       //captcha.click();
       // driver.switchTo().defaultContent();


    }
}
