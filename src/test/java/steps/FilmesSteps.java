package steps;

import Utils.RestUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;

import java.util.HashMap;
import java.util.Map;

public class FilmesSteps {

    @Dado("que tenha um payload da API de Filme")
    public void que_tenha_um_payload_da_api_de_filme() {
        FilmesMap.initAll();
    }
    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizo_uma_requisicao_do_tipo_post_de_filme() {
        RestUtils.post(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON,"filmes");
    }
    @Entao("armazeno o id que recebo do response de Filme")
    public void armazeno_o_id_que_recebo_do_response_de_filme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme")
    public void realizo_uma_requisicao_do_tipo_get_de_filme() {
        Map<String, Object> param = new HashMap<>();
        String nomeFilme = FilmesMap.getFilme().get("nome").toString();
        param.put("nome", nomeFilme);
        RestUtils.get(FilmesMap.getHeader(), param, "filmes");
    }

    @Dado("altero o indice {int} da lista de Categotias de filme com os valores")
    public void alteroOIndiceDaListaDeCategotiasDeFilmeComOsValores(int indice, Map<String, Object> map) {
        FilmesMap.getListCategoria().get(indice).putAll(map);

    }

    @Quando("realizo uma requisicao do tipo PUT de Filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
        RestUtils.put(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes/"+ FilmesMap.id);
    }

    @Quando("realizo uma requisicao do tipo DELETE de Filme")
    public void realizoUmaRequisicaoDoTipoDELETEDeFilme() {
        RestUtils.delete(FilmesMap.getHeader(),"filmes/" + FilmesMap.id);
    }

}
