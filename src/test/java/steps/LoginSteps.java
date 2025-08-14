package steps;

import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("el usuario está en la página de login")
    public void usuarioEnLogin() {
        System.out.println("Navegando a la página de login...");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Given("el usuario esta en la pagina de login")
    public void usuarioEnLoginAlias() {
        usuarioEnLogin();
    }

    @When("ingresa {string} y {string}")
    public void ingresarCredenciales(String usuario, String pass) {
        System.out.println("Ingresando credenciales: " + usuario + " / " + pass);
        driver.findElement(By.id("username")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("accede a su cuenta")
    public void verificarPantallaPrincipal() {
        System.out.println("Validando pantalla principal...");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        WebElement mensajeBienvenida = driver.findElement(By.id("flash"));
        assertTrue(mensajeBienvenida.isDisplayed());
        assertTrue(mensajeBienvenida.getText().contains("You logged into a secure area!"));
    }

    @Then("muestra mensaje de login fallido")
    public void verificarPantallaError() {
        System.out.println("Validando pantalla de error...");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        WebElement mensajeError = driver.findElement(By.id("flash"));
        assertTrue(mensajeError.isDisplayed());
        System.out.println("Mensaje de error: " + mensajeError.getText());
        String text = mensajeError.getText();
        assertTrue("Mensaje inesperado: " + text,
            text.contains("Your password is invalid") || text.contains("Your username is invalid"));
    }

    @Then("{string}")
    public void resultadoDinamico(String resultado) {
        if ("accede a su cuenta".equalsIgnoreCase(resultado.trim())) {
            verificarPantallaPrincipal();
        } else if ("muestra mensaje de login fallido".equalsIgnoreCase(resultado.trim())) {
            verificarPantallaError();
        } else {
            throw new IllegalArgumentException("Resultado no soportado: " + resultado);
        }
    }

}
