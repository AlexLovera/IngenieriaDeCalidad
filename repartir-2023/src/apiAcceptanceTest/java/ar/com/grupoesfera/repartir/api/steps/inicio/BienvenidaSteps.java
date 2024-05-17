package ar.com.grupoesfera.repartir.api.steps.inicio;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BienvenidaSteps extends CucumberSteps {

    private String usuario;
    private ValidatableResponse response;

    @Then("el usuario accede a la aplicación")
    public void elUsuarioAccedeALaAplicacion() {


    }

    @Then("se muestra el mensaje de bienvenida")
    public void seMuestraElMensajeDeBienvenida() {


    }

    @Given("que el usuario accedió a la aplicación")
    public void queElUsuarioAccedioALaAplicacion() {


    }

    @When("decidió iniciar")
    public void decidioIniciar() {

        usuario = "catalina";
        response = with()
                    .pathParam("usuario", usuario)
                .when()
                    .get(url("/api/usuarios/{usuario}"), usuario)
                .then();

    }

    @Then("puede empezar a usarla")
    public void puedeEmpezarAUsarla() {

        response.body("id", equalTo(usuario))
                .body("correo", equalTo(usuario + "@repartir.com"));
    }

    @Dado("que el usuario inició Repartir")
    public void elUsuarioInicioRepartir() {

        baseDeDatos.estaVacia();
    }

    @Before
    public void prepararBaseDeDatos() {

        baseDeDatos.estaVacia();
    }

}
