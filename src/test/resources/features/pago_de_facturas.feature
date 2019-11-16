Feature: Pago de facturas
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  Background:
    Given Pedro es un cliente del banco
    And el ya inicio sesion en la aplicacion

  Scenario: Cliente intenta pagar el servicio de gas
    And el tiene pendiente el pago del servicio del gas
    When el intente realizar el pago del servicio
    Then el debe ser notificado del pago exitoso

  Scenario: Cliente intenta pagar el servicio de la electricidad sin saldo en su cuenta de ahorros
    And el tiene pendiente el pago del servicio de la electricidad
    When el intente realizar el pago del servicio
    Then el debe ser notificado que el pago no fue exitoso

  Scenario: Cliente paga servicio de internet que ya esta vencido
    And el tiene vencido el pago del servicio de internet
    When el intente realizar el pago del servicio
    Then el debe ser notificado que el pago no fue exitoso