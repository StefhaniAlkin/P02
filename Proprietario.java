package model;

public class Proprietario {
    private int idProp;
    private String nome;
    private String cpf;

    public Proprietario() {
    }

    public Proprietario(int idProp, String nome, String cpf) {
        this.idProp = idProp;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
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
        this.cpf = cpf;
    }

    public void mostrarDados(){
        System.out.printf("Dados Proprietario\n\nID: "+getIdProp()+"\nNome: "+getNome()+"\nCPF: "+getCpf());
    }
}
