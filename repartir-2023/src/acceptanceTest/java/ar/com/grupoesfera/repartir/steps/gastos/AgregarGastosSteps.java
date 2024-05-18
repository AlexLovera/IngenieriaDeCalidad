package ar.com.grupoesfera.repartir.steps.gastos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import ar.com.grupoesfera.repartir.steps.Step;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AgregarGastosSteps extends CucumberSteps {
    private int idGrupoExito;
    private final int _idGrupoInicial = 1;

    @Dado("que ya existe el grupo #{int} llamado {string}")
    public void yaExisteElGrupoConIdLlamado(int idGrupo, String nombre) {
        this.idGrupoExito = idGrupo;
//        baseDeDatos.tieneElGrupoSinGastosNiIntegrantes(idGrupo, nombre);
        baseDeDatos.tieneElGrupoSinGastos(idGrupo, nombre);
    }

    @Dado("el grupo #{int} tiene 2 integrantes")
    public void elGrupoTieneIntegrantes(int idGrupo) {
//        baseDeDatos.tieneDosMiembrosElGrupo(idGrupo);
    }

    @Cuando("el usuario quiere guardar un gasto con monto de {string} pesos")
    public void elUsuarioQuiereGuardarUnGastoDePesosPositivo(String monto) {
        var wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("mensajesToast")));
        var agregarGastoButton = wait.until(visibilityOfElementLocated(By.id("agregarGastoGruposButton-" + _idGrupoInicial)));

        agregarGastoButton.click();

        // completa con el parametro monto
        var montoInput = driver.findElement(By.id("montoGastoNuevoInput"));
        montoInput.clear();
        montoInput.sendKeys(monto);

        var guardarGastoNuevoButton = driver.findElement(By.id("guardarGastoNuevoButton"));
        guardarGastoNuevoButton.click();
    }

    @Entonces("deberia visualizar un mensaje con {string} {string}")
    public void visualizaMensajeDeGastoAgregado(String mensajeExitoError,String mensaje) {

        var wait = new WebDriverWait(driver, 2);

        var mensajesToast = wait.until(visibilityOfElementLocated(By.id("mensajesToast")));
        assertThat(mensajesToast.getText())
                .contains(mensajeExitoError)
                .contains(mensaje);
    }
}
