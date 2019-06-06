package br.inatel.alugacomigo.classes;

public abstract class Veiculo {
    
    private String chassi;
    private String marca;
    private String modelo;
    private String placa;
    private int potenciaMotor;
    private int torqueMotor;
    private String classificacaoConsumo;
    private float consumoMedio;
    private int quilometragem;
    private float valorAluguelDiaria;
    private float valorAluguelKM;
    private float valorVenda;
    private Loja loja;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
    public float getTotalDiaria(int dias){
        return valorAluguelDiaria * dias;
    }
    
    public float getTotalKM(int km){
        return valorAluguelKM * km;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public int getTorqueMotor() {
        return torqueMotor;
    }

    public void setTorqueMotor(int torqueMotor) {
        this.torqueMotor = torqueMotor;
    }

    public String getClassificacaoConsumo() {
        return classificacaoConsumo;
    }

    public void setClassificacaoConsumo(String classificacaoConsumo) {
        this.classificacaoConsumo = classificacaoConsumo;
    }

    public float getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(float consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getValorAluguelDiaria() {
        return valorAluguelDiaria;
    }

    public void setValorAluguelDiaria(float valorAluguelDiaria) {
        this.valorAluguelDiaria = valorAluguelDiaria;
    }

    public float getValorAluguelKM() {
        return valorAluguelKM;
    }

    public void setValorAluguelKM(float valorAluguelKM) {
        this.valorAluguelKM = valorAluguelKM;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
}
