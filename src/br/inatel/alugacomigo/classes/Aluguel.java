package br.inatel.alugacomigo.classes;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;  

public class Aluguel {
    
    private int idAluguel;
    private String dataInicio;
    private String dataFim;
    private int km;
    private Veiculo veiculo;
    private Cliente cliente;
    private Funcionario funcionario;
    private float valorTotal;

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getQtdDias() throws ParseException{
        Date dateInicio = new SimpleDateFormat("dd/MM/yyyy").parse(this.dataInicio);
        Date dateFim = new SimpleDateFormat("dd/MM/yyyy").parse(this.dataFim);
        
        int diff = (int) (dateFim.getTime() - dateInicio.getTime());
        return diff;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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
