package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class SendEmailsteps {

    WebDriver driver;

    @Given("I am on the rediff login")
    public void i_am_on_the_rediff_login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaisw\\IdeaProjects\\incubyte\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://mail.rediff.com/cgi-bin/login.cgi";
        driver.get(baseUrl);

    }

    @And("I enter my email and password")
    public void i_enter_my_email_and_password() {
        WebElement email = driver.findElement(By.id("login1"));
        email.sendKeys("username");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();


    }

    @And("I send a mail")
    public void i_send_a_mail() {
        //compose mail
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/ul/li[1]")).click();

        //ToEmail
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#TO_IDcmp2")).sendKeys("toEmail");

        //subject
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div/div/ul/li[4]/input")).sendKeys("Test mail");

        //click on attachment
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div/div/div[1]/div[1]/a")).click();

        //autoit
        try {
            Runtime.getRuntime().exec("D:\\uploadImage.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div/div/div[1]/a[1]")).click();
    }

    @Then("I close the browser")
    public void i_close_the_browser(){

        driver.quit();

    }
}
