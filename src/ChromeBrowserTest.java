import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args) {
        // Declaring local variable
        String tgtUrl = "http://the-internet.herokuapp.com/login";

        //1. Setting up browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Creating object for Interface
        WebDriver cDriver = new ChromeDriver();

        //2. Opening given URL
        cDriver.get(tgtUrl);

        //Maximise browser upon opening
        cDriver.manage().window().maximize();

        //Time given to driver to wait until page is loaded completely
        cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Get & print title page in console
        System.out.println("Page title is: " + cDriver.getCurrentUrl());

        //4. Get & print the current page URL in console
        String curUrl = cDriver.getCurrentUrl();
        System.out.println("Current URL is: " + curUrl);

        //5. Print the page source code in console
        String pageSourceC = cDriver.getPageSource();
        System.out.println("The source code is : " + pageSourceC);

        //6. Getting and entering user-name in username field
        WebElement userNameField = cDriver.findElement(By.id("user-name"));
        userNameField.sendKeys("krupa213");

        //7. Getting and entering password in password field
        WebElement passwordField = cDriver.findElement(By.name("password"));
        passwordField.sendKeys("pass123@");

        //8. Closing the Chrome browser
        cDriver.quit();

    }
}
