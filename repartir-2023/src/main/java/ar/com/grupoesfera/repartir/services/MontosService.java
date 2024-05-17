package ar.com.grupoesfera.repartir.services;

import ar.com.grupoesfera.repartir.exceptions.DivisionInvalidaException;
import ar.com.grupoesfera.repartir.model.Gasto;
import ar.com.grupoesfera.repartir.model.Grupo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MontosService {

    public void inicializarTotal(Grupo grupo) {

        grupo.setTotal(BigDecimal.valueOf(0,2));
    }

    public void acumularAlTotal(Grupo grupo, Gasto gasto) {

        BigDecimal total = grupo.getTotal();
        total = total.add(gasto.getMonto());
        grupo.setTotal(total);
    }

    public BigDecimal dividirMonto(BigDecimal monto, int partes) {

        if (partes == 0) {

            throw new DivisionInvalidaException();
        }

        return monto.divide(BigDecimal.valueOf(partes), 2, RoundingMode.DOWN);
    }
}
