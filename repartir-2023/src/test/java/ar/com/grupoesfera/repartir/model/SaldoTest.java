package ar.com.grupoesfera.repartir.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SaldoTest {



    @Test
    void crearUnSaldoAsociadoAMariano() {
        final String MARIANO = "mariano";
        var saldoDeMariano = new Saldo(MARIANO);
        String propietario = saldoDeMariano.getPropietario();
        assertThat(propietario).isEqualTo(MARIANO);
    }

    @Test
    void crearUnSaldoAsociadoALina() {

        final String LINA = "lina";
        var saldoDeLina = new Saldo(LINA);
        assertThat(saldoDeLina.getPropietario()).isEqualTo(LINA);
    }

    @Test
    void elSaldoInicialmenteTieneMontoCero() {

        final String PROPIETARIO = "mariano";
        var saldo = new Saldo(PROPIETARIO);

        BigDecimal monto = saldo.getMonto();

        assertThat(monto).isEqualTo(BigDecimal.ZERO);
    }

    BigDecimal $(int pesos, int centavos) {

        return BigDecimal.valueOf(pesos * 100 + centavos, 2);
    }

    BigDecimal menos(BigDecimal monto) {

        return monto.multiply(BigDecimal.valueOf(-1));
    }

    @Test
    void alAgregarUnGastoElMontoEsNegativo() {
        final String PROPIETARIO = "maxi";
        var saldo = new Saldo(PROPIETARIO);

        saldo.agregarGasto($(99,87));

        assertThat(saldo.getMonto()).isEqualTo(menos($(99, 87)));
    }

    @Test
    void sePuedeAgregarUnGasto() {

        final String PROPIETARIO = "juan";
        var saldoDeJuan = new Saldo(PROPIETARIO);

        saldoDeJuan.agregarGasto($(200,99));

        assertThat(saldoDeJuan.getMonto()).isEqualTo(menos($(200,99)));
    }

    @Test
    void sePuedeAgregarDosGastos() {

        final String PROPIETARIO = "lina";
        var saldoDeLina = new Saldo(PROPIETARIO);

        saldoDeLina.agregarGasto($(1000,66));
        saldoDeLina.agregarGasto($(234,33));

        assertThat(saldoDeLina.getMonto()).isEqualTo(BigDecimal.valueOf(-123499,2));
    }

    @Test
    @Disabled
    void elMontoDelSaldoDebeTenerDosDecimales() {

    }
}
