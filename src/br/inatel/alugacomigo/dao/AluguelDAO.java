package br.inatel.alugacomigo.dao;

import br.inatel.alugacomigo.classes.Aluguel;
import br.inatel.alugacomigo.classes.Cliente;
import br.inatel.alugacomigo.classes.Funcionario;
import br.inatel.alugacomigo.classes.Veiculo;
import br.inatel.alugacomigo.classes.Venda;
import br.inatel.alugacomigo.conexaobd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AluguelDAO {

    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private ResultSet rsAux; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public boolean inserir(Aluguel aluguel) {
        
        String sql;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "insert into aluguel(veiculo_chassi, cliente_cpf, funcionario_id, data_inicio, data_fim, valor_total, km) "
                        + "values (?,?,?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, aluguel.getVeiculo().getChassi());
                pst.setString(2, aluguel.getCliente().getCpf());
                pst.setInt(3, aluguel.getFuncionario().getIdFuncionario());
                pst.setString(4, aluguel.getDataInicio());
                pst.setString(5, aluguel.getDataFim());
                pst.setFloat(6, aluguel.getValorTotal());
                pst.setFloat(7, aluguel.getKm());
                pst.execute();
                
                
                success = true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
                success = false;
            }
        }
        
        return success;
    }
    
    public Aluguel pesquisar(int idAluguel, int tipoCarro) {

        int auxID;
        String sql;
        String sqlAux = "";
        String cpfAux = "";
        Aluguel aluguel = new Aluguel();
        
        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        Veiculo veiculo;
        
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        con = new ConexaoBD().getConexao();

        try {

            sql = "select * from venda where id_aluguel = ?;";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAluguel);
            rs = pst.executeQuery();

            while (rs.next()) {
                aluguel.setIdAluguel(rs.getInt("id_venda"));
                aluguel.setVeiculo(veiculoDAO.pesquisar(rs.getString("veiculo_chassi"), tipoCarro));
                aluguel.setCliente((Cliente) pessoaDAO.pesquisar(rs.getString("cliente_cpf"), 0));
                
                sqlAux = "select pessoa_cpf from cliente where id_funcionario = ?;";
                pst = con.prepareStatement(sql);
                pst.setInt(1, rs.getInt("funcionario_id"));
                rsAux = pst.executeQuery();
                
                while(rsAux.next()){
                    cpfAux = rsAux.getString("pessoa_cpf");
                }
                
                aluguel.setFuncionario((Funcionario) pessoaDAO.pesquisar(cpfAux, 1));
                aluguel.setDataInicio(rs.getString("data_inicio"));
                aluguel.setDataInicio(rs.getString("data_fim"));
                aluguel.setKm(rs.getInt("km"));
                aluguel.setValorTotal(rs.getFloat("valor_total"));
            }
            
            pst.close();
            return aluguel;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public boolean atualizar(Aluguel aluguel) {
        
        int idAux = 0;
        String sqlAux;
        
        String sql = "update aluguel set veiculo_chassi = ?, cliente_cpf = ?, funcionario_id = ?, data_inicio = ?, data_fim = ?,"
                + " valor_total = ?, km = ? where id_aluguel = ?;";
        
        con = new ConexaoBD().getConexao();
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, aluguel.getVeiculo().getChassi());
            pst.setString(2, aluguel.getCliente().getCpf());
            pst.setInt(3, aluguel.getFuncionario().getIdFuncionario());
            pst.setString(4, aluguel.getDataInicio());
            pst.setString(5, aluguel.getDataFim());
            pst.setFloat(6, aluguel.getValorTotal());
            pst.setFloat(7, aluguel.getKm());
            pst.setFloat(8, aluguel.getIdAluguel());
            pst.execute();
            
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
    public boolean deletar(int id) {
        
        String sql = "delete from aluguel where id_aluguel = ?;";
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
