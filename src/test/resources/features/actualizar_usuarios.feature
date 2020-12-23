Feature: Actualizar usuarios
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  @update
  Scenario: Actualizacion de un usuario

    Given Julian es un cliente que quiere poder administrar sus productos bancarios
    When el envia el id 5 el cual corresponde al usuario a actualizar
    Then el usuario con id 5 deberia ser actualizado

  Scenario: Actualizacion de usuarios

    Given Julian es un cliente que quiere poder administrar sus productos bancarios
    When el envia los ids 5,6,7 de los usuarios a actualizar