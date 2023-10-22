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

    @Given("user already login into website")
    public void userAlreadyLoginIntoWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click side menu")
    public void userClickSideMenu() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @And("user click logout")
    public void userClickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutbtn.click();
    }

    @Then("user successfully logout")
    public void userSuccessfullyLogout() {
        String loginpage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginpage,"Swag Labs");
        driver.close();
    }

    @Given("user already login in the website")
    public void userAlreadyLoginInTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click AddToCart button on the product column")
    public void userClickAddToCartButtonOnTheProductColumn() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("user click cart icon on the top right side")
    public void userClickCartIconOnTheTopRightSide() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("click the checkout button")
    public void clickTheCheckoutButton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("user fill the biodata form")
    public void userFillTheBiodataForm() {
        driver.findElement(By.id("first-name")).sendKeys("Nola");
        driver.findElement(By.id("last-name")).sendKeys("Olala");
        driver.findElement(By.id("postal-code")).sendKeys("1234");

    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user finish overview shopping list")
    public void userFinishOverviewShoppingList() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user should see checkout complete page")
    public void userShouldSeeCheckoutCompletePage() {
        String finish = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(finish,"Thank you for your order!");
        driver.close();
    }

    @And("user click continue button without fill the form")
    public void userClickContinueButtonWithoutFillTheForm() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user will see error message in form page")
    public void userWillSeeErrorMessageInFormPage() {
        String finish = driver.findElement(By.xpath("//h3[normalize-space()='Error: First Name is required']")).getText();
        Assert.assertEquals(finish,"Error: First Name is required");
        driver.close();
    }
}
