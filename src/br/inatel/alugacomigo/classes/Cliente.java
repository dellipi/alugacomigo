package br.inatel.alugacomigo.classes;

public class Cliente extends Pessoa {
    
    private boolean possuiPendencias;
    private float valorPendencias;
    private int qtdCarrosAlugados;
    private float totalGasto;
    private float descontoAtual;

    public boolean isPossuiPendencias() {
        return possuiPendencias;
    }

    public void setPossuiPendencias(boolean possuiPendencias) {
        this.possuiPendencias = possuiPendencias;
    }

    public float getValorPendencias() {
        return valorPendencias;
    }

    public void setValorPendencias(float valorPendencias) {
        this.valorPendencias = valorPendencias;
    }

    public int getQtdCarrosAlugados() {
        return qtdCarrosAlugados;
    }

    public void setQtdCarrosAlugados(int qtdCarrosAlugados) {
        this.qtdCarrosAlugados = qtdCarrosAlugados;
    }

    public float getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(float totalGasto) {
        this.totalGasto = totalGasto;
    }

    public float getDescontoAtual() {
        return descontoAtual;
    }

    public void setDescontoAtual(float descontoAtual) {
        this.descontoAtual = descontoAtual;
    }
    
}
