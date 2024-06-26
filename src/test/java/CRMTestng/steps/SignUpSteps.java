package CRMTestng.steps;

import CRMTestng.Base;
import CRMTestng.Pages.SignUpPage;
import org.testng.annotations.Test;

public class SignUpSteps extends Base {
    @Test(description = "User fill the email and click on accept terms & select captcha and click on signup Button")
    public void user_fill_the_email_and_click_on_accept_terms_select_captcha_and_click_on_signup_button() throws InterruptedException {
        SignUpPage.getInstance().performSignUp();
    }
    @Test(description = "User account should be created",enabled = false)
    public void user_account_should_be_created() {

    }


}
