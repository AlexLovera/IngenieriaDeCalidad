package ar.com.grupoesfera.repartir.api.steps.grupos;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NombreQueLosIdentificaSteps extends CucumberSteps {

    private String nombreIndicado;
    private String mensaje;
    private ValidatableResponse response;

    @Cuando("el usuario crea un grupo indicando el nombre {string}")
    public void elUsuarioCreaUnGrupoIndicandoElNombre(String nombre) {

        nombreIndicado = nombre;
        String grupo =
                """
                  {
                    "nombre": "<NOMBRE>",
                    "miembros": [
                        "marcos", "juana"
                    ]
                  }
                """.replaceAll("<NOMBRE>", nombreIndicado);

        with()
                .contentType(ContentType.JSON)
                .body(grupo)
                .when().post(url("/api/grupos"))
                .then().statusCode(200);
    }

    @Entonces("debería visualizar dentro del listado el grupo con el nombre indicado")
    public void deberiaVisualizarDentroDelListadoElGrupoConElNombreIndicado() {

        with()
                .contentType(ContentType.JSON)
                .get(url("/api/grupos"))
                .then()
                .body("nombre", contains(nombreIndicado));
    }

    @Cuando("el usuario intenta crear un grupo sin indicar su nombre")
    public void elUsuarioIntentaCrearUnGrupoSinIndicarSuNombre() {

        String grupoSinNombre =
                """
                  {
                    "nombre": "",
                    "miembros": [
                        "marcos", "juana"
                    ]
                  }
                """;

        response = with()
                .contentType(ContentType.JSON)
                .body(grupoSinNombre)
                .when().post(url("/api/grupos"))
                .then();
    }

    @Entonces("no debería crear el grupo sin nombre")
    public void noDeberiaCrearElGrupoSinNombre() {

        response.statusCode(400);
    }

    @Y("debería ser informado que no puede crear un grupo sin nombre")
    public void deberiaSerInformadoQueNoPuedeCrearUnGrupoSinNombre() {

        response.body("mensaje", equalTo("El nombre es requerido"));
    }

}
