@HU-003 @CRUD
Feature: Gestión de productos
  Como administrador del sistema
  Quiero gestionar productos (crear, listar, actualizar y eliminar)
  Para mantener actualizado el catálogo

  @Crear
  Scenario: Crear un producto válido
    Given existe un inventario vacío
    When creo un producto con id "P1" y nombre "Teclado"
    Then el producto "P1" existe en el inventario

  @Listar
  Scenario: Listar productos
    Given existe un inventario con productos
    When consulto el listado de productos
    Then obtengo al menos 1 producto

  @Actualizar
  Scenario: Actualizar un producto
    Given existe un producto con id "P1" y nombre "Teclado"
    When actualizo el producto "P1" con nombre "Teclado Mecánico"
    Then el producto "P1" tiene nombre "Teclado Mecánico"

  @Eliminar
  Scenario: Eliminar un producto
    Given existe un producto con id "P2" y nombre "Mouse"
    When elimino el producto "P2"
    Then el producto "P2" no existe en el inventario
