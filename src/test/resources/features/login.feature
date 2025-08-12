@HU-001 @Login
Feature: Inicio de sesión
  Como usuario registrado
  Quiero iniciar sesión
  Para acceder a mi cuenta

  Scenario: Inicio de sesión válido
    Given el usuario está en la página de login
    When ingresa "tomsmith" y "SuperSecretPassword!"
    Then accede a su cuenta

  Scenario: Inicio de sesion incorrecto
    Given el usuario está en la página de login
    When ingresa "tomsmith" y "IncorrectPassword!"
    Then muestra mensaje de login fallido
