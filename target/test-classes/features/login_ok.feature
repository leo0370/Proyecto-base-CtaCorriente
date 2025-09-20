Feature: Login de ejecutivo

  Scenario: Ingreso correcto
    Given que abro la aplicación de Banco Platinum
    When ingreso rut "11.111.111-1" y nombre "Juan Perez"
    And presiono Ingresar
    Then debería ver la página de inicio del ejecutivo
