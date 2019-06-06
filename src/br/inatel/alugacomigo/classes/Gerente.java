package br.inatel.alugacomigo.classes;

public class Gerente extends Pessoa implements CalculaSalario {
    
    private int idGerente;
    private int qtdFuncionariosGerenciados;
    private Loja[] lojasGerenciadas;
    private float salarioBase;
    private float valorFaturadoTotal;
    private float bonus;
    
    @Override
    public float getSalarioTotal(){
        bonus = 0.3f * valorFaturadoTotal;
        return salarioBase + bonus;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public int getQtdFuncionariosGerenciados() {
        return qtdFuncionariosGerenciados;
    }

    public void setQtdFuncionariosGerenciados(int qtdFuncionariosGerenciados) {
        this.qtdFuncionariosGerenciados = qtdFuncionariosGerenciados;
    }

    public Loja[] getLojasGerenciadas() {
        return lojasGerenciadas;
    }

    public void setLojasGerenciadas(Loja[] lojasGerenciadas) {
        this.lojasGerenciadas = lojasGerenciadas;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getValorFaturadoTotal() {
        return valorFaturadoTotal;
    }

    public void setValorFaturadoTotal(float valorFaturadoTotal) {
        this.valorFaturadoTotal = valorFaturadoTotal;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
    
}
