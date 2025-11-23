import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // 1. CREATE (Cadastrar)
    public void cadastrar(Produto p) {
        String sql = "INSERT INTO Produtos (descricao, estoque, valor, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getDescricao()); // Supõe que você criou os Getters na classe Produto
            stmt.setInt(2, 100); // Estoque inicial
            stmt.setDouble(3, p.getValor());
            stmt.setString(4, "Ativo");
            
            stmt.execute();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    // 2. READ (Listar)
    public void listarTodos() {
        String sql = "SELECT * FROM Produtos";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            System.out.println("--- LISTA DE PRODUTOS ---");
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Nome: " + rs.getString("descricao") +
                                   " | R$: " + rs.getDouble("valor"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    // 3. UPDATE (Atualizar)
    public void atualizarPreco(int id, double novoPreco) {
        String sql = "UPDATE Produtos SET valor = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Preço atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    // 4. DELETE (Excluir)
    public void deletar(int id) {
        String sql = "DELETE FROM Produtos WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto excluído!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}