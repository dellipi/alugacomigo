package br.inatel.alugacomigo.classes;

public class VeiculoPasseio extends Veiculo {
    
    private int capacidadePassageiros;
    private int capacidadeBagageiro;

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public int getCapacidadeBagageiro() {
        return capacidadeBagageiro;
    }

    public void setCapacidadeBagageiro(int capacidadeBagageiro) {
        this.capacidadeBagageiro = capacidadeBagageiro;
    }
    
}
