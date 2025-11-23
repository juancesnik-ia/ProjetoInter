import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // Configure aqui os dados do seu SQL Server
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SistemaPedidosDB;encrypt=true;trustServerCertificate=true;";
    private static final String USUARIO = "sa"; // Seu usuário do SQL
    private static final String SENHA = "sua_senha"; // Sua senha do SQL

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}