package steps;

import Utils.RestUtils;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

import java.util.ArrayList;

public class GenericsSteps {
    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        System.out.println(RestUtils.getResponse().prettyPrint());
        Assert.assertEquals(status,RestUtils.getResponse().statusCode());
    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        System.out.println( "Lista de Filmes: " + RestUtils.getResponse().body().jsonPath().get().toString());
        Assert.assertEquals(value, RestUtils.getResponse().body().jsonPath().get(key));
    }
    @Entao("valido que recebo uma lista vazia no response")
    public void validoQueReceboUmaListaVaziaNoResponse() {
        Assert.assertEquals(new ArrayList<>(0), RestUtils.getResponse().jsonPath().get());
    }
}
