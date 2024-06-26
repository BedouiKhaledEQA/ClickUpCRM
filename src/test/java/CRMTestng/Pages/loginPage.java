package CRMTestng.Pages;

import CRMTestng.Base;
import CRMTestng.Locators.loginlocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class loginPage extends loginlocators {
    public loginPage(){
        PageFactory.initElements(driver,this);
    }

    public static loginPage instance ;

    public static loginPage getInstance(){
        if(instance == null){
            instance= new loginPage();
        }return  instance;
    }

    public void performlogin() throws InterruptedException {
        mainloginButton.click();
        email.sendKeys(props.getProperty("username"));
        password.sendKeys(props.getProperty("password"));
        loginButton.click();
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loggedIn));*/
        Thread.sleep(5000);
        Assert.assertTrue((loggedIn).isDisplayed(),"Logged in element is not displayed");

    }

}
