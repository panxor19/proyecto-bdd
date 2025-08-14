package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import java.util.*;

public class CrudSteps {

    private static final Map<String, String> inventario = new HashMap<>();

    @Given("existe un inventario vacío")
    public void inventarioVacio() {
        inventario.clear();
    }


    @When("creo un producto con id {string} y nombre {string}")
    public void crearProducto(String id, String nombre) {
        inventario.put(id, nombre);
    }

    @Then("el producto {string} existe en el inventario")
    public void validarProductoExiste(String id) {
        assertTrue("Producto no encontrado", inventario.containsKey(id));
    }

    @Given("existe un inventario con productos")
    public void inventarioConProductos() {
        if (inventario.isEmpty()) {
            inventario.put("A1", "Producto A");
        }
    }

    @When("consulto el listado de productos")
    public void listarProductos() {
        // No acción necesaria
    }

    @Then("obtengo al menos 1 producto")
    public void validarListado() {
        assertTrue("Inventario vacío", inventario.size() > 0);
    }

    @Given("existe un producto con id {string} y nombre {string}")
    public void crearProductoPrevio(String id, String nombre) {
        inventario.put(id, nombre);
    }

    @When("actualizo el producto {string} con nombre {string}")
    public void actualizarProducto(String id, String nuevoNombre) {
        assertTrue("No existe para actualizar", inventario.containsKey(id));
        inventario.put(id, nuevoNombre);
    }

    @Then("el producto {string} tiene nombre {string}")
    public void validarNombre(String id, String esperado) {
        assertEquals(esperado, inventario.get(id));
    }

    @When("elimino el producto {string}")
    public void eliminarProducto(String id) {
        inventario.remove(id);
    }

    @Then("el producto {string} no existe en el inventario")
    public void validarNoExiste(String id) {
        assertFalse("Producto aún presente", inventario.containsKey(id));
    }
}
