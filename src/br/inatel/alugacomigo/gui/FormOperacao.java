package br.inatel.alugacomigo.gui;

import br.inatel.alugacomigo.dao.*;
import br.inatel.alugacomigo.classes.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.Flags;

public class FormOperacao extends javax.swing.JFrame {
    
    Aluguel aluguel = new Aluguel();
    AluguelDAO aluguelDAO = new AluguelDAO();
    Venda venda = new Venda();
    VendaDAO vendaDAO = new VendaDAO();
    
    Cliente cliente = new Cliente();
    Funcionario funcionario = new Funcionario();
    PessoaDAO pessoaDAO = new PessoaDAO();
    
    Veiculo veiculoPasseio = new VeiculoPasseio();
    Veiculo veiculoComercial = new VeiculoComercial();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public FormOperacao() {
        initComponents();
    }
    
    public int getQtdDias() throws ParseException{
        Date dateInicio = new SimpleDateFormat("dd/MM/yyyy").parse(campoDataInicio.getText());
        Date dateFim = new SimpleDateFormat("dd/MM/yyyy").parse(campoDataFim.getText());
        
        int diff = (int) (dateFim.getTime() - dateInicio.getTime());
        return (diff / (1000*60*60*24));
    }
    
    private boolean camposVaziosA() {
        boolean verificacao = false;
        if (campoCPFCliente.getText().equals("   .   .   -  ")
                || campoIDFuncionario.getText().equals("")
                || campoChassi.getText().equals("")
                || campoDataInicio.getText().equals("  /  /    ")
                || campoDataFim.getText().equals("  /  /    ")
                || tipoVeiculo.getSelectedIndex() == 0
                //|| campoKM.getText().equals("")
                ) {
            verificacao = true;
        }
        return (verificacao);
    }
    
    private boolean camposVaziosV() {
        boolean verificacao = false;
        if (campoCPFCliente.getText().equals("   .   .   -  ")
                || campoIDFuncionario.getText().equals("")
                || campoChassi.getText().equals("")
                || campoDataVenda.getText().equals("  /  /    ")
                || tipoVeiculo.getSelectedIndex() == 0
                ) {
            verificacao = true;
        }
        return (verificacao);
    }
    
    private void preencherClasseA(){
        cliente = (Cliente) pessoaDAO.pesquisar(campoCPFCliente.getText(), 0);
        funcionario = (Funcionario) pessoaDAO.pesquisarFunc(Integer.parseInt(campoIDFuncionario.getText()));
        
        aluguel.setCliente(cliente);
        aluguel.setFuncionario(funcionario);
        
        if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
            veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
            aluguel.setVeiculo(veiculoComercial);
        }
        else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
            veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
            aluguel.setVeiculo(veiculoPasseio);
        }
        
        aluguel.setDataInicio(campoDataInicio.getText());
        aluguel.setDataFim(campoDataFim.getText());
        aluguel.setKm(Integer.parseInt(campoKM.getText()));
        aluguel.setValorTotal(Float.parseFloat(campoValorTotalA.getText()));
    }

    private void preencherClasseV(){
        cliente = (Cliente) pessoaDAO.pesquisar(campoCPFCliente.getText(), 0);
        funcionario = (Funcionario) pessoaDAO.pesquisarFunc(Integer.parseInt(campoIDFuncionario.getText()));
        
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        
        if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
            veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
            venda.setVeiculo(veiculoComercial);
        }
        else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
            veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
            venda.setVeiculo(veiculoPasseio);
        }
        
        venda.setDataVenda(campoDataVenda.getText());
        venda.setValorTotal(Float.parseFloat(campoValorTotal.getText()));
    }
    
    private void preencherCamposA(){
        campoCPFCliente.setText(aluguel.getCliente().getCpf());
        campoIDFuncionario.setText(String.valueOf(aluguel.getFuncionario().getIdFuncionario()));
        campoIDAluguel.setText(String.valueOf(aluguel.getIdAluguel()));
        campoChassi.setText(aluguel.getVeiculo().getChassi());
        if(aluguel.getVeiculo() instanceof VeiculoComercial){
            tipoVeiculo.setSelectedItem("Veículo Comercial");
        }
        else if(aluguel.getVeiculo() instanceof VeiculoPasseio){
            tipoVeiculo.setSelectedItem("Veículo de Passeio");
        }
        if(aluguel.getKm() > 0){
            tipoAluguel.setSelectedItem("Por quilometragem");
        }
        else {
            tipoVeiculo.setSelectedItem("Por dia");
        }
        campoDataInicio.setText(aluguel.getDataInicio());
        campoDataFim.setText(aluguel.getDataFim());
        campoKM.setText(String.valueOf(aluguel.getKm()));
        campoValorTotalA.setText(String.valueOf(aluguel.getValorTotal()));
    }

    private void preencherCamposV() {
        campoCPFCliente.setText(venda.getCliente().getCpf());
        campoIDFuncionario.setText(String.valueOf(venda.getFuncionario().getIdFuncionario()));
        campoIDVenda.setText(String.valueOf(venda.getIdVenda()));
        campoChassi.setText(venda.getVeiculo().getChassi());
        if(venda.getVeiculo() instanceof VeiculoComercial){
            tipoVeiculo.setSelectedItem("Veículo Comercial");
        }
        else if(venda.getVeiculo() instanceof VeiculoPasseio){
            tipoVeiculo.setSelectedItem("Veículo de Passeio");
        }
        campoDataVenda.setText(venda.getDataVenda());
        campoValorTotal.setText(String.valueOf(venda.getValorTotal()));
    }
    
    private void limparA(){
        campoCPFCliente.setText(null);
        campoIDFuncionario.setText(null);
        campoIDAluguel.setText(null);
        campoChassi.setText(null);
        tipoAluguel.setSelectedIndex(0);
        tipoVeiculo.setSelectedIndex(0);
        campoDataInicio.setText(null);
        campoDataFim.setText(null);
        campoKM.setText(null);
        campoValorTotalA.setText(null);
    }

    private void limparV() {
        campoCPFCliente.setText(null);
        campoIDFuncionario.setText(null);
        campoIDVenda.setText(null);
        campoChassi.setText(null);
        tipoVeiculo.setSelectedIndex(0);
        campoDataVenda.setText(null);
        campoValorTotal.setText(null);
    }

    private void padraoBotoesA(boolean ativacao) {
        if (ativacao == true) {
            botaoPesquisarAluguel.setText("CANCELAR");
            botaoInserirA.setEnabled(false);
            botaoExcluirA.setEnabled(true);
            botaoEditarA.setEnabled(true);
            botaoLimparA.setEnabled(false);
            campoCPFCliente.setEnabled(false);
            campoIDFuncionario.setEnabled(false);
            campoChassi.setEnabled(false);
            campoIDAluguel.setEnabled(false);
        } else {
            botaoPesquisarAluguel.setText("PESQUISAR");
            botaoPesquisarAluguel.setSelected(false);
            botaoInserirA.setEnabled(true);
            botaoExcluirA.setEnabled(false);
            botaoEditarA.setEnabled(false);
            botaoLimparA.setEnabled(true);
            campoCPFCliente.setEnabled(true);
            campoIDFuncionario.setEnabled(true);
            campoChassi.setEnabled(true);
            campoIDAluguel.setEnabled(true);
            limparA();
        }
    }
    
    private void padraoBotoesV(boolean ativacao) {
        if (ativacao == true) {
            botaoPesquisarVenda.setText("CANCELAR");
            botaoInserirV.setEnabled(false);
            botaoExcluirV.setEnabled(true);
            botaoEditarV.setEnabled(true);
            botaoLimparV.setEnabled(false);
            campoCPFCliente.setEnabled(false);
            campoIDFuncionario.setEnabled(false);
            campoChassi.setEnabled(false);
            campoIDVenda.setEnabled(false);                    
        } else {
            botaoPesquisarVenda.setText("PESQUISAR");
            botaoPesquisarVenda.setSelected(false);
            botaoInserirV.setEnabled(true);
            botaoExcluirV.setEnabled(false);
            botaoEditarV.setEnabled(false);
            botaoLimparV.setEnabled(true);
            campoCPFCliente.setEnabled(true);
            campoIDFuncionario.setEnabled(true);
            campoChassi.setEnabled(true);
            campoIDVenda.setEnabled(true);
            limparV();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        panelTitulo = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        painelPesquisa = new javax.swing.JPanel();
        labelSubtitulo1 = new javax.swing.JLabel();
        labelCPFPesquisa = new javax.swing.JLabel();
        botaoPesquisarVenda = new javax.swing.JToggleButton();
        campoIDAluguel = new javax.swing.JTextField();
        labelSubtitulo3 = new javax.swing.JLabel();
        labelCPFPesquisa1 = new javax.swing.JLabel();
        campoIDVenda = new javax.swing.JTextField();
        botaoPesquisarAluguel = new javax.swing.JToggleButton();
        painelFormulario = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelLogradouro = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        campoKM = new javax.swing.JTextField();
        campoValorTotalA = new javax.swing.JTextField();
        labelSubtitulo5 = new javax.swing.JLabel();
        campoDataInicio = new javax.swing.JFormattedTextField();
        campoDataFim = new javax.swing.JFormattedTextField();
        labelNome3 = new javax.swing.JLabel();
        tipoAluguel = new javax.swing.JComboBox<>();
        painelFormulario1 = new javax.swing.JPanel();
        labelNome1 = new javax.swing.JLabel();
        labelLogradouro1 = new javax.swing.JLabel();
        campoValorTotal = new javax.swing.JTextField();
        labelSubtitulo6 = new javax.swing.JLabel();
        campoDataVenda = new javax.swing.JFormattedTextField();
        painelFormulario2 = new javax.swing.JPanel();
        labelNome2 = new javax.swing.JLabel();
        labelLogradouro2 = new javax.swing.JLabel();
        labelNumero2 = new javax.swing.JLabel();
        campoChassi = new javax.swing.JTextField();
        campoIDFuncionario = new javax.swing.JTextField();
        campoCPFCliente = new javax.swing.JFormattedTextField();
        labelNumero3 = new javax.swing.JLabel();
        tipoVeiculo = new javax.swing.JComboBox<>();
        painelAcao = new javax.swing.JPanel();
        labelSubtitulo2 = new javax.swing.JLabel();
        botaoInserirA = new javax.swing.JButton();
        botaoEditarA = new javax.swing.JButton();
        botaoExcluirA = new javax.swing.JButton();
        botaoLimparA = new javax.swing.JButton();
        painelAcao1 = new javax.swing.JPanel();
        labelSubtitulo4 = new javax.swing.JLabel();
        botaoInserirV = new javax.swing.JButton();
        botaoEditarV = new javax.swing.JButton();
        botaoExcluirV = new javax.swing.JButton();
        botaoLimparV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoVoltar.setText("VOLTAR");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("OPERAÇÕES");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelPesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo1.setText("Pesquisar Aluguel");

        labelCPFPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCPFPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPFPesquisa.setText("ID: ");

        botaoPesquisarVenda.setText("PESQUISAR");
        botaoPesquisarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarVendaActionPerformed(evt);
            }
        });

        campoIDAluguel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelSubtitulo3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo3.setText("Pesquisar Venda");

        labelCPFPesquisa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCPFPesquisa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPFPesquisa1.setText("ID: ");

        campoIDVenda.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        botaoPesquisarAluguel.setText("PESQUISAR");
        botaoPesquisarAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarAluguelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCPFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoIDAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(botaoPesquisarAluguel)
                .addGap(18, 18, 18)
                .addComponent(labelSubtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCPFPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoPesquisarVenda)
                .addContainerGap())
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPFPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSubtitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoPesquisarVenda)
                    .addComponent(campoIDAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSubtitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCPFPesquisa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarAluguel))
                .addContainerGap())
        );

        painelFormulario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Data Início:");

        labelLogradouro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogradouro.setText("Data Final:");

        labelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero.setText("Quilometragem:");

        labelBairro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBairro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBairro.setText("Valor Total:");

        campoKM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoKM.setEnabled(false);
        campoKM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoKMFocusLost(evt);
            }
        });

        campoValorTotalA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoValorTotalA.setEnabled(false);

        labelSubtitulo5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo5.setText("ALUGUEL");

        try {
            campoDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDataFimFocusLost(evt);
            }
        });

        labelNome3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome3.setText("Tipo Aluguel:");

        tipoAluguel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tipoAluguel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Por dia", "Por quilometragem" }));
        tipoAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAluguelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFormularioLayout = new javax.swing.GroupLayout(painelFormulario);
        painelFormulario.setLayout(painelFormularioLayout);
        painelFormularioLayout.setHorizontalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelNumero)
                        .addGap(4, 4, 4)
                        .addComponent(campoKM, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorTotalA, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDataInicio)
                            .addComponent(campoDataFim)
                            .addGroup(painelFormularioLayout.createSequentialGroup()
                                .addComponent(tipoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(labelSubtitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelFormularioLayout.setVerticalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelSubtitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoKM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoValorTotalA))
                .addContainerGap())
        );

        painelFormulario1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelNome1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome1.setText("Data Venda:");

        labelLogradouro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLogradouro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogradouro1.setText("Valor Total:");

        campoValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        campoValorTotal.setEnabled(false);

        labelSubtitulo6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo6.setText("VENDA");

        try {
            campoDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDataVendaFocusLost(evt);
            }
        });
        campoDataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFormulario1Layout = new javax.swing.GroupLayout(painelFormulario1);
        painelFormulario1.setLayout(painelFormulario1Layout);
        painelFormulario1Layout.setHorizontalGroup(
            painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormulario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormulario1Layout.createSequentialGroup()
                        .addGroup(painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelLogradouro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDataVenda, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(labelSubtitulo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelFormulario1Layout.setVerticalGroup(
            painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormulario1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogradouro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoValorTotal))
                .addGap(69, 69, 69))
        );

        painelFormulario2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelNome2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome2.setText("CPF Clente:");

        labelLogradouro2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLogradouro2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogradouro2.setText("ID Funcionário:");

        labelNumero2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumero2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero2.setText("Chassi Veículo:");

        campoChassi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoIDFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoCPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelNumero3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumero3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero3.setText("Tipo Veículo:");

        tipoVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Veículo Comercial", "Veículo de Passeio" }));

        javax.swing.GroupLayout painelFormulario2Layout = new javax.swing.GroupLayout(painelFormulario2);
        painelFormulario2.setLayout(painelFormulario2Layout);
        painelFormulario2Layout.setHorizontalGroup(
            painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormulario2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFormulario2Layout.createSequentialGroup()
                        .addComponent(labelNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelNome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelLogradouro2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoCPFCliente)
                        .addComponent(campoIDFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormulario2Layout.createSequentialGroup()
                        .addComponent(labelNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(191, 191, 191))
        );
        painelFormulario2Layout.setVerticalGroup(
            painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormulario2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogradouro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoIDFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoChassi)
                    .addComponent(labelNumero3)
                    .addComponent(tipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelAcao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo2.setText("AÇÕES - ALUGUEL");

        botaoInserirA.setText("INSERIR");
        botaoInserirA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirAActionPerformed(evt);
            }
        });

        botaoEditarA.setText("EDITAR");
        botaoEditarA.setEnabled(false);
        botaoEditarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarAActionPerformed(evt);
            }
        });

        botaoExcluirA.setText("EXCLUIR");
        botaoExcluirA.setEnabled(false);
        botaoExcluirA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirAActionPerformed(evt);
            }
        });

        botaoLimparA.setText("LIMPAR");
        botaoLimparA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAcaoLayout = new javax.swing.GroupLayout(painelAcao);
        painelAcao.setLayout(painelAcaoLayout);
        painelAcaoLayout.setHorizontalGroup(
            painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelAcaoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(botaoInserirA)
                .addGap(18, 18, 18)
                .addComponent(botaoEditarA)
                .addGap(18, 18, 18)
                .addComponent(botaoExcluirA)
                .addGap(18, 18, 18)
                .addComponent(botaoLimparA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAcaoLayout.setVerticalGroup(
            painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserirA)
                    .addComponent(botaoEditarA)
                    .addComponent(botaoLimparA)
                    .addComponent(botaoExcluirA))
                .addContainerGap())
        );

        painelAcao1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo4.setText("AÇÕES - VENDA");

        botaoInserirV.setText("INSERIR");
        botaoInserirV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirVActionPerformed(evt);
            }
        });

        botaoEditarV.setText("EDITAR");
        botaoEditarV.setEnabled(false);
        botaoEditarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarVActionPerformed(evt);
            }
        });

        botaoExcluirV.setText("EXCLUIR");
        botaoExcluirV.setEnabled(false);
        botaoExcluirV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirVActionPerformed(evt);
            }
        });

        botaoLimparV.setText("LIMPAR");
        botaoLimparV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAcao1Layout = new javax.swing.GroupLayout(painelAcao1);
        painelAcao1.setLayout(painelAcao1Layout);
        painelAcao1Layout.setHorizontalGroup(
            painelAcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcao1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelAcao1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(botaoInserirV)
                .addGap(18, 18, 18)
                .addComponent(botaoEditarV)
                .addGap(18, 18, 18)
                .addComponent(botaoExcluirV)
                .addGap(18, 18, 18)
                .addComponent(botaoLimparV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAcao1Layout.setVerticalGroup(
            painelAcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcao1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAcao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserirV)
                    .addComponent(botaoEditarV)
                    .addComponent(botaoLimparV)
                    .addComponent(botaoExcluirV))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelFormulario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(painelAcao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelAcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(painelFormulario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelFormulario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelFormulario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelAcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        campoKM.setText("0");
        campoValorTotal.setText("0");
        campoValorTotalA.setText("0");
    }//GEN-LAST:event_formWindowOpened

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new PaginaInicialLogada().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void tipoAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAluguelActionPerformed
        if (tipoAluguel.getSelectedItem() == "Por quilometragem") {
            campoKM.setEnabled(true);
        }
        if (tipoAluguel.getSelectedItem() == "Por dia") {
            campoKM.setEnabled(false);
        }
    }//GEN-LAST:event_tipoAluguelActionPerformed

    private void botaoInserirAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirAActionPerformed
        if (!camposVaziosA()) {
            preencherClasseA();
            aluguelDAO.inserir(aluguel);
            JOptionPane.showMessageDialog(this, "Inserção feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparA();
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoInserirAActionPerformed

    private void botaoEditarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarAActionPerformed
        if (!camposVaziosA()) {
            preencherClasseA();
            aluguelDAO.inserir(aluguel);
            JOptionPane.showMessageDialog(this, "Alteração feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            padraoBotoesA(false);
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_botaoEditarAActionPerformed

    private void botaoExcluirAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirAActionPerformed
        if (!campoIDAluguel.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Essa ação removerá o aluguel realizado.\n\nDeseja continuar?", "Atenção!", JOptionPane.WARNING_MESSAGE);
            if (confirmacao == 0) {
                aluguelDAO.deletar(Integer.parseInt(campoIDAluguel.getText()));
                JOptionPane.showMessageDialog(this, "Operação deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                padraoBotoesA(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID em branco.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirAActionPerformed

    private void botaoLimparAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparAActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja limpar todos os campos?", "Atenção!", JOptionPane.WARNING_MESSAGE);
        if (confirmacao == 0) {
            limparA();
        }
    }//GEN-LAST:event_botaoLimparAActionPerformed

    private void botaoPesquisarAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarAluguelActionPerformed
        if (botaoPesquisarAluguel.isSelected()) {
            padraoBotoesA(true);
            if (!campoIDAluguel.getText().equals("")) {
                int tipo = 0;
                if(tipoVeiculo.getSelectedItem() == "Veículo Comercial"){
                    tipo = 1;
                }
                
                aluguel = aluguelDAO.pesquisar(Integer.parseInt(campoIDAluguel.getText()), tipo);
                preencherCamposA();
                if (!campoChassi.getText().equals("")) {
                    padraoBotoesA(true);
                } else {
                    JOptionPane.showMessageDialog(this, "ID inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    padraoBotoesA(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "ID em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
                padraoBotoesA(false);
            }
        } else {
            padraoBotoesA(false);
        }
    }//GEN-LAST:event_botaoPesquisarAluguelActionPerformed

    private void botaoInserirVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirVActionPerformed
        if (!camposVaziosV()) {
            preencherClasseV();
            vendaDAO.inserir(venda);
            JOptionPane.showMessageDialog(this, "Inserção feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparV();
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoInserirVActionPerformed

    private void botaoEditarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarVActionPerformed
        if (!camposVaziosV()) {
            preencherClasseV();
            vendaDAO.inserir(venda);
            JOptionPane.showMessageDialog(this, "Alteração feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            padraoBotoesV(false);
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_botaoEditarVActionPerformed

    private void botaoExcluirVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirVActionPerformed
        if (!campoIDVenda.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Essa ação removerá a venda realizada.\n\nDeseja continuar?", "Atenção!", JOptionPane.WARNING_MESSAGE);
            if (confirmacao == 0) {
                aluguelDAO.deletar(Integer.parseInt(campoIDAluguel.getText()));
                JOptionPane.showMessageDialog(this, "Operação deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                padraoBotoesV(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID em branco.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirVActionPerformed

    private void botaoLimparVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparVActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja limpar todos os campos?", "Atenção!", JOptionPane.WARNING_MESSAGE);
        if (confirmacao == 0) {
            limparV();
        }
    }//GEN-LAST:event_botaoLimparVActionPerformed

    private void campoDataFimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataFimFocusLost
        if (tipoAluguel.getSelectedItem() == "Por dia") {
            if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
                veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
                try{
                    System.out.println(getQtdDias());
                    campoValorTotalA.setText(String.valueOf(getQtdDias() * veiculoComercial.getValorAluguelDiaria()));
                }
                catch(Exception e){
                    System.out.println("Erro!");
                }
            }
            else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
                veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
                try{
                    System.out.println(getQtdDias());
                    campoValorTotalA.setText(String.valueOf(getQtdDias() * veiculoPasseio.getValorAluguelDiaria()));
                }
                catch(Exception e){
                    System.out.println("Erro!");
                }
            }  
        }
    }//GEN-LAST:event_campoDataFimFocusLost

    private void campoDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataVendaActionPerformed
        if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
            veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
            try{
                campoValorTotal.setText(String.valueOf(veiculoComercial.getValorVenda()));
            }
            catch(Exception e){
                System.out.println("Erro!");
            }
        }
        else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
            veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
            try{
                campoValorTotal.setText(String.valueOf(veiculoPasseio.getValorVenda()));
            }
            catch(Exception e){
                System.out.println("Erro!");
            }
        }
    }//GEN-LAST:event_campoDataVendaActionPerformed

    private void campoKMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoKMFocusLost
        if (tipoAluguel.getSelectedItem() == "Por quilometragem") {
            if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
                veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
                try{
                    System.out.println(getQtdDias());
                    campoValorTotalA.setText(String.valueOf(Integer.parseInt(campoKM.getText()) * veiculoComercial.getValorAluguelKM()));
                }
                catch(Exception e){
                    System.out.println("Erro!");
                }
            }
            else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
                veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
                try{
                    System.out.println(getQtdDias());
                    campoValorTotalA.setText(String.valueOf(Integer.parseInt(campoKM.getText()) * veiculoPasseio.getValorAluguelKM()));
                }
                catch(Exception e){
                    System.out.println("Erro!");
                }
            }  
        }
    }//GEN-LAST:event_campoKMFocusLost

    private void campoDataVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataVendaFocusLost
        if(tipoVeiculo.getSelectedItem().toString().equals("Veículo Comercial")){
            veiculoComercial = veiculoDAO.pesquisar(campoChassi.getText(), 1);
            try{
                campoValorTotal.setText(String.valueOf(veiculoComercial.getValorVenda()));
            }
            catch(Exception e){
                System.out.println("Erro!");
            }
        }
        else if(tipoVeiculo.getSelectedItem().toString().equals("Veículo de Passeio")){
            veiculoPasseio = veiculoDAO.pesquisar(campoChassi.getText(), 0);
            try{
                campoValorTotal.setText(String.valueOf(veiculoPasseio.getValorVenda()));
            }
            catch(Exception e){
                System.out.println("Erro!");
            }
        }
    }//GEN-LAST:event_campoDataVendaFocusLost

    private void botaoPesquisarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarVendaActionPerformed
        if (botaoPesquisarVenda.isSelected()) {
            padraoBotoesV(true);
            if (!campoIDVenda.getText().equals("")) {
                int tipo = 0;
                if(tipoVeiculo.getSelectedItem() == "Veículo Comercial"){
                    tipo = 1;
                }
                
                venda = vendaDAO.pesquisar(Integer.parseInt(campoIDVenda.getText()), tipo);
                preencherCamposV();
                if (!campoChassi.getText().equals("")) {
                    padraoBotoesV(true);
                } else {
                    JOptionPane.showMessageDialog(this, "ID inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    padraoBotoesV(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "ID em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
                padraoBotoesV(false);
            }
        } else {
            padraoBotoesV(false);
        }
    }//GEN-LAST:event_botaoPesquisarVendaActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOperacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditarA;
    private javax.swing.JButton botaoEditarV;
    private javax.swing.JButton botaoExcluirA;
    private javax.swing.JButton botaoExcluirV;
    private javax.swing.JButton botaoInserirA;
    private javax.swing.JButton botaoInserirV;
    private javax.swing.JButton botaoLimparA;
    private javax.swing.JButton botaoLimparV;
    private javax.swing.JToggleButton botaoPesquisarAluguel;
    private javax.swing.JToggleButton botaoPesquisarVenda;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JFormattedTextField campoCPFCliente;
    private javax.swing.JTextField campoChassi;
    private javax.swing.JFormattedTextField campoDataFim;
    private javax.swing.JFormattedTextField campoDataInicio;
    private javax.swing.JFormattedTextField campoDataVenda;
    private javax.swing.JTextField campoIDAluguel;
    private javax.swing.JTextField campoIDFuncionario;
    private javax.swing.JTextField campoIDVenda;
    private javax.swing.JTextField campoKM;
    private javax.swing.JTextField campoValorTotal;
    private javax.swing.JTextField campoValorTotalA;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCPFPesquisa;
    private javax.swing.JLabel labelCPFPesquisa1;
    private javax.swing.JLabel labelLogradouro;
    private javax.swing.JLabel labelLogradouro1;
    private javax.swing.JLabel labelLogradouro2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNome1;
    private javax.swing.JLabel labelNome2;
    private javax.swing.JLabel labelNome3;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelNumero2;
    private javax.swing.JLabel labelNumero3;
    private javax.swing.JLabel labelSubtitulo1;
    private javax.swing.JLabel labelSubtitulo2;
    private javax.swing.JLabel labelSubtitulo3;
    private javax.swing.JLabel labelSubtitulo4;
    private javax.swing.JLabel labelSubtitulo5;
    private javax.swing.JLabel labelSubtitulo6;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelAcao;
    private javax.swing.JPanel painelAcao1;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelFormulario1;
    private javax.swing.JPanel painelFormulario2;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JComboBox<String> tipoAluguel;
    private javax.swing.JComboBox<String> tipoVeiculo;
    // End of variables declaration//GEN-END:variables
}
