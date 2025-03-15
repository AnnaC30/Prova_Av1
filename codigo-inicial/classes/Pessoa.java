package classes;

public class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}
