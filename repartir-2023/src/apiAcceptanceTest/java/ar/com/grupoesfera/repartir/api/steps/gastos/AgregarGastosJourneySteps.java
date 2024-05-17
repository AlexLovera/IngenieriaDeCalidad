package ar.com.grupoesfera.repartir.api.steps.gastos;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import ar.com.grupoesfera.repartir.api.steps.Step;
import io.cucumber.java.PendingException;

import static org.assertj.core.api.Assertions.assertThat;

public class AgregarGastosJourneySteps extends CucumberSteps {

    @Step("existe el grupo #{int} {string} sin gastos")
    public void existeElGrupoSinGastos(int idGrupo, String nombre) {

        baseDeDatos.tieneElGrupoSinGastos(idGrupo, nombre);
    }

    @Step("el usuario selecciona agregar gasto al grupo #{int}")
    public void elUsuarioSeleccionaAgregarGastoAlGrupo(int idGrupo) {

        throw new PendingException();
    }

    @Step("completa con el monto de $ {string}")
    public void completaConElMontoDe(String monto) {

        throw new PendingException();
    }

    @Step("guarda el gasto")
    public void guardaElGasto() {

        throw new PendingException();
    }

    @Step("ve la confirmación {string}")
    public void veLaConfirmación(String mensaje) {

        throw new PendingException();
    }

    @Step("ve el total del grupo #{int} actualizado a {string}")
    public void veElTotalDelGrupoActualidadoA$(int idGrupo, String monto) {

        throw new PendingException();
    }
}
