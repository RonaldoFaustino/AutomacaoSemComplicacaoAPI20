package plataformaFilmes;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlataformaFilmesTest {

    @Test
    public void validarLogin(){
        RestAssured.baseURI = "http://localhost:8080/";

        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";

        /*Response response = RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .body(json)
                .when()
                    .post("auth")
                    .thenReturn();*/
                //.then().statusCode(200).extract().response().prettyPrint();

        Response response = post(json,ContentType.JSON,"auth");

        assertEquals(200, response.statusCode());
        String token = response.body().jsonPath().get("token");

        System.out.println(token);
    }

    /**
     * Metodo Post
     * @param json
     * @param contentType
     * @param endpoint
     * @return
     */
    public Response post(Object json, ContentType contentType, String endpoint){

        /* Exemplo
         Response response = RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .contentType(contentType)
                    .body(json)
                .when()
                    .post(endPoint)
                    .thenReturn();
        return response;
        **/

        return RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .contentType(contentType)
                    .body(json)
                .when()
                    .post(endpoint)
                .thenReturn();
    }
}
