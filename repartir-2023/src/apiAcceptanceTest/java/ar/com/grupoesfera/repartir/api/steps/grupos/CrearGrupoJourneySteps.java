package ar.com.grupoesfera.repartir.api.steps.grupos;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import ar.com.grupoesfera.repartir.api.steps.Step;
import io.cucumber.java.PendingException;

import java.util.List;

public class CrearGrupoJourneySteps extends CucumberSteps {

    @Step("no existe ningún grupo")
    public void noExisteNingunGrupo() {

        baseDeDatos.estaVacia();
    }

    @Step("existe un grupo")
    public void existeUnGrupo() {

        baseDeDatos.existeUnUnicoGrupo();
    }

    @Step("el usuario inicia la aplicación")
    public void elUsuarioIniciaLaAplicacion() {

        throw new PendingException();
    }

    @Step("el usuario selecciona crear grupo")
    public void elUsuarioSeleccionaCrearGrupo() {

        throw new PendingException();
    }

    @Step("completa con el nombre {string}")
    public void completaConElNombre(String nombre) {

        throw new PendingException();
    }

    @Step("indica que los miembros son {string}, {string} y {string}")
    public void indicaQueLosMiembroSon(String miembro1, String miembro2, String miembro3) {

        throw new PendingException();
    }

    @Step("indica que los miembros son:")
    public void indicaQueLosMiembroSon(List<String> miembros) {

        throw new PendingException();
    }

    @Step("guarda el grupo")
    public void guardaElGrupo() {

        throw new PendingException();
    }

    @Step("se muestra {int}° el grupo {string} con total {string}")
    public void seMuestraElNuevoGrupo(int posicion, String nombre, String total) {

        throw new PendingException();
    }
}
