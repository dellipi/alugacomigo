package br.inatel.alugacomigo.conexaobd;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConexaoBD().getConexao();
        connection.close();
    }
}