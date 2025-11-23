import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PedidoDAO {

    // REQUISITO: N x N (Salvar Pedido + Itens)
    public void registrarPedido(int idVendedor, int idCliente, int idProduto, int qtd, double valorUnitario) {
        String sqlPedido = "INSERT INTO Pedidos (data, valor, status, vendedor_id, cliente_id) VALUES (GETDATE(), ?, 'Aberto', ?, ?)";
        String sqlItem = "INSERT INTO Itens_pedidos (pedido_id, produto_id, qtd, valor) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao()) {
            // Passo 1: Salvar o Pedido (Cabeçalho)
            // RETURN_GENERATED_KEYS serve para pegar o ID do pedido que acabou de ser criado
            PreparedStatement stmt = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            double valorTotal = qtd * valorUnitario;
            
            stmt.setDouble(1, valorTotal);
            stmt.setInt(2, idVendedor);
            stmt.setInt(3, idCliente);
            stmt.execute();

            // Pegar o ID gerado do Pedido
            ResultSet rs = stmt.getGeneratedKeys();
            int idPedidoGerado = 0;
            if (rs.next()) {
                idPedidoGerado = rs.getInt(1);
            }

            // Passo 2: Salvar o Item (N x N)
            PreparedStatement stmtItem = conn.prepareStatement(sqlItem);
            stmtItem.setInt(1, idPedidoGerado); // Usa o ID do pedido novo
            stmtItem.setInt(2, idProduto);
            stmtItem.setInt(3, qtd);
            stmtItem.setDouble(4, valorUnitario);
            stmtItem.execute();

            System.out.println("Venda realizada! Pedido Nº " + idPedidoGerado + " criado com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao vender: " + e.getMessage());
        }
    }
}