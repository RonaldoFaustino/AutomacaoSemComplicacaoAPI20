package steps;

import Utils.RestUtils;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

public class GenericsSteps {
    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status,RestUtils.getResponse().statusCode());
    }
}
