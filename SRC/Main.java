public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PEDIDOS INICIADO ===");

        // 1. Teste de LOGIN
        VendedorDAO vendedorDao = new VendedorDAO();
        // Use um CPF que exista no seu banco para testar
        boolean logou = vendedorDao.fazerLogin("João Silva", "123.456.789-00"); 
        
        if (logou) {
            System.out.println("Login realizado com sucesso!");

            // 2. Teste de CRUD PRODUTO
            ProdutoDAO produtoDao = new ProdutoDAO();
            
            // Criando um produto (Objeto simples simulado)
            // Obs: Você precisa ter a classe Produto.java criada com os getters
            // produtoDao.cadastrar(new Produto("Mouse Gamer", 50.00, 100));
            
            produtoDao.listarTodos();

            // 3. Teste de VENDA (N x N)
            PedidoDAO pedidoDao = new PedidoDAO();
            // idVendedor=1, idCliente=2, idProduto=1, Qtd=2, Valor=50.00
            pedidoDao.registrarPedido(1, 2, 1, 2, 50.00);

        } else {
            System.out.println("Acesso negado. Verifique Nome e CPF.");
        }
    }
}