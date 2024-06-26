package CRMTestng.steps;

import CRMTestng.Base;


import CRMTestng.Pages.loginPage;
import org.testng.annotations.Test;

public class loginSteps extends Base {

    @Test(description = "login with valid credential")
    public void user_fill_the_email_and_password_and_click_on_login_button() throws InterruptedException {
        loginPage.getInstance().performlogin();
            Thread.sleep(5000);}



    @Test(description ="User should navigate at the homepage",enabled = false)
    public void user_should_navigate_at_the_homepage() {


        }
    }