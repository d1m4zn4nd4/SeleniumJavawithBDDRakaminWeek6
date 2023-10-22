package SwagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SwagLabsSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given(": User navigate to login page")
    public void userNavigateToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://www.saucedemo.com/", Url);
    }

    @When(": User input valid username")
    public void userInputValidUsername() {
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
    }

    @And(": User input valid password")
    public void userInputValidPassword() {
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
    }

    @And(": Click Login Button")
    public void clickLoginButton() {
        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();
    }

    @Then(": User can login to choose product")
    public void userCanLoginToChooseProduct() {
        WebElement products = driver.findElement(By.xpath("//span[@class='title']"));
        String productsText = products.getText();
        System.out.println(productsText);
    }

    @And(": User input empty password")
    public void userInputEmptyPassword() {
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("");
    }

    @Then(": User can't login and show error message")
    public void userCanTLoginAndShowErrorMessage() {
        WebElement epicSadfacemessage = driver.findElement(By.xpath("//h3[normalize-space()='Epic sadface: Password is required']"));
        String epicSadfacemessageText = epicSadfacemessage.getText();
        System.out.println(epicSadfacemessageText);
    }
}
