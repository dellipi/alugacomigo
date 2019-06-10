package br.inatel.alugacomigo.login;

import br.inatel.alugacomigo.classes.Cliente;
import br.inatel.alugacomigo.classes.Funcionario;
import br.inatel.alugacomigo.classes.Loja;
import br.inatel.alugacomigo.classes.Pessoa;
import br.inatel.alugacomigo.conexaobd.ConexaoBD;
import br.inatel.alugacomigo.dao.LojaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login {
    
    /**
     * 0 - Deslogado
     * 1 - Logado como Cliente
     * 2 - Logado como Funcionário
     */
    
    public static int logged;
    
    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public void logarNoSistema(String user, String password) {

        String sql;
        String senha;
        String cpf = "";
        boolean ok = false;
        logged = 0;
        con = new ConexaoBD().getConexao();
        
        try {

            sql = "select * from pessoa where usuario = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, user);
            rs = pst.executeQuery();

            while (rs.next()) {
                cpf = rs.getString("cpf");
                senha = rs.getString("senha");
                ok = true;
            }
            
            if(ok){
                    
                sql = "select * from cliente where pessoa_cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                while (rs.next()) {
                    logged = 1;
                }

                sql = "select * from funcionario where pessoa_cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                while (rs.next()) {
                    logged = 2;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }
    
}
