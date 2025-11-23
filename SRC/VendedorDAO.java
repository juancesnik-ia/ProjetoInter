import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendedorDAO {

    // REQUISITO: LOGIN
    // Verifica se existe um vendedor com esse Nome e CPF
    public boolean fazerLogin(String nome, String cpf) {
        String sql = "SELECT p.id FROM Pessoas p " +
                     "JOIN Vendedores v ON p.id = v.pessoa_id " +
                     "WHERE p.nome = ? AND p.cpf = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            // Se retornou alguma linha, o login é válido
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
        return false;
    }
}