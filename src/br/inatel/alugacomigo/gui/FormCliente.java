package br.inatel.alugacomigo.gui;

public class FormCliente extends javax.swing.JFrame {

    public FormCliente() {
        initComponents();
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
        botaoPesquisar = new javax.swing.JButton();
        campoCPFPesquisa = new javax.swing.JFormattedTextField();
        painelFormulario = new javax.swing.JPanel();
        labelSubtitulo2 = new javax.swing.JLabel();
        labelSubtitulo3 = new javax.swing.JLabel();
        labelSubtitulo4 = new javax.swing.JLabel();
        labelSubtitulo5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        campoCPFPesquisa1 = new javax.swing.JFormattedTextField();
        campoCPFPesquisa2 = new javax.swing.JFormattedTextField();
        campoCPFPesquisa3 = new javax.swing.JFormattedTextField();
        labelSubtitulo6 = new javax.swing.JLabel();
        labelSubtitulo7 = new javax.swing.JLabel();
        labelSubtitulo8 = new javax.swing.JLabel();
        labelSubtitulo9 = new javax.swing.JLabel();
        labelSubtitulo10 = new javax.swing.JLabel();
        labelSubtitulo11 = new javax.swing.JLabel();
        labelSubtitulo12 = new javax.swing.JLabel();
        labelSubtitulo13 = new javax.swing.JLabel();
        labelSubtitulo14 = new javax.swing.JLabel();
        labelSubtitulo15 = new javax.swing.JLabel();
        campoCPFPesquisa4 = new javax.swing.JFormattedTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        labelSubtitulo16 = new javax.swing.JLabel();
        botaoPesquisar1 = new javax.swing.JButton();
        botaoPesquisar2 = new javax.swing.JButton();
        botaoPesquisar3 = new javax.swing.JButton();

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

        botaoPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPesquisar.setText("PESQUISAR");

        try {
            campoCPFPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

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
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCPFPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSubtitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelFormulario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo2.setText("Nome:");

        labelSubtitulo3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo3.setText("CPF:");

        labelSubtitulo4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo4.setText("RG:");

        labelSubtitulo5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo5.setText("Data de Nascimento: ");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoCPFPesquisa1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoCPFPesquisa2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU-###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        try {
            campoCPFPesquisa3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        labelSubtitulo6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo6.setText("Logradouro:");

        labelSubtitulo7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo7.setText("Número:");

        labelSubtitulo8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo8.setText("Bairro:");

        labelSubtitulo9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo9.setText("Complemento:");

        labelSubtitulo10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo10.setText("Estado:");

        labelSubtitulo11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo11.setText("Cidade:");

        labelSubtitulo12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo12.setText("Telefone:");

        labelSubtitulo13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo13.setText("Email:");

        labelSubtitulo14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo14.setText("Usuário:");

        labelSubtitulo15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo15.setText("Senha:");

        try {
            campoCPFPesquisa4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPFPesquisa4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará ", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelFormularioLayout = new javax.swing.GroupLayout(painelFormulario);
        painelFormulario.setLayout(painelFormularioLayout);
        painelFormularioLayout.setHorizontalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCPFPesquisa3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFormularioLayout.createSequentialGroup()
                            .addComponent(labelSubtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoCPFPesquisa1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFormularioLayout.createSequentialGroup()
                            .addComponent(labelSubtitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoCPFPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCPFPesquisa4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormularioLayout.createSequentialGroup()
                        .addComponent(labelSubtitulo15, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormularioLayout.setVerticalGroup(
            painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(labelSubtitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPFPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPFPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPFPesquisa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCPFPesquisa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSubtitulo15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        labelSubtitulo16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubtitulo16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitulo16.setText("AÇÕES");

        botaoPesquisar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPesquisar1.setText("INSERIR");

        botaoPesquisar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPesquisar2.setText("EXCLUIR");

        botaoPesquisar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPesquisar3.setText("EDITAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSubtitulo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botaoPesquisar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoPesquisar3)
                        .addGap(92, 92, 92)
                        .addComponent(botaoPesquisar2)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubtitulo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoPesquisar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoPesquisar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoVoltarActionPerformed

    /*
    private boolean camposVazios() {
        boolean verificacao = false;
        if (textoCodigoCliente.getText().equals(" ")
                || textoNome.getText().equals("")
                || textoRg.getText().equals(" - . . ")
                || textoCpf.getText().equals(" . . - ")
                || caixaSexo.getSelectedIndex() == 0
                || textoDataNascimento.getText().equals(" / / ")
                || textoIdade.getText().equals("")
                || textoEndereco.getText().equals("")
                || textoNumero.getText().equals("")
                || textoBairro.getText().equals("")
                || caixaEstado.getSelectedIndex() == 0
                || caixaCidade.getSelectedIndex() == 0) {
            verificacao = true;
        }
        return (verificacao);
    }

    private void preencherClasse() {
        c.setCodigoCliente(textoCodigoCliente.getText());
        c.setNomeCliente(textoNome.getText());
        c.setRgCliente(textoRg.getText());
        c.setCpfCliente(textoCpf.getText());
        c.setSexoCliente(caixaSexo.getSelectedItem().toString());
        c.setDataNascimentoCliente(textoDataNascimento.getText());
        c.setIdadeCliente(textoIdade.getText());
        c.setEnderecoCliente(textoEndereco.getText());
        c.setBairroCliente(textoBairro.getText());
        c.setNumeroCliente(textoNumero.getText());
        c.setEstadoCliente(caixaEstado.getSelectedItem().toString());
        c.setCidadeCliente(caixaCidade.getSelectedItem().toString());
        c.setTelefoneResidencialCliente(textoTelefone.getText());
        c.setTelefoneCelularCliente(textoCelular.getText());
        c.setEmailCliente(textoEmail.getText());
    }

    private void preencherCampos() {
        textoNome.setText(c.getNomeCliente());
        textoRg.setText(c.getRgCliente());
        textoCpf.setText(c.getCpfCliente());
        caixaSexo.setSelectedItem(c.getSexoCliente());
        textoDataNascimento.setText(c.getDataNascimentoCliente());
        textoIdade.setText(c.getIdadeCliente());
        textoEndereco.setText(c.getEnderecoCliente());
        textoBairro.setText(c.getBairroCliente());
        textoNumero.setText(c.getNumeroCliente());
        caixaEstado.setSelectedItem(c.getEstadoCliente());
        caixaCidade.setSelectedItem(c.getCidadeCliente());
        textoTelefone.setText(c.getTelefoneResidencialCliente());
        textoCelular.setText(c.getTelefoneCelularCliente());
        textoEmail.setText(c.getEmailCliente());
    }

    private void limpar() {
        textoCodigoCliente.setValue(null);
        textoNome.setText(null);
        textoRg.setText(null);
        textoCpf.setText(null);
        caixaSexo.setSelectedIndex(0);
        textoDataNascimento.setValue(null);
        textoIdade.setText(null);
        textoEndereco.setText(null);
        textoBairro.setText(null);
        textoNumero.setText(null);
        caixaEstado.setSelectedIndex(0);
        textoTelefone.setValue(null);
        textoCelular.setValue(null);
        textoEmail.setText(null);
    }

    private void padraoBotoes(boolean ativacao) {
        if (ativacao == true) {
            botaoPesquisar.setText("Cancelar");
            botaoInserir.setEnabled(false);
            botaoRemover.setEnabled(true);
            botaoAlterar.setEnabled(true);
        } else {
            botaoPesquisar.setText("Pesquisar");
            botaoPesquisar.setSelected(false);
            botaoInserir.setEnabled(true);
            botaoRemover.setEnabled(false);
            botaoAlterar.setEnabled(false);
            limpar();
        }
    }
    */
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
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoPesquisar1;
    private javax.swing.JButton botaoPesquisar2;
    private javax.swing.JButton botaoPesquisar3;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JFormattedTextField campoCPFPesquisa;
    private javax.swing.JFormattedTextField campoCPFPesquisa1;
    private javax.swing.JFormattedTextField campoCPFPesquisa2;
    private javax.swing.JFormattedTextField campoCPFPesquisa3;
    private javax.swing.JFormattedTextField campoCPFPesquisa4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel labelCPFPesquisa;
    private javax.swing.JLabel labelSubtitulo1;
    private javax.swing.JLabel labelSubtitulo10;
    private javax.swing.JLabel labelSubtitulo11;
    private javax.swing.JLabel labelSubtitulo12;
    private javax.swing.JLabel labelSubtitulo13;
    private javax.swing.JLabel labelSubtitulo14;
    private javax.swing.JLabel labelSubtitulo15;
    private javax.swing.JLabel labelSubtitulo16;
    private javax.swing.JLabel labelSubtitulo2;
    private javax.swing.JLabel labelSubtitulo3;
    private javax.swing.JLabel labelSubtitulo4;
    private javax.swing.JLabel labelSubtitulo5;
    private javax.swing.JLabel labelSubtitulo6;
    private javax.swing.JLabel labelSubtitulo7;
    private javax.swing.JLabel labelSubtitulo8;
    private javax.swing.JLabel labelSubtitulo9;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
