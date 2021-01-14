
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import config.GamePojo;
import config.VideoGameAPIConfig;
import config.VideoGameAPIEndpoints;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class FirstTest extends VideoGameAPIConfig {
    @Test
    public void getAllVideoGames() {
        given().
        when().
                get(VideoGameAPIEndpoints.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void createGameId11(){

        String gameJSON = "{\n" +
                "    \"id\": 11,\n" +
                "    \"name\": \"Bloodborne\",\n" +
                "    \"releaseDate\": \"2021-01-14T16:59:51.198Z\",\n" +
                "    \"reviewScore\": 99,\n" +
                "    \"category\": \"SoulsLike\",\n" +
                "    \"rating\": \"Awesome\"\n" +
                "  }\n";

        given().
                body(gameJSON).
        when().
                post(VideoGameAPIEndpoints.ALL_VIDEO_GAMES).
        then().
                body("id", equalTo("11")).
                body("name", equalTo("Bloodborne")).
                body("releaseDate", equalTo("2021-01-14T16:59:51.198Z")).
                body("reviewScore", equalTo("99")).
                body("category", equalTo("SoulsLike")).
                body("rating", equalTo("Awesome"));
    }

    @Test
    public void deleteGameId11(){
        given().

        when().
                delete(VideoGameAPIEndpoints.ALL_VIDEO_GAMES + "/11").
        then();
    }

    @Test
    public void createGame12Pojo(){
        GamePojo gamePojo = new GamePojo(12, "Dark Souls 3", "2021-01-14", 99, "SoulsLike", "Perfect");
        given().
                body(gamePojo).
        when().
                post(VideoGameAPIEndpoints.ALL_VIDEO_GAMES).
        then();

    }

    @Test
    public void getGame12(){
        given().

        when().
                get(VideoGameAPIEndpoints.ALL_VIDEO_GAMES + "/12").
        then().
                body("id", equalTo(12)).
                body("name", equalTo("Dark Souls 3")).
                body("releaseDate", equalTo("2021-01-14")).
                body("reviewScore", equalTo(99)).
                body("category", equalTo("SoulsLike")).
                body("rating", equalTo("Perfect"));
    }

    @Test
    public void deleteGameId12(){
        given().

        when().
                delete(VideoGameAPIEndpoints.ALL_VIDEO_GAMES + "/12").
        then();
    }
}
