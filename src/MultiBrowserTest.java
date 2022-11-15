import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    //Using static variables to use in class
    static String gbrowser = "Firefox";
    static String targetUrl = "https://www.saucedemo.com/";
    static WebDriver driverMulti;

    public static void main(String[] args) {
        // 1. Using Switch statement to set up and select between browsers
        switch (gbrowser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driverMulti = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
                driverMulti = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driverMulti = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser selection");
        }
        //Using try-catch for exception handling due to invalid input
        try {
            //2. Open given URL for selected browser
            driverMulti.get(targetUrl);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("End of program due to invalid browser selection");
            System.exit(0);
        }
        //Maximise window size on opening
        driverMulti.manage().window().maximize();

        //Timeout request for page to load completely
        driverMulti.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Printing page title
        System.out.println("Page title is: " + driverMulti.getTitle());

        //4. Printing current URL
        System.out.println("The current URL is: " + driverMulti.getCurrentUrl());

        //5. Printing the page source
        System.out.println("The source code is: " + driverMulti.getPageSource());

        //6. Get web element and enter username in user-name field
        WebElement userField = driverMulti.findElement(By.name("user-name"));
        userField.sendKeys("siddhi001");

        //7. Get web element and enter password in password field
        WebElement pField = driverMulti.findElement(By.id("password"));
        pField.sendKeys("pass123");

        //8. Closing the browser
        driverMulti.quit();

    }

}
