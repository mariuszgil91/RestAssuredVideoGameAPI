package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameAPIConfig {

    public static RequestSpecification videoGameAPI_requestSpec;
    public static ResponseSpecification videoGameAPI_responseSpec;

    @BeforeClass
    public static void setup() {

        videoGameAPI_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setBasePath("/app/")
                .setPort(8080)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        videoGameAPI_responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();

        RestAssured.requestSpecification = videoGameAPI_requestSpec;
        RestAssured.responseSpecification = videoGameAPI_responseSpec;

    }
}
