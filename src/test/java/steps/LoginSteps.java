package steps;

import Utils.RestUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;

import java.util.Map;

public class LoginSteps {


    String url  = "http://localhost:8080/";


    @Dado("que tenha um payload valido da API de Login")
    public void queTenhaUmPayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
    }
    @Quando("envio uma requisicao do tipo Post de Login")
    public void envioUmaRequisicaoDoTipoPostDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }

    @Dado("que tenha um payload da API de Login com as seguintes infromacoes")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInfromacoes(Map<String, String> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
        LoginMap.getLogin().putAll(map);
    }



}
