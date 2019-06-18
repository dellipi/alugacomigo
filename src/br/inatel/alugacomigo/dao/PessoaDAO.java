package br.inatel.alugacomigo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import br.inatel.alugacomigo.classes.*;
import br.inatel.alugacomigo.conexaobd.ConexaoBD;
import javax.swing.JOptionPane;

public class PessoaDAO {
    
    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public boolean inserir(Pessoa novaPessoa) {
        
        int idAux = 0;
        String sql;
        String sqlAux;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "insert into pessoa(cpf, rg, nome, data_nascimento, endereco_logradouro, endereco_numero, "
                        + "endereco_bairro, endereco_complemento, endereco_estado, endereco_cidade, telefone_celular, "
                        + "email, usuario, senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, novaPessoa.getCpf());
                pst.setString(2, novaPessoa.getRg());
                pst.setString(3, novaPessoa.getNome());
                pst.setString(4, novaPessoa.getDataNascimento());
                pst.setString(5, novaPessoa.getEnderecoLogradouro());
                pst.setInt(6, novaPessoa.getEnderecoNumero());
                pst.setString(7, novaPessoa.getEnderecoBairro());
                pst.setString(8, novaPessoa.getEnderecoComplemento());
                pst.setString(9, novaPessoa.getEnderecoEstado());
                pst.setString(10, novaPessoa.getEnderecoCidade());
                pst.setString(11, novaPessoa.getTelefoneCelular());
                pst.setString(12, novaPessoa.getEmail());
                pst.setString(13, novaPessoa.getUsuario());
                pst.setString(14, novaPessoa.getSenha());
                pst.execute();
                
                if(novaPessoa instanceof Cliente){
                    
                    sql = "insert into cliente(pessoa_cpf) values (?);";
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novaPessoa.getCpf());
                    pst.execute();
                    
                }else if(novaPessoa instanceof Funcionario){
                    
                    sql = "insert into funcionario(pessoa_cpf, loja_id_loja, salario_base, tipo_funcionario) values (?,?,?,?);";
                    
                    Funcionario auxF = (Funcionario) novaPessoa;
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novaPessoa.getCpf());
                    pst.setInt(2, auxF.getLoja().getIdLoja());
                    pst.setFloat(3, auxF.getSalarioBase());
                    pst.setString(4, auxF.getTipoFuncionario());
                    pst.execute();
                
                }
                
                success = true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
                success = false;
            }
        }
        
        return success;
    }
    
    public Pessoa pesquisar(String cpf, int tipoPessoa) {

        Pessoa p;
        int idAux;
        String sql;
        String sqlAux;
        
        Loja loja;
        Loja[] lojas = new Loja[100];
        LojaDAO lojaDAO = new LojaDAO();
        
        con = new ConexaoBD().getConexao();
        
        switch (tipoPessoa) {
            case 0:
                p = new Cliente();
                break;
            default:
                p = new Funcionario();
                break;
        }

        try {

            sql = "select * from pessoa where cpf = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            while (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setEnderecoLogradouro(rs.getString("endereco_logradouro"));
                p.setEnderecoNumero(rs.getInt("endereco_numero"));
                p.setEnderecoBairro(rs.getString("endereco_bairro"));
                p.setEnderecoComplemento(rs.getString("endereco_complemento"));
                p.setEnderecoEstado(rs.getString("endereco_estado"));
                p.setEnderecoCidade(rs.getString("endereco_cidade"));
                p.setTelefoneCelular(rs.getString("telefone_celular"));
                p.setEmail(rs.getString("email"));
                p.setUsuario(rs.getString("usuario"));
                p.setSenha(rs.getString("senha"));
            }
            
            if(p instanceof Cliente){
                    
                sql = "select * from cliente where pessoa_cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                while (rs.next()) {
                    ((Cliente) p).setPossuiPendencias(rs.getBoolean("possui_pendencias"));
                    ((Cliente) p).setValorPendencias(rs.getFloat("possui_pendencias"));
                    ((Cliente) p).setQtdCarrosAlugados(rs.getInt("qtd_carros_alugados"));
                    ((Cliente) p).setTotalGasto(rs.getFloat("total_gasto"));
                    ((Cliente) p).setDescontoAtual(rs.getFloat("desconto_atual"));
                }

            }else if(p instanceof Funcionario){

                sql = "select * from funcionario where pessoa_cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
                rs = pst.executeQuery();

                while (rs.next()) {
                    ((Funcionario) p).setIdFuncionario(rs.getInt("id_funcionario"));
                    ((Funcionario) p).setValorFaturado(rs.getFloat("valor_faturado"));
                    ((Funcionario) p).setSalarioBase(rs.getFloat("salario_base"));
                    ((Funcionario) p).setTipoFuncionario(rs.getString("tipo_funcionario"));
                    
                    idAux = rs.getInt("loja_id_loja");
                    loja = lojaDAO.pesquisar(idAux);
                    ((Funcionario) p).setLoja(loja);
                }
            }

            pst.close();
            return p;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            return null;
        }
    }
    
    public Pessoa pesquisarFunc(int idFuncionario) {

        Pessoa p = new Funcionario();
        int idAux;
        String sql;
        String sqlAux;
        String cpf = "";
        
        Loja loja;
        Loja[] lojas = new Loja[100];
        LojaDAO lojaDAO = new LojaDAO();
        
        con = new ConexaoBD().getConexao();

        try {

            sql = "select * from funcionario where id_funcionario = ?;";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idFuncionario);
            rs = pst.executeQuery();

            while (rs.next()) {
                cpf = rs.getString("pessoa_cpf");
                ((Funcionario) p).setIdFuncionario(rs.getInt("id_funcionario"));
                ((Funcionario) p).setValorFaturado(rs.getFloat("valor_faturado"));
                ((Funcionario) p).setSalarioBase(rs.getFloat("salario_base"));
                ((Funcionario) p).setTipoFuncionario(rs.getString("tipo_funcionario"));

                idAux = rs.getInt("loja_id_loja");
                loja = lojaDAO.pesquisar(idAux);
                ((Funcionario) p).setLoja(loja);
            }
            
            sql = "select * from pessoa where cpf = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            while (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setEnderecoLogradouro(rs.getString("endereco_logradouro"));
                p.setEnderecoNumero(rs.getInt("endereco_numero"));
                p.setEnderecoBairro(rs.getString("endereco_bairro"));
                p.setEnderecoComplemento(rs.getString("endereco_complemento"));
                p.setEnderecoEstado(rs.getString("endereco_estado"));
                p.setEnderecoCidade(rs.getString("endereco_cidade"));
                p.setTelefoneCelular(rs.getString("telefone_celular"));
                p.setEmail(rs.getString("email"));
                p.setUsuario(rs.getString("usuario"));
                p.setSenha(rs.getString("senha"));
            }

            pst.close();
            return p;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            return null;
        }
    }
    
    public boolean atualizar(Pessoa pessoa) {
        
        int idAux = 0;
        String sqlAux;
        con = new ConexaoBD().getConexao();
        
        String sql = "update pessoa set rg = ?, nome = ?, data_nascimento = ?, endereco_logradouro = ?, "
                    + "endereco_numero = ?, endereco_bairro = ?, endereco_complemento = ?, endereco_estado = ?, "
                    + "endereco_cidade = ?, telefone_celular = ?, email = ?, usuario = ?, senha = ? where cpf = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getRg());
            pst.setString(2, pessoa.getNome());
            pst.setString(3, pessoa.getDataNascimento());
            pst.setString(4, pessoa.getEnderecoLogradouro());
            pst.setInt(5, pessoa.getEnderecoNumero());
            pst.setString(6, pessoa.getEnderecoBairro());
            pst.setString(7, pessoa.getEnderecoComplemento());
            pst.setString(8, pessoa.getEnderecoEstado());
            pst.setString(9, pessoa.getEnderecoCidade());
            pst.setString(10, pessoa.getTelefoneCelular());
            pst.setString(11, pessoa.getEmail());
            pst.setString(12, pessoa.getUsuario());
            pst.setString(13, pessoa.getSenha());
            pst.setString(14, pessoa.getCpf());
            pst.execute();
            
            if(pessoa instanceof Cliente){
                    
                sql = "update cliente set possui_pendencias = ?, valor_pendencias = ?, qtd_carros_alugados = ?, total_gasto = ?, "
                        + "desconto atual = ? where pessoa_cpf = ?;";
                
                Cliente auxC = (Cliente) pessoa;
                
                pst = con.prepareStatement(sql);
                pst.setBoolean(1, auxC.isPossuiPendencias());
                pst.setFloat(2, auxC.getValorPendencias());
                pst.setInt(3, auxC.getQtdCarrosAlugados());
                pst.setFloat(4, auxC.getTotalGasto());
                pst.setFloat(5, auxC.getDescontoAtual());
                pst.setString(6, pessoa.getCpf());
                pst.execute();

            }else if(pessoa instanceof Funcionario){

                sql = "update cliente set loja_id_loja = ?, valor_faturado = ?, salario_base = ?, tipo_funcionario = ?, "
                        + "where pessoa_cpf = ?;";
                
                Cliente auxC = (Cliente) pessoa;
                Funcionario auxF = (Funcionario) pessoa;
                
                pst = con.prepareStatement(sql);
                pst.setInt(1, auxF.getLoja().getIdLoja());
                pst.setFloat(2, auxF.getValorFaturado());
                pst.setFloat(3, auxF.getSalarioBase());
                pst.setString(4, auxF.getTipoFuncionario());
                pst.setString(5, pessoa.getCpf());
                pst.execute();
            }
            
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
    public boolean deletar(String cpf) {
        
        con = new ConexaoBD().getConexao();
        String sql = "delete from pessoa where cpf = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
}
