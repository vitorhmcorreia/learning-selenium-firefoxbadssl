package info.vitorcorreia.learningseleniumfirefoxbadssl;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Using Selenium + Firefox to test an insecure website
 * Ajust the appropriate Chrome import and driver setup, if you want to use Chrome instead.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Using Selenium + Firefox to test an insecure website" );

        WebDriverManager.firefoxdriver().setup(); 
        //WebDriverManager.chromedriver().setup(); 
        
        FirefoxOptions options = new FirefoxOptions();
        //ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(false);
        WebDriver driver = new FirefoxDriver(options);
        //WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://self-signed.badssl.com/");


        String expectedTitle = "self-signed.badssl.com";
        String actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Website was sucessfully opened: Test Passed");
		}else {
			System.err.println("Website was _not_ sucessfully opened: Test Failed");
		}
		
		driver.close();

    }
}
