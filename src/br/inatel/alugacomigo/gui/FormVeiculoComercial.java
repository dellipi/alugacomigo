package br.inatel.alugacomigo.gui;

import br.inatel.alugacomigo.dao.*;
import br.inatel.alugacomigo.classes.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FormVeiculoComercial extends javax.swing.JFrame {
    
    Veiculo veiculo = new VeiculoComercial();
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    Loja[] lojas = new Loja[100];
    LojaDAO lojaDAO = new LojaDAO();
    
    public FormVeiculoComercial() {
        initComponents();
    }
    
    private void preencherLojas() {
        lojas = lojaDAO.pesquisarTodas();
        campoSelecaoLoja.removeAllItems();
        campoSelecaoLoja.addItem("Selecione:");
        for(int i = 0; i < lojas.length; i++) {
            if(lojas[i] != null){
                campoSelecaoLoja.addItem(lojas[i].getNome());
            }
        }
    }
    
    private boolean camposVazios() {
        boolean verificacao = false;
        if (campoMarca.getText().equals("")
                || campoChassi.getText().equals("")
                || campoPlaca.getText().equals("   -    ")
                || campoModelo.getText().equals("")
                || campoPotencia.getText().equals("")
                || campoTorque.getText().equals("")
                || campoConsumoMedio.getText().equals("")
                || campoSelecaoConsumo.getSelectedIndex() == 0
                || campoSelecaoLoja.getSelectedIndex() == 0
                || campoDiaria.getText().equals("")
                || campoPlaca.getText().equals("( )     -    ")
                || campoKM.getText().equals("")
                || campoVenda.getText().equals("")
                || campoCargaKG.getText().equals("")
                || campoCargaL.getText().equals("")) {
            verificacao = true;
        }
        return (verificacao);
    }

    private void preencherClasse(){
        veiculo.setChassi(campoChassi.getText());
        veiculo.setMarca(campoMarca.getText());
        veiculo.setModelo(campoModelo.getText());
        veiculo.setPlaca(campoPlaca.getText());
        veiculo.setPotenciaMotor(Integer.parseInt(campoPotencia.getText()));
        veiculo.setTorqueMotor(Integer.parseInt(campoTorque.getText()));
        veiculo.setClassificacaoConsumo(campoSelecaoConsumo.getSelectedItem().toString());
        veiculo.setConsumoMedio(Float.parseFloat(campoConsumoMedio.getText()));
        veiculo.setValorAluguelDiaria(Float.parseFloat(campoDiaria.getText()));
        veiculo.setValorAluguelKM(Float.parseFloat(campoKM.getText()));
        veiculo.setValorVenda(Float.parseFloat(campoVenda.getText()));
        veiculo.setLoja(lojaDAO.pesquisar(lojaDAO.pesquisarId(campoSelecaoLoja.getSelectedItem().toString())));
        ((VeiculoComercial) veiculo).setCapacidadeCargaPeso(Integer.parseInt(campoCargaKG.getText()));
        ((VeiculoComercial) veiculo).setCapacidadeCargaVolume(Integer.parseInt(campoCargaL.getText()));
        veiculo.setQuilometragem(0);
    }

    private void preencherCampos() {
        campoChassi.setText(veiculo.getChassi());
        campoMarca.setText(veiculo.getMarca());
        campoModelo.setText(veiculo.getModelo());
        campoPlaca.setText(veiculo.getPlaca());
        campoPotencia.setText(veiculo.getChassi());
        campoTorque.setText(veiculo.getChassi());
        campoSelecaoConsumo.setSelectedItem(veiculo.getClassificacaoConsumo());
        campoConsumoMedio.setText(String.valueOf(veiculo.getConsumoMedio()));
        campoDiaria.setText(String.valueOf(veiculo.getValorAluguelDiaria()));
        campoKM.setText(String.valueOf(veiculo.getValorAluguelKM()));
        campoVenda.setText(String.valueOf(veiculo.getValorVenda()));
        campoCargaL.setText(String.valueOf(((VeiculoComercial) veiculo).getCapacidadeCargaVolume()));
        campoCargaKG.setText(String.valueOf(((VeiculoComercial) veiculo).getCapacidadeCargaPeso()));
        campoSelecaoLoja.setSelectedItem(veiculo.getLoja().getNome());
    }

    private void limpar() {
        campoChassiBusca.setText(null);
        campoChassi.setText(null);
        campoMarca.setText(null);
        campoModelo.setText(null);
        campoPlaca.setText(null);
        campoPotencia.setText(null);
        campoTorque.setText(null);
        campoSelecaoConsumo.setSelectedIndex(0);
        campoConsumoMedio.setText(null);
        campoDiaria.setText(null);
        campoKM.setText(null);
        campoVenda.setText(null);
        campoCargaL.setText(null);
        campoCargaKG.setText(null);
        campoSelecaoLoja.setSelectedIndex(0);
    }

    private void padraoBotoes(boolean ativacao) {
        if (ativacao == true) {
            botaoPesquisar.setText("CANCELAR");
            botaoInserir.setEnabled(false);
            botaoExcluir.setEnabled(true);
            botaoEditar.setEnabled(true);
            botaoLimpar.setEnabled(false);
            campoChassi.setEnabled(false);
        } else {
            botaoPesquisar.setText("PESQUISAR");
            botaoPesquisar.setSelected(false);
            botaoInserir.setEnabled(true);
            botaoExcluir.setEnabled(false);
            botaoEditar.setEnabled(false);
            botaoLimpar.setEnabled(true);
            campoChassi.setEnabled(true);
            limpar();
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
        botaoPesquisar = new javax.swing.JToggleButton();
        campoChassiBusca = new javax.swing.JTextField();
        painelFormulario = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoMarca = new javax.swing.JTextField();
        labelLogradouro = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        labelComplemento = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        labelCidade = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JFormattedTextField();
        campoPotencia = new javax.swing.JTextField();
        campoModelo = new javax.swing.JTextField();
        campoTorque = new javax.swing.JTextField();
        campoConsumoMedio = new javax.swing.JTextField();
        campoDiaria = new javax.swing.JTextField();
        campoSelecaoConsumo = new javax.swing.JComboBox<>();
        campoKM = new javax.swing.JTextField();
        campoVenda = new javax.swing.JTextField();
        labelEstado1 = new javax.swing.JLabel();
        campoSelecaoLoja = new javax.swing.JComboBox<>();
        labelEmail1 = new javax.swing.JLabel();
        campoCargaL = new javax.swing.JTextField();
        campoCargaKG = new javax.swing.JTextField();
        labelUsuario1 = new javax.swing.JLabel();
        labelNome1 = new javax.swing.JLabel();
        campoChassi = new javax.swing.JTextField();
        painelAcao = new javax.swing.JPanel();
        labelSubtitulo2 = new javax.swing.JLabel();
        botaoInserir = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();

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
        labelTitulo.setText("VEÍCULO COMERCIAL");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        labelSubtitulo1.setText("Pesquisar Veículo");

        labelCPFPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCPFPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPFPesquisa.setText("Chassi: ");

        botaoPesquisar.setText("PESQUISAR");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        campoChassiBusca.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCPFPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoChassiBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoPesquisar)
                .addContainerGap())
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPFPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSubtitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoPesquisar)
                    .addComponent(campoChassiBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelFormulario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Marca:");

        campoMarca.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelLogradouro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogradouro.setText("Modelo:");

        labelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero.setText("Potência:");

        labelBairro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBairro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBairro.setText("Torque:");

        labelComplemento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelComplemento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplemento.setText("Consumo Médio:");

        labelEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText("Classificação Consumo:");

        labelCidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCidade.setText("Valor por Diária:");

        labelTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTelefone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTelefone.setText("Placa:");

        labelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail.setText("Valor por KM:");

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario.setText("Valor da Venda: ");

        try {
            campoPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoPlaca.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoPotencia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoModelo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoTorque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoConsumoMedio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoDiaria.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoSelecaoConsumo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoSelecaoConsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "A", "B", "C", "D", "E" }));

        campoKM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoVenda.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelEstado1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEstado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado1.setText("Loja:");

        campoSelecaoLoja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoSelecaoLoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:" }));

        labelEmail1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail1.setText("Capacidade de Carga (L):");

        campoCargaL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoCargaKG.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario1.setText("Capacidade de Carga (kg):");

        labelNome1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome1.setText("Chassi:");

        campoChassi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelFormularioLayout = new javax.swing.GroupLayout(painelFormulario);
        painelFormulario.setLayout(painelFormularioLayout);
        painelFormularioLayout.setHorizontalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSelecaoConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoModelo)
                            .addGroup(painelFormularioLayout.createSequentialGroup()
                                .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoMarca)
                            .addComponent(campoChassi)))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTorque)
                            .addComponent(campoPotencia)))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEstado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEmail1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUsuario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelFormularioLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoKM)
                                        .addComponent(campoDiaria)
                                        .addComponent(campoVenda)
                                        .addComponent(campoCargaL, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(campoCargaKG)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormularioLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(campoSelecaoLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormularioLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(campoConsumoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormularioLayout.setVerticalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoChassi)
                    .addComponent(labelNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoMarca)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoPotencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoTorque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoSelecaoConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoConsumoMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoDiaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoKM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCargaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCargaKG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoSelecaoLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelAcao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo2.setText("AÇÕES");

        botaoInserir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoInserir.setText("INSERIR");
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });

        botaoExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoExcluir.setText("EXCLUIR");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoEditar.setText("EDITAR");
        botaoEditar.setEnabled(false);
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoLimpar.setText("LIMPAR");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAcaoLayout = new javax.swing.GroupLayout(painelAcao);
        painelAcao.setLayout(painelAcaoLayout);
        painelAcaoLayout.setHorizontalGroup(
            painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAcaoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botaoInserir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoLimpar))
                    .addComponent(labelSubtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        painelAcaoLayout.setVerticalGroup(
            painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(painelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        preencherLojas();
    }//GEN-LAST:event_formWindowOpened

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new PaginaInicialLogada().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed
        if (!camposVazios()) {
            preencherClasse();
            veiculoDAO.inserir(veiculo);
            JOptionPane.showMessageDialog(this, "Inserção feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoInserirActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        if (!camposVazios()) {
            preencherClasse();
            veiculoDAO.atualizar(veiculo);
            JOptionPane.showMessageDialog(this, "Alteração feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            padraoBotoes(false);
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        if (!campoChassiBusca.getText().equals("   -    ")) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Essa ação removerá o cadastro do cliente.\n\nDeseja continuar?", "Atenção!", JOptionPane.WARNING_MESSAGE);
            if (confirmacao == 0) {
                veiculoDAO.deletar(campoChassiBusca.getText());
                JOptionPane.showMessageDialog(this, "Veículo deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                padraoBotoes(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chassi do Veículo em branco.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja limpar todos os campos?", "Atenção!", JOptionPane.WARNING_MESSAGE);
        if (confirmacao == 0) {
            limpar();
        }
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        if (botaoPesquisar.isSelected()) {
            padraoBotoes(true);
            if (!campoChassiBusca.getText().equals("   -    ")) {
                veiculo = veiculoDAO.pesquisar(campoChassiBusca.getText(), 0);
                preencherCampos();
                if (!campoMarca.getText().equals("")) {
                    padraoBotoes(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Chassi do Veículo inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    padraoBotoes(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chassi do Veículo em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
                padraoBotoes(false);
            }
        } else {
            padraoBotoes(false);
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(FormVeiculoComercial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVeiculoComercial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVeiculoComercial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVeiculoComercial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVeiculoComercial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JToggleButton botaoPesquisar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoCargaKG;
    private javax.swing.JTextField campoCargaL;
    private javax.swing.JTextField campoChassi;
    private javax.swing.JTextField campoChassiBusca;
    private javax.swing.JTextField campoConsumoMedio;
    private javax.swing.JTextField campoDiaria;
    private javax.swing.JTextField campoKM;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JFormattedTextField campoPlaca;
    private javax.swing.JTextField campoPotencia;
    private javax.swing.JComboBox<String> campoSelecaoConsumo;
    private javax.swing.JComboBox<String> campoSelecaoLoja;
    private javax.swing.JTextField campoTorque;
    private javax.swing.JTextField campoVenda;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCPFPesquisa;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEstado1;
    private javax.swing.JLabel labelLogradouro;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNome1;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelSubtitulo1;
    private javax.swing.JLabel labelSubtitulo2;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuario1;
    private javax.swing.JPanel painelAcao;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
