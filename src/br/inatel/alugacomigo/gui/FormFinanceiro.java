package br.inatel.alugacomigo.gui;

import br.inatel.alugacomigo.dao.*;
import br.inatel.alugacomigo.classes.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FormFinanceiro extends javax.swing.JFrame {
    
    Pessoa cliente = new Cliente();
    PessoaDAO clienteDAO = new PessoaDAO();
    
    public FormFinanceiro() {
        initComponents();
    }
    
    private boolean camposVazios() {
        boolean verificacao = false;
        if (campoNome.getText().equals("")
                || campoRG.getText().equals("  -   .   .   ")
                || campoCPF.getText().equals("   .   .   -  ")
                || campoDataNascimento.getText().equals(" / / ")
                || campoLogradouro.getText().equals("")
                || campoNumero.getText().equals("")
                || campoBairro.getText().equals("")
                // || campoComplemento.getText().equals("") o complemento pode ser vazio
                || campoSelecaoEstado.getSelectedIndex() == 0
                || campoCidade.getText().equals("")
                || campoTelefone.getText().equals("( )     -    ")
                || campoEmail.getText().equals("")
                || campoUsuario.getText().equals("")
                || campoSenha.getText().equals("")) {
            verificacao = true;
        }
        return (verificacao);
    }

    private void preencherClasse(){
        cliente.setNome(campoNome.getText());
        cliente.setRg(campoRG.getText());
        cliente.setCpf(campoCPF.getText());
        cliente.setDataNascimento(campoDataNascimento.getText());
        cliente.setEnderecoLogradouro(campoLogradouro.getText());
        cliente.setEnderecoBairro(campoBairro.getText());
        cliente.setEnderecoNumero(Integer.parseInt(campoNumero.getText()));
        cliente.setEnderecoComplemento(campoComplemento.getText());
        cliente.setEnderecoEstado(campoSelecaoEstado.getSelectedItem().toString());
        cliente.setEnderecoCidade(campoCidade.getText());
        cliente.setTelefoneCelular(campoTelefone.getText());
        cliente.setEmail(campoEmail.getText());
        cliente.setUsuario(campoTelefone.getText());
        cliente.setSenha(campoSenha.getText());
    }

    private void preencherCampos() {
        campoNome.setText(cliente.getNome());
        campoRG.setText(cliente.getRg());
        campoCPF.setText(cliente.getCpf());
        campoDataNascimento.setText(cliente.getDataNascimento());
        campoLogradouro.setText(cliente.getEnderecoLogradouro());
        campoBairro.setText(cliente.getEnderecoBairro());
        campoNumero.setText(String.valueOf(cliente.getEnderecoNumero()));
        campoComplemento.setText(cliente.getEnderecoComplemento());
        campoSelecaoEstado.setSelectedItem(cliente.getEnderecoEstado());
        campoCidade.setText(cliente.getEnderecoCidade());
        campoTelefone.setText(cliente.getTelefoneCelular());
        campoEmail.setText(cliente.getEmail());
        campoUsuario.setText(cliente.getUsuario());
        campoSenha.setText(cliente.getSenha());
    }

    private void limpar() {
        campoCPFPesquisa.setValue(null);
        campoNome.setText(null);
        campoRG.setValue(null);
        campoCPF.setValue(null);
        campoDataNascimento.setValue(null);
        campoLogradouro.setText(null);
        campoBairro.setText(null);
        campoNumero.setText(null);
        campoComplemento.setText(null);
        campoSelecaoEstado.setSelectedIndex(0);
        campoCidade.setText(null);
        campoTelefone.setText(null);
        campoEmail.setText(null);
        campoUsuario.setText(null);
        campoSenha.setText(null);
    }

    private void padraoBotoes(boolean ativacao) {
        if (ativacao == true) {
            botaoPesquisar.setText("CANCELAR");
            botaoInserir.setEnabled(false);
            botaoExcluir.setEnabled(true);
            botaoEditar.setEnabled(true);
            botaoLimpar.setEnabled(false);
            campoCPF.setEnabled(false);
        } else {
            botaoPesquisar.setText("PESQUISAR");
            botaoPesquisar.setSelected(false);
            botaoInserir.setEnabled(true);
            botaoExcluir.setEnabled(false);
            botaoEditar.setEnabled(false);
            botaoLimpar.setEnabled(true);
            campoCPF.setEnabled(true);
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
        campoCPFPesquisa = new javax.swing.JFormattedTextField();
        botaoPesquisar = new javax.swing.JToggleButton();
        painelFormulario = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        labelRG = new javax.swing.JLabel();
        labelDataNascimento = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        campoRG = new javax.swing.JFormattedTextField();
        campoDataNascimento = new javax.swing.JFormattedTextField();
        labelLogradouro = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        labelComplemento = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        labelCidade = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JFormattedTextField();
        campoNumero = new javax.swing.JTextField();
        campoLogradouro = new javax.swing.JTextField();
        campoBairro = new javax.swing.JTextField();
        campoComplemento = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        campoSelecaoEstado = new javax.swing.JComboBox<>();
        campoEmail = new javax.swing.JTextField();
        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
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
        labelTitulo.setText("CLIENTE");

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
        labelSubtitulo1.setText("Pesquisar Cliente");

        labelCPFPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCPFPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPFPesquisa.setText("CPF: ");

        try {
            campoCPFPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        botaoPesquisar.setText("PESQUISAR");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCPFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCPFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
                    .addComponent(campoCPFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addContainerGap())
        );

        painelFormulario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Nome:");

        labelCPF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPF.setText("CPF:");

        labelRG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelRG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRG.setText("RG:");

        labelDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataNascimento.setText("Data de Nascimento: ");

        campoNome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU-###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoRG.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelLogradouro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogradouro.setText("Logradouro:");

        labelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero.setText("Número:");

        labelBairro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBairro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBairro.setText("Bairro:");

        labelComplemento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelComplemento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplemento.setText("Complemento:");

        labelEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText("Estado:");

        labelCidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCidade.setText("Cidade:");

        labelTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTelefone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTelefone.setText("Telefone:");

        labelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail.setText("Email:");

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario.setText("Usuário:");

        labelSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSenha.setText("Senha:");

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoNumero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoBairro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoComplemento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoSelecaoEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoSelecaoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará ", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        campoEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelFormularioLayout = new javax.swing.GroupLayout(painelFormulario);
        painelFormulario.setLayout(painelFormularioLayout);
        painelFormularioLayout.setHorizontalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFormularioLayout.createSequentialGroup()
                            .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoCPF))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFormularioLayout.createSequentialGroup()
                            .addComponent(labelRG, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSelecaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormularioLayout.setVerticalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoNome)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoSelecaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
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
                .addComponent(labelSubtitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAcaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoInserir)
                .addGap(18, 18, 18)
                .addComponent(botaoEditar)
                .addGap(18, 18, 18)
                .addComponent(botaoExcluir)
                .addGap(18, 18, 18)
                .addComponent(botaoLimpar)
                .addGap(41, 41, 41))
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
                    .addComponent(painelFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(painelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new PaginaInicialLogada().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed
        if (!camposVazios()) {
            preencherClasse();
            clienteDAO.inserir(cliente);
            JOptionPane.showMessageDialog(this, "Inserção feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoInserirActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        if (!camposVazios()) {
            preencherClasse();
            clienteDAO.atualizar(cliente);
            JOptionPane.showMessageDialog(this, "Alteração feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            padraoBotoes(false);
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        if (!campoCPFPesquisa.getText().equals("   .   .   -  ")) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Essa ação removerá o cadastro do cliente.\n\nDeseja continuar?", "Atenção!", JOptionPane.WARNING_MESSAGE);
            if (confirmacao == 0) {
                clienteDAO.deletar(campoCPFPesquisa.getText());
                JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                padraoBotoes(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "CPF do Cliente em branco.", "Erro!", JOptionPane.ERROR_MESSAGE);
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
            if (!campoCPFPesquisa.getText().equals("   .   .   -  ")) {
                cliente = clienteDAO.pesquisar(campoCPFPesquisa.getText(), 0);
                preencherCampos();
                if (!campoNome.getText().equals("")) {
                    padraoBotoes(true);
                } else {
                    JOptionPane.showMessageDialog(this, "CPF do Cliente inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    padraoBotoes(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "CPF do Cliente em branco!", "Erro!", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(FormFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFinanceiro().setVisible(true);
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
    private javax.swing.JTextField campoBairro;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JFormattedTextField campoCPFPesquisa;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoLogradouro;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JFormattedTextField campoRG;
    private javax.swing.JComboBox<String> campoSelecaoEstado;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCPFPesquisa;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelLogradouro;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSubtitulo1;
    private javax.swing.JLabel labelSubtitulo2;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel painelAcao;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
