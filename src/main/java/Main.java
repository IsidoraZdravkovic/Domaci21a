
/*

Automatizovati navodjenje na sajtu https://automationexercise.com. Otici na pocetnu stranu, kliknuti na "Signup / Login",
unesite u polja za "New User Signup!" pomocu faker-a - ime i email. Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i "Receive special offers from our partners!".
 Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati.


 */

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Bootcamp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        driver.get(" https://automationexercise.com");
        driver.manage().window().maximize();
        WebElement signUpLogIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLogIn.click();


        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        String username = faker.name().username();
        name.sendKeys(username);
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        String email = faker.internet().emailAddress();
        emailAddress.sendKeys(email);

        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUp.click();
        WebElement genderButton = driver.findElement(By.id("id_gender2"));
        genderButton.click();
        WebElement password = driver.findElement(By.id("password"));
        String password1 = "isidora";
        password.sendKeys(password1);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,600);", "");

        WebElement selectDay = driver.findElement(By.id("days"));
        Select day = new Select(selectDay);
        day.selectByVisibleText("13");

        WebElement selectMonth = driver.findElement(By.id("months"));
        Select month = new Select(selectMonth);
        month.selectByVisibleText("May");

        WebElement selectYear = driver.findElement(By.id("years"));
        Select year = new Select(selectYear);
        year.selectByVisibleText("1998");

        WebElement buttonSpecialOffers = driver.findElement(By.id("optin"));
        buttonSpecialOffers.click();

        WebElement selectCountry = driver.findElement(By.id("country"));
        Select country = new Select(selectCountry);
        country.selectByVisibleText("Canada");

        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Petar");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Petrovic");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("BigCompany");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("Glavna ulica");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Sporedna ulica");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Serbia");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Novi Sad");

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("21200");
        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(600,800);", "");

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("874569");
        WebDriverWait webDriverWait1 = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccount.click();

        WebElement continue1 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continue1.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement deleteAccount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();

        WebElement continue2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continue2.click();


    }
}

