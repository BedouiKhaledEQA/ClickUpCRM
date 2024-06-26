package CRMTestng.Pages;

import CRMTestng.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends Base {
    public UserPage(){
        PageFactory.initElements(driver,this);


        Faker faker=new Faker();
        email=faker.internet().emailAddress();
        fullName=faker.name().fullName();
        password=faker.internet().password();

    }

   private String email;
   private String fullName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserPage(String email,String fullName,String password) {
        this.email = email;
        this.fullName=fullName;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
