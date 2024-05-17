package ar.com.grupoesfera.repartir.api.steps;

import ar.com.grupoesfera.repartir.api.atest.BaseDeDatosFixture;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("apiAcceptanceTest")
public abstract class CucumberSteps {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    protected BaseDeDatosFixture baseDeDatos;

    protected String url(String path) {

        return "http://localhost:" + randomServerPort + path;
    }

}
