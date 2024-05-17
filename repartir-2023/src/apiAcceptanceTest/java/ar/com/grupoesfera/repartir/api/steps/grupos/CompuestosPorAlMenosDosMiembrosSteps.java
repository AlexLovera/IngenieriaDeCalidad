package ar.com.grupoesfera.repartir.api.steps.grupos;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.with;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class CompuestosPorAlMenosDosMiembrosSteps extends CucumberSteps {

    private List<String> miembros;

    private String mensaje;

    private ValidatableResponse response;

    @Cuando("el usuario crea un grupo indicando que sus miembros son {miembros}")
    public void elUsuarioCreaUnGrupoIndicandoQueSusMiembrosSon(List<String> miembros) {

        this.miembros = miembros;

        var grupo = new HashMap<>() {{
           put("nombre", "Viaje de Semana Santa");
           put("miembros", miembros);
        }};

        with()
                .contentType(ContentType.JSON)
                .body(grupo)
                .when().post(url("/api/grupos"))
                .then().statusCode(200);
    }

    @Entonces("visualiza dentro del listado el grupo con los miembros indicados")
    public void visualizaDentroDelListadoElGrupoConLosMiembrosIndicados() {

        with()
                .contentType(ContentType.JSON)
                .get(url("/api/grupos"))
                .then()
                .body("miembros", contains(miembros));
    }

    @Cuando("el usuario intenta crear un grupo indicando un único miembro")
    public void elUsuarioIntentaCrearUnGrupoIndicandoUnUnicoMiembro() {

        String grupoConUnUnicoMiembro =
                """
                  {
                    "nombre": "",
                    "miembros": [ "marcelo" ]
                  }
                """;

        response = with()
                .contentType(ContentType.JSON)
                .body(grupoConUnUnicoMiembro)
                .when().post(url("/api/grupos"))
                .then();
    }

    @Entonces("no debería crear el grupo con un único miembro")
    public void noDeberiaCrearElGrupoConUnUnicoMiembro() {

        response.statusCode(400);
    }

    @Y("debería ser informado que necesita tener al menos dos miembros")
    public void deberiaSerInformadoQueNecesitaTenerAlMenosDosMiembros() {

        response.body("mensaje", equalTo("No puede tener un único miembro"));
    }
}
