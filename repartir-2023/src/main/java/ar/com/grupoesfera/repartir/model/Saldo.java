package ar.com.grupoesfera.repartir.model;

import java.math.BigDecimal;

public class Saldo {

    private String propietario;
    private BigDecimal monto;

    public Saldo(String propietarioDelSaldo) {

        this.propietario = propietarioDelSaldo;
        this.monto = BigDecimal.ZERO;
    }

    public String getPropietario() {

        return this.propietario;
    }

    public BigDecimal getMonto() {

        return this.monto;
    }

    public void agregarGasto(BigDecimal montoDelGasto) {

        this.monto = this.monto.subtract(montoDelGasto);
    }
}
