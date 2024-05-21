package Project_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserComUltimate {
    static String browser = "chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.get(baseUrl);
        //Maximize the browser automatically
        driver.manage().window().maximize();
        // waiting time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Title of the page
        System.out.println("Title of the page  : " + driver.getTitle());//driver.getTitle();
        //Print the page source
        System.out.println("The page source : " + driver.getPageSource());
        //Click on sign in
        driver.findElement(By.linkText("Sign In")).click();
        System.out.println("The current url :" + driver.getCurrentUrl());
        //Email
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("Prime12@gmail.com");
        WebElement pass = driver.findElement(By.id("user[password]"));
        pass.sendKeys("prime123");
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(5000);


        driver.navigate().to(baseUrl);
        System.out.println(driver.getCurrentUrl());
        //Thread.sleep(5000);


        driver.navigate().forward();

        // System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        //System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();

        driver.quit();
    }
}
