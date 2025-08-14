@HU-001 @Login @SmokeTest
Feature: Inicio de sesión
  Como usuario registrado
  Quiero iniciar sesión
  Para acceder a mi cuenta

  Scenario: Inicio de sesión válido
    Given el usuario está en la página de login
    When ingresa "tomsmith" y "SuperSecretPassword!"
    Then accede a su cuenta

  Scenario: Inicio de sesión incorrecto
    Given el usuario está en la página de login
    When ingresa "tomsmith" y "IncorrectPassword!"
    Then muestra mensaje de login fallido

  @Regression
  Scenario Outline: Intentos de login con combinaciones de credenciales
    Given el usuario está en la página de login
    When ingresa "<usuario>" y "<contrasena>"
    Then <resultado>

    Examples:
      | usuario   | contrasena              | resultado                          |
      | tomsmith  | SuperSecretPassword!    | accede a su cuenta                 |
      | tomsmith  | IncorrectPassword!      | muestra mensaje de login fallido   |
      | userX     | SuperSecretPassword!    | muestra mensaje de login fallido   |
