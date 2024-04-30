import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class Test {
    @org.junit.Test
    public void testStatusCode() {
        RestAssured.baseURI = "https://api.agify.io/?name=meelad";

        Response response = given()
                .when()
                .get(baseURI)
                .then()
                .extract().response();
        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        response.then().assertThat().body("name", equalTo("meelad"));
        response.then().assertThat().body("age", equalTo(34));
        response.then().assertThat().body("count", equalTo(21));






    }

}
