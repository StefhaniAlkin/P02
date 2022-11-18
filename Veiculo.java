package model;

public class Veiculo {
    private int idVeic;
    private String placa;
    private String marca;
    private Proprietario proprietario;

    public Veiculo() {
    }

    public Veiculo(int idVeic, String placa, String marca, Proprietario proprietario) {
        this.idVeic = idVeic;
        this.placa = placa;
        this.marca = marca;
        this.proprietario = proprietario;
    }

    public int getIdVeic() {
        return idVeic;
    }

    public void setIdVeic(int idVeic) {
        this.idVeic = idVeic;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    public void mostrarDados(){
        System.out.println("\nDados do Veiculo\n\nID: "+ getIdVeic()+"\nPlaca: "+getPlaca()+"\nMarca: "+getMarca()+"\nProprietario: " + getProprietario().getNome());
    }
}
