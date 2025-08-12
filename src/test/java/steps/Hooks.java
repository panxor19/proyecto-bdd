package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("[HOOK] Abriendo navegador...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("[HOOK] Cerrando navegador...");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
