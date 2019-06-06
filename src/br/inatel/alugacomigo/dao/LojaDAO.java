package br.inatel.alugacomigo.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import br.inatel.alugacomigo.classes.*;
import br.inatel.alugacomigo.conexaobd.ConexaoBD;

public class LojaDAO {
    
    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public boolean inserir(Loja novaLoja) {
        
        String sql;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "insert into loja(nome, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, "
                        + "endereco_estado, endereco_cidade, telefone_contato, email_contato, num_funcionario) "
                        + "values (?,?,?,?,?,?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, novaLoja.getNome());
                pst.setString(2, novaLoja.getEnderecoLogradouro());
                pst.setInt(3, novaLoja.getEnderecoNumero());
                pst.setString(4, novaLoja.getEnderecoBairro());
                pst.setString(5, novaLoja.getEnderecoComplemento());
                pst.setString(6, novaLoja.getEnderecoEstado());
                pst.setString(7, novaLoja.getEnderecoCidade());
                pst.setString(8, novaLoja.getTelefoneContato());
                pst.setString(9, novaLoja.getEmailContato());
                pst.setInt(10, novaLoja.getNumFuncionarios());
                pst.execute();
                
                success = true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
                success = false;
            }
        }
        
        return success;
    }
    
    public Loja pesquisar(int idLoja) {

        int auxID;
        String sql;
        String sqlAux;
        String cpfAux;
        Loja loja = new Loja();
        
        Gerente gerente = new Gerente();
        Funcionario funcionario = new Funcionario();
        PessoaDAO pessoaDAO = new PessoaDAO();
        Gerente[] gerentes = new Gerente[100];
        Funcionario[] funcionarios = new Funcionario[100];

        try {

            sql = "select * from loja where id_loja = ?;";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLoja);
            rs = pst.executeQuery(sql);

            while (rs.next()) {
                loja.setIdLoja(rs.getInt("id_loja"));
                loja.setNome(rs.getString("nome"));
                loja.setEnderecoLogradouro(rs.getString("endereco_logradouro"));
                loja.setEnderecoNumero(rs.getInt("endereco_numero"));
                loja.setEnderecoBairro(rs.getString("endereco_bairro"));
                loja.setEnderecoComplemento(rs.getString("endereco_complemento"));
                loja.setEnderecoEstado(rs.getString("endereco_estado"));
                loja.setEnderecoCidade(rs.getString("endereco_cidade"));
                loja.setTelefoneContato(rs.getString("telefone_contato"));
                loja.setEmailContato(rs.getString("email_contato"));
                loja.setNumFuncionarios(rs.getInt("num_funcionario"));
            }
                    
            sql = "select * from loja_has_gerente where loja_id_loja = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLoja);
            rs = pst.executeQuery(sql);
            
            while(rs.next()){
                auxID = rs.getInt("gerente_id_gerente");
                
                sql = "select * from gerente where id_gerente = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, auxID);
                rs = pst.executeQuery(sql);
                
                while(rs.next()){
                    cpfAux = rs.getString("pessoa_cpf");
                    gerente = (Gerente) pessoaDAO.pesquisar(cpfAux, 2);
                }
                
                for(int i = 0; i < gerentes.length; i++) {
                    if(gerentes[i] == null){
                        gerentes[i] = gerente;
                        break;
                    }                    
                }
            }
            
            sql = "select * from funcionario where loja_id_loja = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLoja);
            rs = pst.executeQuery(sql);
            
            while(rs.next()){
                auxID = rs.getInt("id_funcionario");
                cpfAux = rs.getString("pessoa_cpf");
                
                funcionario = (Funcionario) pessoaDAO.pesquisar(cpfAux, 1);
                
                for(int i = 0; i < funcionarios.length; i++) {
                    if(funcionarios[i] == null){
                        funcionarios[i] = funcionario;
                        break;
                    }                    
                }
            }
            
            loja.setGerentes(gerentes);
            loja.setFuncionarios(funcionarios);
            
            pst.close();
            return loja;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public boolean atualizar(Loja loja) {
        
        int idAux = 0;
        String sqlAux;
        
        String sql = "update loja set nome = ?, endereco_logradouro = ?, endereco_numero = ?, endereco_bairro = ?, "
                    + "endereco_complemento = ?, endereco_estado = ?, endereco_cidade = ?, telefone_contato = ?, "
                    + "email_contato = ?, num_funcionario = ? where id_loja = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, loja.getNome());
            pst.setString(2, loja.getEnderecoLogradouro());
            pst.setInt(3, loja.getEnderecoNumero());
            pst.setString(4, loja.getEnderecoBairro());
            pst.setString(5, loja.getEnderecoComplemento());
            pst.setString(6, loja.getEnderecoEstado());
            pst.setString(7, loja.getEnderecoCidade());
            pst.setString(8, loja.getTelefoneContato());
            pst.setString(9, loja.getEmailContato());
            pst.setInt(10, loja.getNumFuncionarios());
            pst.execute();
            
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
    public boolean deletar(int id) {
        
        String sql = "delete from loja where id_loja = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
}
