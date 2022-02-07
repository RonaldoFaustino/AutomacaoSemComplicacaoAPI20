package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {
    private static Response response;

    public static Response getResponse() {
        return response;
    }



    public static void setBaseURI(String uri){
        RestAssured.baseURI = uri;
    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    /**
     * Metodo Post
     * @param json
     * @param contentType
     * @param endpoint
     * @return
     */
    public static Response post(Object json, ContentType contentType, String endpoint){

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

        /*return RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();**/

        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();

        return response;
    }

    /***
     * Metodo get
     * @param header
     * @return
     */
    public static Response get(Map<String, String> header, String endpoint){
        return RestAssured
                .given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .thenReturn();
    }
}
