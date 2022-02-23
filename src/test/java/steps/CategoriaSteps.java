package steps;

import Utils.RestUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import maps.LoginMap;

import java.util.HashMap;
import java.util.Map;

public class CategoriaSteps {

    Map<String, String> header = new HashMap<>();

    @Dado("que tenha um payload da API de Categoria")
    public void queTenhaUmPayloadDaAPIDeCategoria() {
        header.put("Authorization", "Bearer "+LoginMap.token);
    }

    @Quando("realizo uma requisicao do tipo GET de Categoria")
    public void realizoUmaRequisicaoDoTipoGETDeCategoria() {
        RestUtils.get(header,"categorias");
    }

}
