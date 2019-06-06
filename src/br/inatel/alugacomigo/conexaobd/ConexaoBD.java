package br.inatel.alugacomigo.conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public Connection getConexao() {

        String url = "jdbc:mysql://localhost:3306/aluga_comigo";
        String login = "root";
        String senha = "vertrigo";

        try {
            return DriverManager.getConnection(url, login, senha);
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            return null;
        }
        
    }
}
