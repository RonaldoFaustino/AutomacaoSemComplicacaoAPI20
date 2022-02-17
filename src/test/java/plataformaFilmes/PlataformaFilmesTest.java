package plataformaFilmes;


import Utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PlataformaFilmesTest {

    static String token;

    /***
     * Metodo Post com Map
     */
    @BeforeAll
    public static void validarLoginMap(){
       RestUtils.setBaseURI("http://localhost:8080/");

        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(),ContentType.JSON,"auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.body().jsonPath().get("token");

    }

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

        RestUtils.post(json,ContentType.JSON,"auth");

        assertEquals(200, RestUtils.getResponse().statusCode());
        String token = RestUtils.getResponse().body().jsonPath().get("token");

        System.out.println("Token gerado: " + token);
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+LoginMap.token);

        Response response = RestUtils.
                get(header,"categorias");

        assertEquals(200,response.statusCode());

        assertEquals("Terror",response.body().jsonPath().get("tipo[2]"));

        List<String> listTipo = response.body().jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"),"Não foi encontrado a lista");


        System.out.println( "Lista de Filmes: " + response.getBody().jsonPath().get().toString());
    }

    @Test
    public void test(){
        String [] vetorCompras = {"arroz", "feijão","cerveja", "carne"};
        System.out.println(vetorCompras[1]);
        System.out.println(Arrays.stream(vetorCompras).count());

        List<String> listaCompras =  new ArrayList<>();
        listaCompras.add("arroz");
        listaCompras.add("feijão");
        listaCompras.add("cerveja");
        listaCompras.add("carne");

        System.out.println(listaCompras.get(2));

    }


}
