Feature: Retiro de dinero
  Con el fin de poder tener flujo de dinero
  Yo como usuario quiero poder retirar dinero de mis cuentas de ahorro
  Para poder realizar pagos y compras en establecimientos donde solo reciban efectivo

  Scenario: Cliente retira dinero de su cuenta de ahorros

    Given Julian es un cliente con una cuenta de ahorros
    And en su cuenta tiene un saldo disponible de 1000000.00
   # When el intenta retirar de su cuenta 100000
   # Then el deberia obtener 100000
   # And el nuevo saldo de su cuenta deberia ser 900000