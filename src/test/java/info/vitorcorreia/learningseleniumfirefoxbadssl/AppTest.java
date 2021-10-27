package info.vitorcorreia.learningseleniumfirefoxbadssl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println("Using Selenium + Firefox to test an insecure website");

        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        //ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new FirefoxDriver(options);
        //WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://self-signed.badssl.com/");


        assertEquals(driver.getTitle(), "self-signed.badssl.com");

        // O driver.close() só fecha o browser. Não termina o processo do geckodriver.
        // É usado quando queres limpar estado mas continuar a testar no mesmo geckodriver.
        // Quando acabas os testes, usa antes o driver.quit() para não ficares com infinitos geckdriver's abertos.
        driver.quit();
    }
}
