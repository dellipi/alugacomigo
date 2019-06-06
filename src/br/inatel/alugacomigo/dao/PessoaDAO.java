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
        
                sql = "insert into pessoa(cpf, rg, nome, data_nascimento, idade, endereco_logradouro, endereco_numero, "
                        + "endereco_bairro, endereco_complemento, endereco_estado, endereco_cidade, telefone_celular, "
                        + "email, usuario, senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, novaPessoa.getCpf());
                pst.setString(2, novaPessoa.getRg());
                pst.setString(3, novaPessoa.getNome());
                pst.setDate(4, (Date) novaPessoa.getDataNascimento());
                pst.setInt(5, novaPessoa.getIdade());
                pst.setString(6, novaPessoa.getEnderecoLogradouro());
                pst.setInt(7, novaPessoa.getEnderecoNumero());
                pst.setString(8, novaPessoa.getEnderecoBairro());
                pst.setString(9, novaPessoa.getEnderecoComplemento());
                pst.setString(10, novaPessoa.getEnderecoEstado());
                pst.setString(11, novaPessoa.getEnderecoCidade());
                pst.setString(12, novaPessoa.getTelefoneCelular());
                pst.setString(13, novaPessoa.getEmail());
                pst.setString(14, novaPessoa.getUsuario());
                pst.setString(15, novaPessoa.getSenha());
                pst.execute();
                
                if(novaPessoa instanceof Cliente){
                    
                    sql = "insert into cliente(pessoa_cpf) values (?);";
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novaPessoa.getCpf());
                    pst.execute();
                    
                }else if(novaPessoa instanceof Funcionario){
                    
                    sql = "insert into pessoa(pessoa_cpf, loja_id_loja, salario_base) values (?,?,?);";
                    
                    Funcionario auxF = (Funcionario) novaPessoa;
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novaPessoa.getCpf());
                    pst.setInt(2, auxF.getLoja().getIdLoja());
                    pst.setFloat(3, auxF.getSalarioBase());
                    pst.execute();
                    
                }else if(novaPessoa instanceof Gerente){
                    
                    sql = "insert into pessoa(cpf, qtd_funcionarios_gerenciados, salario_base) values (?,?,?);";

                    Gerente auxG = (Gerente) novaPessoa; 
                    Loja[] auxLojas = auxG.getLojasGerenciadas();
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novaPessoa.getCpf());
                    pst.setInt(2, auxG.getQtdFuncionariosGerenciados());
                    pst.setFloat(3, auxG.getSalarioBase());
                    pst.execute();
                    
                    sqlAux = "select * from gerente where pessoa_cpf = ?";
                    pst = con.prepareStatement(sqlAux);
                    pst.setString(1, novaPessoa.getCpf());
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        idAux = rs.getInt("id_gerente");
                    }
                    
                    for (Loja auxLoja : auxLojas) {
                        sqlAux = "insert into loja_has_gerente(loja_id_loja, gerente_id_gerente) values (?,?);";
                        pst = con.prepareStatement(sqlAux);
                        pst.setInt(1, idAux);
                        pst.setInt(2, auxLoja.getIdLoja());
                        pst.execute();
                    }
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
        
        switch (tipoPessoa) {
            case 0:
                p = new Cliente();
                break;
            case 1:
                p = new Funcionario();
                break;
            default:
                p = new Gerente();
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
                p.setDataNascimento(rs.getDate("data_nascimento"));
                p.setIdade(rs.getInt("idade"));
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
                    
                sql = "select * from cliente where cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
                rs = pst.executeQuery(sql);

                while (rs.next()) {
                    ((Cliente) p).setPossuiPendencias(rs.getBoolean("possui_pendencias"));
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
                    
                    idAux = rs.getInt("loja_id_loja");
                    loja = lojaDAO.pesquisar(idAux);
                    ((Funcionario) p).setLoja(loja);
                }

            }else if(p instanceof Gerente){

                sql = "select * from gerente where pessoa_cpf = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, p.getCpf());
                pst.execute();

                while (rs.next()) {
                    ((Gerente) p).setIdGerente(rs.getInt("id_gerente"));
                    ((Gerente) p).setQtdFuncionariosGerenciados(rs.getInt("qtd_funcionarios_gerenciados"));
                    ((Gerente) p).setSalarioBase(rs.getFloat("salario_base"));
                }
                
                sqlAux = "select * from loja_has_gerente where gerente_id_gerente = ?;";
                pst = con.prepareStatement(sqlAux);
                pst.setInt(1, ((Gerente) p).getIdGerente());
                pst.execute();
                
                while (rs.next()) {
                    idAux = rs.getInt("loja_id_loja");
                    loja = lojaDAO.pesquisar(idAux);
                    
                    for(int i = 0; i < lojas.length; i++) {
                        if(lojas[i] == null){
                            lojas[i] = loja;
                            break;
                        }
                    }
                }
                
                ((Gerente) p).setLojasGerenciadas(lojas);
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
        
        String sql = "update pessoa set rg = ?, nome = ?, data_nascimento = ?, idade = ?, endereco_logradouro = ?, "
                    + "endereco_numero = ?, endereco_bairro = ?, endereco_complemento = ?, endereco_estado = ?, "
                    + "endereco_cidade = ?, telefone_celular = ?, email = ?, usuario = ?, senha = ? where cpf = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getRg());
            pst.setString(2, pessoa.getNome());
            pst.setDate(3, (Date) pessoa.getDataNascimento());
            pst.setInt(4, pessoa.getIdade());
            pst.setString(5, pessoa.getEnderecoLogradouro());
            pst.setInt(6, pessoa.getEnderecoNumero());
            pst.setString(7, pessoa.getEnderecoBairro());
            pst.setString(8, pessoa.getEnderecoComplemento());
            pst.setString(9, pessoa.getEnderecoEstado());
            pst.setString(10, pessoa.getEnderecoCidade());
            pst.setString(11, pessoa.getTelefoneCelular());
            pst.setString(12, pessoa.getEmail());
            pst.setString(13, pessoa.getUsuario());
            pst.setString(14, pessoa.getSenha());
            pst.setString(15, pessoa.getCpf());
            pst.execute();
            
            if(pessoa instanceof Cliente){
                    
                sql = "insert into cliente(pessoa_cpf) values (?);";

                pst = con.prepareStatement(sql);
                pst.setString(1, pessoa.getCpf());
                pst.execute();

            }else if(pessoa instanceof Funcionario){

                sql = "insert into pessoa(pessoa_cpf, loja_id_loja, salario_base) values (?,?,?);";

                Funcionario auxF = (Funcionario) pessoa;

                pst = con.prepareStatement(sql);
                pst.setString(1, pessoa.getCpf());
                pst.setInt(2, auxF.getLoja().getIdLoja());
                pst.setFloat(3, auxF.getSalarioBase());
                pst.execute();

            }else if(pessoa instanceof Gerente){

                sql = "insert into pessoa(cpf, qtd_funcionarios_gerenciados, salario_base) values (?,?,?);";

                Gerente auxG = (Gerente) pessoa; 
                Loja[] auxLojas = auxG.getLojasGerenciadas();

                pst = con.prepareStatement(sql);
                pst.setString(1, pessoa.getCpf());
                pst.setInt(2, auxG.getQtdFuncionariosGerenciados());
                pst.setFloat(3, auxG.getSalarioBase());
                pst.execute();

                sqlAux = "select * from gerente where pessoa_cpf = ?";
                pst = con.prepareStatement(sqlAux);
                pst.setString(1, pessoa.getCpf());
                rs = pst.executeQuery();

                while (rs.next()) {
                    idAux = rs.getInt("id_gerente");
                }

                for (Loja auxLoja : auxLojas) {
                    sqlAux = "insert into loja_has_gerente(loja_id_loja, gerente_id_gerente) values (?,?);";
                    pst = con.prepareStatement(sqlAux);
                    pst.setInt(1, idAux);
                    pst.setInt(2, auxLoja.getIdLoja());
                    pst.execute();
                }
            }
            
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
    public boolean deletar(String cpf) {
        
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
