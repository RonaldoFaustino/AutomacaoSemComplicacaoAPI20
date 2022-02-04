package transferencia;

public class Cliente {

    public String nome;
    public String cpf;
    public String rg;

    public Cliente(){

    }

    public Cliente(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

   public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

}
