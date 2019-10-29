Feature: Registro de usuarios
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos


  @signup
  Scenario: Registro exitoso de usuario

    Given Julian es un cliente que quiere poder administrar sus productos bancarios
    When el envia la informacion requerida para el registro
    Then el debe obtener una cuenta virtual para poder ingresar cuando lo requiera


  Scenario: Registro exitoso de usuario 2

    Given Julian es un cliente que quiere poder administrar sus productos bancarios
    When el envia la informacion requerida para el registro
    Then el debe obtener una cuenta virtual para poder ingresar cuando lo requiera

  @otracosa
  Scenario: Registro exitoso de usuario 3

    Given Julian es un cliente que quiere poder administrar sus productos bancarios
    When el envia la informacion requerida para el registro
    Then el debe obtener una cuenta virtual para poder ingresar cuando lo requiera