package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://192.168.40.128:15432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "alexandre26";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Carrega o Driver na memória
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado!", e);
        } catch (SQLException e) {
            throw new SQLException("Conexão não sucedida!", e);
        }
    }
}