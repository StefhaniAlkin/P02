package model;

import model.Veiculo;

public class Caminhao extends Veiculo {
    private double cargaMaxima;
    private double comprimento;

    public Caminhao(int idVeic, String placa, String marca, Proprietario proprietario, double cargaMaxima, double comprimento) {
        super(idVeic, placa, marca, proprietario);
        this.cargaMaxima = cargaMaxima;
        this.comprimento = comprimento;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void mostrarDados(){
        System.out.println("\nDados do Caminhao\n\nCarga máxima: "+getCargaMaxima()+"\nComprimento: "+getComprimento());
    }
}
