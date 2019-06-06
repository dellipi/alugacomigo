package br.inatel.alugacomigo.classes;

public class Funcionario extends Pessoa implements CalculaSalario {
    
    private int idFuncionario;
    private Loja loja;
    private int qtdAlugeisRealizados;
    private float valorFaturado;
    private float salarioBase;
    private float bonus;
    
    @Override
    public float getSalarioTotal(){
        bonus = 0.15f * valorFaturado;
        return salarioBase + bonus;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public int getQtdAlugeisRealizados() {
        return qtdAlugeisRealizados;
    }

    public void setQtdAlugeisRealizados(int qtdAlugeisRealizados) {
        this.qtdAlugeisRealizados = qtdAlugeisRealizados;
    }

    public float getValorFaturado() {
        return valorFaturado;
    }

    public void setValorFaturado(float valorFaturado) {
        this.valorFaturado = valorFaturado;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
    
}
