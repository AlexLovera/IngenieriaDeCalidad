# language: es

Característica: Adicion de gastos a un grupo

  Regla: El monto debe ser mayor a 0

    Antecedentes:
      Dado que el usuario inició Repartir
      Y el usuario crea un grupo
#      Dado que ya existe el grupo #99 llamado 'Conferencia NDC'
#      Y el grupo #99 tiene 2 integrantes

      Escenario: Se agrega un gasto donde el monto es positivo
        Cuando el usuario quiere guardar un gasto con monto de '10.000' pesos
        Entonces deberia visualizar un mensaje con 'Éxito' 'Gasto agregado'

      Escenario: Se agrega un gasto donde el monto es negativo
        Cuando el usuario quiere guardar un gasto con monto de '-10.000' pesos
        Entonces deberia visualizar un mensaje con 'Error' 'No se puede guardar'

      Escenario: Se agrega un gasto donde el monto es cero
        Cuando el usuario quiere guardar un gasto con monto de '0' pesos
        Entonces deberia visualizar un mensaje con 'Error' 'No se puede guardar'