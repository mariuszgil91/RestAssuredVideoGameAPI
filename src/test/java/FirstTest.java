import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

import config.VideoGameAPIConfig;
import config.VideoGameAPIEndpoints;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class FirstTest extends VideoGameAPIConfig {
    @Test
    public void getAllGames() {
        given().
                when().get(VideoGameAPIEndpoints.ALL_VIDEO_GAMES).
                then();
    }
}
