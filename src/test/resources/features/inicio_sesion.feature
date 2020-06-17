Feature: Inicio de sesion
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  @signup
  Scenario Outline: Cliente intenta iniciar sesion con contrasena no valida
    Given Julian es un cliente que quiere iniciar QuestionsStepDefinitions.java:sesion para administrar sus productos
    When el envia la contrasena <contrasena>
    Then el debe ser informado que la contrasena no es valida
    Examples:
      | contrasena | descripcion     |
      | Pie22      | Longitud minima |
      | 578439543  | Solo numeros    |
      | rjkfjdks   | Solo letras     |
