package CRMTestng;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties props =new Properties();

    public Base(){
        try {
            File file;
            String environment = System.getProperty("env","local");
            if("local".equalsIgnoreCase(environment)){
                file=new File("src/test/java/CRMTestng/Properties/local_config.Properties");
            } else if ("prod".equalsIgnoreCase(environment)) {
                file=new File("src/test/java/CRMTestng/Properties/Prod_config.Properties");

            }else throw new RuntimeException("environment n'est pas pris en charge !");

            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeALlMethode(){
        System.out.println("**** STARTING TEST ****");
    }
    @BeforeMethod
    public WebDriver luncher(){
        String browser =System.getProperty("browser","chrome");

        switch (browser){
            case "chrome"->{
                driver=new ChromeDriver();
            }
            case "firefox"-> {
                driver = new FirefoxDriver();
            }
            case "edge"->{
                driver=new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(props.getProperty("url"));
        return driver;
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName+".png");
        takeScreenshot(destFile);
        driver.quit(); // .get to run tests in parallel
    }
    public void takeScreenshot(File destFile) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot", is);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

}}
