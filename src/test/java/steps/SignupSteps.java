package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class SignupSteps {

    WebDriver driver;
    String usernameGenerado;

    public SignupSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("el visitante se encuentra en la página de registro")
    public void usuarioSignup() {
        System.out.println("Navegando a la página de registro...");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Given("el visitante se encuentra en la pagina de registro")
    public void usuarioSignupAlias() {
        usuarioSignup();
    }

    @When("ingresa los datos del formulario")
    public void ingresarDatos() {
    usernameGenerado = "userbdd" + System.currentTimeMillis();
    driver.findElement(By.id("customer.firstName")).sendKeys("Juan");
    driver.findElement(By.id("customer.lastName")).sendKeys("Perez");
    driver.findElement(By.id("customer.address.street")).sendKeys("Calle Falsa 123");
    driver.findElement(By.id("customer.address.city")).sendKeys("Ciudad");
    driver.findElement(By.id("customer.address.state")).sendKeys("ST");
    driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
    driver.findElement(By.id("customer.phoneNumber")).sendKeys("5551234");
    driver.findElement(By.id("customer.ssn")).sendKeys("111222333");
    driver.findElement(By.id("customer.username")).sendKeys(usernameGenerado);
    driver.findElement(By.id("customer.password")).sendKeys("Password123");
    driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");
    }

    @And("confirma el registro")
    public void confirmarRegistro() {
    driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

    @Then("se muestra mensaje de bienvenida")
    public void verificarMensajeBienvenida() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rightPanel")));
        String texto = mensaje.getText();
        assertTrue("No se encontró mensaje de confirmación. Texto obtenido: " + texto,
            texto.contains("Your account was created successfully"));
    }

}
