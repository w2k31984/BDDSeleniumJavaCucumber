Feature: Automatización de la página de inicio de sesión de SauceDemo App

  Scenario: Comprobar inicio de sesión con credenciales válidas
    Given El usuario está en la página de inicio de sesión
    When El usuario introduce un nombre de usuario y un password válidos
    And Pulsa el boton de inicio de sesion
    Then El usuario es dirigido a la página de inicio
    And Cierra el navegador
