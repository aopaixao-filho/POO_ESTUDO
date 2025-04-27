import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static final String URL = "jdbc:postgresql://192.168.40.128:15432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "alexandre26";

    public static Connection conectar() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            throw new SQLException("Conexão não sucedida!");
        }
    }

}