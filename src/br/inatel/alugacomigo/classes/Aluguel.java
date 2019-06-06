package br.inatel.alugacomigo.classes;

import java.util.Date;

public class Aluguel {
    
    private Date dataInicio;
    private Date dataFim;
    private int km;
    private VeiculoPasseio vp;
    private VeiculoComercial vc;
    private Cliente cliente;
    private Funcionario funcionario;
    
    public int getQtdDias(){
        int diff = (int) (dataFim.getTime() - dataInicio.getTime());
        return diff;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public VeiculoPasseio getVp() {
        return vp;
    }

    public void setVp(VeiculoPasseio vp) {
        this.vp = vp;
    }

    public VeiculoComercial getVc() {
        return vc;
    }

    public void setVc(VeiculoComercial vc) {
        this.vc = vc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
