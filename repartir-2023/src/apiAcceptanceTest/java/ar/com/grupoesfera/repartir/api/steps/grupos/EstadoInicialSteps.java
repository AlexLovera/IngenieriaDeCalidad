package ar.com.grupoesfera.repartir.api.steps.grupos;

import ar.com.grupoesfera.repartir.api.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.*;

public class EstadoInicialSteps extends CucumberSteps {

    @Cuando("el usuario crea un grupo")
    public void elUsuarioCreaUnGrupo() {

        with()
                .contentType(ContentType.JSON)
                .body("""
                  {
                    "nombre": "Desayuno",
                    "miembros": [
                        "ceci", "nico", "luis"
                    ]
                  }
                  """)
                .when().post(url("/api/grupos"))
                .then().statusCode(200);
    }

    @Entonces("debería visualiza dentro del listado el grupo creado con total '$  {float}'")
    public void deberiaVisualizaDentroDelListadoElGrupoCreadoConTotal$(float monto) {

        with()
                .contentType(ContentType.JSON)
                .get(url("/api/grupos"))
                .then().statusCode(200)
                .body("nombre", contains("Desayuno"))
                .body("total", contains(monto));
    }
}
