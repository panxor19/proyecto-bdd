package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class SignupSteps {

    WebDriver driver;

    public SignupSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("el visitante se encuentra en la página de registro")
    public void usuarioSignup() {
        System.out.println("Navegando a la página de registro...");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @When("ingresa los datos del formulario")
    public void ingresarDatos() {

    }

    @And("confirma el registro")
    public void confirmarRegistro() {
        // Click boton submit

    }

    @Then("se muestra mensaje de bienvenida")
    public void verificarMensajeBienvenida() {

    }

}
