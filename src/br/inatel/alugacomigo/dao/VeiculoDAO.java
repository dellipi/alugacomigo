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

public class VeiculoDAO {
    
    private Connection con; // Objeto responsável pela conexão com o banco
    private PreparedStatement pst; // Objeto para manipular comandos SQL dinâmicos
    private Statement st; // Objeto para manipular comandos SQL estáticos
    private ResultSet rs; // Objeto que referencia a tabela gerada em uma busca
    private boolean success;
    
    public boolean inserir(Veiculo novoVeiculo) {
        
        String sql;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "insert into veiculo(chassi, marca, modelo, placa, potencia_motor, torque_motor, "
                        + "classificacao_consumo, consumo_medio, quilometragem, valor_aluguel_diaria, "
                        + "valor_aluguel_km, valor_venda, loja_id_loja) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, novoVeiculo.getChassi());
                pst.setString(2, novoVeiculo.getMarca());
                pst.setString(3, novoVeiculo.getModelo());
                pst.setString(4, novoVeiculo.getPlaca());
                pst.setInt(5, novoVeiculo.getPotenciaMotor());
                pst.setInt(6, novoVeiculo.getTorqueMotor());
                pst.setString(7, novoVeiculo.getClassificacaoConsumo());
                pst.setFloat(8, novoVeiculo.getConsumoMedio());
                pst.setInt(9, novoVeiculo.getQuilometragem());
                pst.setFloat(10, novoVeiculo.getValorAluguelDiaria());
                pst.setFloat(11, novoVeiculo.getValorAluguelKM());
                pst.setFloat(12, novoVeiculo.getValorVenda());
                pst.setInt(13, novoVeiculo.getLoja().getIdLoja());
                pst.execute();
                
                if(novoVeiculo instanceof VeiculoPasseio){
                    
                    sql = "insert into veiculo_passeio(veiculo_chassi, capacidade_passageiros, "
                        + "capacidade_bagageiro) values (?,?,?);";
                    
                    VeiculoPasseio auxVP = (VeiculoPasseio) novoVeiculo;
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novoVeiculo.getChassi());
                    pst.setInt(2, auxVP.getCapacidadePassageiros());
                    pst.setInt(3, auxVP.getCapacidadeBagageiro());
                    pst.execute();
                    
                }else if(novoVeiculo instanceof VeiculoComercial){
                    
                    sql = "insert into veiculo_passeio(veiculo_chassi, capacidade_carga_volume, "
                        + "capacidade_carga_peso) values (?,?,?);";
                    
                    VeiculoComercial auxVC = (VeiculoComercial) novoVeiculo;
                    
                    pst = con.prepareStatement(sql);
                    pst.setString(1, novoVeiculo.getChassi());
                    pst.setInt(2, auxVC.getCapacidadeCargaVolume());
                    pst.setInt(3, auxVC.getCapacidadeCargaPeso());
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
    
    public Veiculo pesquisar(String chassi, int tipoVeiculo) {

        Veiculo v;
        int idAux;
        String sql;
        String sqlAux;
        
        Loja loja;
        LojaDAO lojaDAO = new LojaDAO();
        
        switch (tipoVeiculo) {
            case 0:
                v = new VeiculoPasseio();
                break;
            default:
                v = new VeiculoComercial();
                break;
        }

        try {

            sql = "select * from veiculo where chassi = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, chassi);
            rs = pst.executeQuery();

            while (rs.next()) {
                v.setChassi(rs.getString("chassi"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                v.setPotenciaMotor(rs.getInt("potencia_motor"));
                v.setTorqueMotor(rs.getInt("torque_motor"));
                v.setClassificacaoConsumo(rs.getString("classificacao_consumo"));
                v.setConsumoMedio(rs.getFloat("consumo_medio"));
                v.setQuilometragem(rs.getInt("quilometragem"));
                v.setValorAluguelDiaria(rs.getFloat("valor_aluguel_diaria"));
                v.setValorAluguelKM(rs.getInt("valor_aluguel_km"));
                v.setValorVenda(rs.getFloat("valor_venda"));
                
                idAux = rs.getInt("loja_id_loja");
                loja = lojaDAO.pesquisar(idAux);
                v.setLoja(loja);
                
            }
            
            if(v instanceof VeiculoPasseio){
                    
                sql = "select * from veiculo_passeio where chassi = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, chassi);
                rs = pst.executeQuery(sql);

                while (rs.next()) {
                    ((VeiculoPasseio) v).setCapacidadePassageiros(rs.getInt("capacidade_passageiros"));
                    ((VeiculoPasseio) v).setCapacidadeBagageiro(rs.getInt("capacidade_bagageiro"));
                }

            }else if(v instanceof VeiculoComercial){

                sql = "select * from veiculo_comercial where chassi = ?;";

                pst = con.prepareStatement(sql);
                pst.setString(1, chassi);
                rs = pst.executeQuery(sql);

                while (rs.next()) {
                    ((VeiculoComercial) v).setCapacidadeCargaVolume(rs.getInt("capacidade_passageiros"));
                    ((VeiculoComercial) v).setCapacidadeCargaPeso(rs.getInt("capacidade_bagageiro"));
                }
            }

            pst.close();
            return v;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            return null;
        }
    }
    
    public boolean atualizar(Veiculo veiculo) {
        
        String sql;
        con = new ConexaoBD().getConexao();
        
        if(con != null){
            try {
        
                sql = "update veiculo set marca = ?, modelo = ?, placa = ?, potencia_motor = ?, torque_motor = ?, "
                        + "classificacao_consumo = ?, consumo_medio = ?, quilometragem = ?, valor_aluguel_diaria = ?, "
                        + "valor_aluguel_km = ?, valor_venda = ?, loja_id_loja = ? where chassi = ?;";
                
                pst = con.prepareStatement(sql);
                pst.setString(1, veiculo.getMarca());
                pst.setString(2, veiculo.getModelo());
                pst.setString(3, veiculo.getPlaca());
                pst.setInt(4, veiculo.getPotenciaMotor());
                pst.setInt(5, veiculo.getTorqueMotor());
                pst.setString(6, veiculo.getClassificacaoConsumo());
                pst.setFloat(7, veiculo.getConsumoMedio());
                pst.setInt(8, veiculo.getQuilometragem());
                pst.setFloat(9, veiculo.getValorAluguelDiaria());
                pst.setFloat(10, veiculo.getValorAluguelKM());
                pst.setFloat(11, veiculo.getValorVenda());
                pst.setInt(12, veiculo.getLoja().getIdLoja());
                pst.setString(13, veiculo.getChassi());
                pst.execute();
                
                if(veiculo instanceof VeiculoPasseio){
                    
                    sql = "update veiculo_passeio set, capacidade_passageiros = ?, "
                        + "capacidade_bagageiro = ? where veiculo_chassi = ?;";
                    
                    VeiculoPasseio auxVP = (VeiculoPasseio) veiculo;
                    
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, auxVP.getCapacidadePassageiros());
                    pst.setInt(2, auxVP.getCapacidadeBagageiro());
                    pst.setString(3, veiculo.getChassi());
                    pst.execute();
                    
                }else if(veiculo instanceof VeiculoComercial){
                    
                    sql = "update veiculo_passeio set, capacidade_carga_volume = ?, "
                        + "capacidade_carga_peso = ? where veiculo_chassi = ?;";
                    
                    VeiculoComercial auxVC = (VeiculoComercial) veiculo;
                    
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, auxVC.getCapacidadeCargaVolume());
                    pst.setInt(2, auxVC.getCapacidadeCargaPeso());
                    pst.setString(3, veiculo.getChassi());
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
    
    public boolean deletar(String chassi) {
        
        String sql = "delete from veiculo where chassi = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, chassi);
            pst.execute();
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            success = false;
        }
        
        return success;
    }
    
}
