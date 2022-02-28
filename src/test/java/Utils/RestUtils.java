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

    /**
     * Metodo Post
     * @param json
     * @param contentType
     * @param endpoint
     * @return
     */
    public static Response post(Map<String, String> header, Object json, ContentType contentType, String endpoint){

        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .headers(header)
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
    public static Response get(Map<String, String> header,Map<String, Object> param, String endpoint){
        return response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .headers(header)
                .params(param)
                .when()
                .get(endpoint)
                .thenReturn();
    }

    /***
     * Metodo get
     * @param header
     * @return
     */
    public static Response get(Map<String, String> header, String endpoint){
        return response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .thenReturn();
    }

    /**
     * Metodo Put
     * @param json
     * @param contentType
     * @param endpoint
     * @return
     */
    public static Response put(Map<String, String> header, Object json, ContentType contentType, String endpoint){

        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .headers(header)
                .body(json)
                .when()
                .put(endpoint)
                .thenReturn();

        return response;
    }

    /***
     * Metodo get
     * @param header
     * @return
     */
    public static Response delete(Map<String, String> header, String endpoint){
        return response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .delete(endpoint)
                .thenReturn();
    }
}
