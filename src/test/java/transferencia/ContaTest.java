package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContaTest {

    Cliente xuxa;
    Cliente silvio;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "13113113122","1231313");
        silvio = new Cliente("Silvio", "93113113122","5231313");

        contaXuxa = new Conta("0025","123456",2500.00,xuxa);
        contaSilvio = new Conta("0025","123456",5500.00,silvio);
    }

    @Test
    public void realizarTransacao(){
        contaSilvio.realizarTransferencia(3000.00,contaXuxa);
        assertEquals(5500.00, contaXuxa.getSaldo());
        assertEquals(2500.00,contaSilvio.getSaldo());
    }

    @Test
    public void realizarTransferenciaInvalida(){
        boolean resultado = contaSilvio.realizarTransferencia(6000.00,contaXuxa);
        assertFalse(resultado);
    }

    @Test
    public void validarProprietario(){
        assertEquals(xuxa, contaXuxa.getProprietario());
    }
}
