package br.inatel.alugacomigo.classes;

public class VeiculoComercial extends Veiculo {

    private int capacidadeCargaVolume;
    private int capacidadeCargaPeso;

    public int getCapacidadeCargaVolume() {
        return capacidadeCargaVolume;
    }

    public void setCapacidadeCargaVolume(int capacidadeCargaVolume) {
        this.capacidadeCargaVolume = capacidadeCargaVolume;
    }

    public int getCapacidadeCargaPeso() {
        return capacidadeCargaPeso;
    }

    public void setCapacidadeCargaPeso(int capacidadeCargaPeso) {
        this.capacidadeCargaPeso = capacidadeCargaPeso;
    }
    
}
