package sk.malyp;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import sk.malyp.model.Conference;
import sk.malyp.service.ConferenceService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class ConferenceResourceTest {

    @Inject
    ConferenceService conferenceService;

    @Test
    void getConferences_empty_failOtherwise() {
        given()
          .when().get("/conference")
          .then()
             .statusCode(200)
            .body(is("[]"))
            .log().all();
    }

    @Test
    void getConferences_nonEmpty_failOtherwise() {
        conferenceService.createConference("NConnect 2025", LocalDate.of(2025, 3, 26));
        given()
          .when().get("/conference")
          .then()
             .statusCode(200)
            .body(not("[]"))
            .log().all();
    }
    

}