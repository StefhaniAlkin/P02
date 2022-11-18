package model;

import model.Veiculo;

public class Automovel extends Veiculo {
    private int numeroPortas;
    private int numeroPassageiros;


    public Automovel(int idVeic, String placa, String marca, Proprietario proprietario, int numeroPortas, int numeroPassageiros) {
        super(idVeic, placa, marca, proprietario);
        this.numeroPortas = numeroPortas;
        this.numeroPassageiros = numeroPassageiros;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public void mostrarDados(){
        System.out.println("Dados Automovel\n\nNumero de Portas: " + getNumeroPortas() + "\nNumero de Passageiros: "+getNumeroPassageiros());
    }
}
