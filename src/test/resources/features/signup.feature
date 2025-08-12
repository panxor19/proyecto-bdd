@HU-002 @Registro
Feature: Registro de usuario
  Como visitante
  Quiero registrarme en la aplicación
  Para acceder a la plataforma

  Scenario: Registro exitoso
    Given el visitante se encuentra en la página de registro
    When ingresa los datos del formulario
    And confirma el registro
    Then se muestra mensaje de bienvenida
