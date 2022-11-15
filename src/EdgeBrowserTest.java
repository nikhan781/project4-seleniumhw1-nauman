import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {
    public static void main(String[] args) {

        //Declaring the String type, local variable to store target URL
        String edgeUrl = "https://www.saucedemo.com/";

        //1.Setting up the browser webdriver
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");

        //Creating Interface object
        WebDriver eDriver = new EdgeDriver();

        //2. Opening given URL
        eDriver.get(edgeUrl);

        //Maximising Edge window upon opening
        eDriver.manage().window().maximize();

        //Timeout for page to load completely
        eDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of page
        System.out.println("The title of page is: " + eDriver.getTitle());

        //4. Print the current URL
        System.out.println("The current URL is: " + eDriver.getCurrentUrl());

        //5. Print the page source
        System.out.println("Source code of page: " + eDriver.getPageSource());

        //6. Enter the username in user-name field
        WebElement userName = eDriver.findElement(By.id("user-name"));
        userName.sendKeys("manisha222");

        //7. Enter the password in the password field
        WebElement passField = eDriver.findElement(By.name("password"));
        passField.sendKeys("Pass123");

        //8. Closing the Edge browser
        eDriver.quit();

    }
}