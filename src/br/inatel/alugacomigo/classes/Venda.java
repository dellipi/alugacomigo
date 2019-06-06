package br.inatel.alugacomigo.classes;

public class Venda {

    private VeiculoPasseio vp;
    private VeiculoComercial vc;
    private Cliente cliente;
    private Funcionario funcionario;    

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
