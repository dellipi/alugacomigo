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

public class VendaDAO {

    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private ResultSet rsAux; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public boolean inserir(Venda venda) {
        
        String sql;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "insert into venda(veiculo_chassi, cliente_cpf, funcionario_id, data_venda, valor_total) "
                        + "values (?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, venda.getVeiculo().getChassi());
                pst.setString(2, venda.getCliente().getCpf());
                pst.setInt(3, venda.getFuncionario().getIdFuncionario());
                pst.setString(4, venda.getDataVenda());
                pst.setFloat(5, venda.getValorTotal());
                pst.execute();
                
                success = true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
                success = false;
            }
        }
        
        return success;
    }
    
    public Venda pesquisar(int idVenda, int tipoCarro) {

        int auxID;
        String sql;
        String sqlAux = "";
        String cpfAux = "";
        Venda venda = new Venda();
        
        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        Veiculo veiculo;
        
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        con = new ConexaoBD().getConexao();

        try {

            sql = "select * from venda where id_venda = ?;";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idVenda);
            rs = pst.executeQuery();

            while (rs.next()) {
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setVeiculo(veiculoDAO.pesquisar(rs.getString("veiculo_chassi"), tipoCarro));
                venda.setCliente((Cliente) pessoaDAO.pesquisar(rs.getString("cliente_cpf"), 0));
                
                sqlAux = "select pessoa_cpf from cliente where id_funcionario = ?;";
                pst = con.prepareStatement(sql);
                pst.setInt(1, rs.getInt("funcionario_id"));
                rsAux = pst.executeQuery();
                
                while(rsAux.next()){
                    cpfAux = rsAux.getString("pessoa_cpf");
                }
                
                venda.setFuncionario((Funcionario) pessoaDAO.pesquisar(cpfAux, 1));
                venda.setDataVenda(rs.getString("data_venda"));
                venda.setValorTotal(rs.getFloat("valor_total"));
            }
            
            pst.close();
            return venda;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public boolean atualizar(Venda venda) {
        
        int idAux = 0;
        String sqlAux;
        
        String sql = "update venda set veiculo_chassi = ?, cliente_cpf = ?, funcionario_id = ?, data_venda = ?, "
                + "valor_total = ? where id_venda = ?;";
        
        con = new ConexaoBD().getConexao();
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, venda.getVeiculo().getChassi());
            pst.setString(2, venda.getCliente().getCpf());
            pst.setInt(3, venda.getFuncionario().getIdFuncionario());
            pst.setString(4, venda.getDataVenda());
            pst.setFloat(5, venda.getValorTotal());
            pst.execute();
            
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
    public boolean deletar(int id) {
        
        String sql = "delete from venda where id_venda = ?;";
        con = new ConexaoBD().getConexao();
        
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
