package br.inatel.alugacomigo.classes;

public class Funcionario extends Pessoa implements CalculaSalario {
    
    private int idFuncionario;
    private Loja loja;
    private float valorFaturado;
    private float salarioBase;
    private String tipoFuncionario;
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

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
}
