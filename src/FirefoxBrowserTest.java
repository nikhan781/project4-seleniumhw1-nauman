import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    //Creating main method
    public static void main(String[] args) {
        // Declaring local variable of String type
        String tgtUrl = "http://the-internet.herokuapp.com/login";

        //1. Setting up Firefox browser
        System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");

        // Object creation for Interface
        WebDriver fDriver = new ChromeDriver();

        //2. Opening given URL
        fDriver.get(tgtUrl);

        //Maximising window upon opening
        fDriver.manage().window().maximize();

        //Timeout for page to load completely
        fDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print title of page
        System.out.println("The title of page is: " + fDriver.getTitle());

        //4. Print current URL
        System.out.println("The current URL is: " + fDriver.getCurrentUrl());

        //5. Print page source
        String sourcePageCode = fDriver.getPageSource();
        System.out.println("Source code of page: " + sourcePageCode);

        //6. Getting the web element and entering the user-name in field
        WebElement userN = fDriver.findElement(By.id("user-name"));
        userN.sendKeys("harshid111");

        //7. Getting the web element and entering the password in the password field
        WebElement pField = fDriver.findElement(By.name("password"));
        pField.sendKeys("axd_987");

        //8. Closing the browser
        fDriver.quit();

    }
}
