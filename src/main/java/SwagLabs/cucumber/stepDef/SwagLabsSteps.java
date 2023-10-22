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

    @Given(": User successfully to login page")
    public void userSuccessfullyToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://www.saucedemo.com/", Url);

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();

        WebElement products = driver.findElement(By.xpath("//span[@class='title']"));
        String productsText = products.getText();
        System.out.println(productsText);
    }

    @When(": User see list of product")
    public void userSeeListOfProduct() {
        WebElement sauceLabsBackpack = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"));
        String sauceLabsBackpackText = sauceLabsBackpack.getText();
        System.out.println(sauceLabsBackpackText);
    }

    @And(": User click add product want to buy")
    public void userClickAddProductWantToBuy() {
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
    }

    @And(": User click cart button to proceed checkout process")
    public void userClickCartButtonToProceedCheckoutProcess() {
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartIcon.click();
    }

    @And(": User click button checkout")
    public void userClickButtonCheckout() {
        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
    }

    @Then(": User should success navigate to first step requirement for check out")
    public void userShouldSuccessNavigateToFirstStepRequirementForCheckOut() {
        WebElement checkoutYourInformation = driver.findElement(By.xpath("//span[@class='title']"));
        String checkoutYourInformationText = checkoutYourInformation.getText();
        System.out.println(checkoutYourInformationText);
        Assert.assertEquals("Checkout: Your Information",checkoutYourInformationText);
    }

    @Then(": User should get error warning that product not selected")
    public void userShouldGetErrorWarningThatProductNotSelected() {
        WebElement checkoutfailmessage = driver.findElement(By.xpath("//h3[normalize-space()='You dont have product to checkout']"));
        String checkoutfailmessageText = checkoutfailmessage.getText();
        System.out.println(checkoutfailmessageText);
    }
}
