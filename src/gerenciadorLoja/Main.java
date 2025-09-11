package gerenciadorLoja;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Definindo o caminho da pasta de dados para evitar repetição
    private static final String DATA_PATH = "data/";

    public static void main(String[] args) {
        // --- 1. Inicializar e salvar dados ---
        System.out.println("--- Criando e salvando dados iniciais ---");

        // Criar lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "João Silva", "joao@email.com", "1111-1111"));
        clientes.add(new Cliente(2, "Maria Souza", "maria@email.com", "2222-2222"));

        // Criar lista de itens de estoque
        List<Item> estoque = new ArrayList<>();
        estoque.add(new Item(101, "Celular", 1500.00, 50));
        estoque.add(new Item(102, "Notebook", 3500.00, 20));
        estoque.add(new Item(103, "Mouse", 50.00, 100));

        // Salvar os dados usando os novos caminhos
        Memoria.salvaEstoque(DATA_PATH + "estoque.csv", estoque);
        Memoria.salvaUsuarios(DATA_PATH + "usuarios.csv", clientes);

        // Adicionar itens aos carrinhos dos clientes
        // Cliente João compra Celular e Mouse
        clientes.get(0).adicionarItemCarrinho(estoque.get(0), 1);
        clientes.get(0).adicionarItemCarrinho(estoque.get(2), 2);

        // Cliente Maria compra Notebook
        clientes.get(1).adicionarItemCarrinho(estoque.get(1), 1);

        // Salvar os carrinhos
        Memoria.salvaCarrinho(DATA_PATH + "carrinhos.csv", clientes);

        System.out.println("Dados iniciais salvos com sucesso.");
        System.out.println("------------------------------------");

        // --- 2. Simular nova execução e carregar dados ---
        System.out.println("\n--- Carregando dados de arquivos CSV ---");
        
        // Limpar listas em memória para simular uma nova sessão
        clientes.clear();
        estoque.clear();

        // Carregar itens de estoque primeiro, pois são necessários para carregar o carrinho
        estoque = Memoria.carregaEstoque(DATA_PATH + "estoque.csv");
        clientes = Memoria.carregaUsuarios(DATA_PATH + "usuarios.csv");
        Memoria.carregaCarrinho(DATA_PATH + "carrinhos.csv", clientes, estoque);

        // --- 3. Verificar os dados carregados ---
        System.out.println("\n--- Verificando dados carregados ---");
        
        System.out.println("\nClientes e seus carrinhos carregados:");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente ID: " + cliente.getId() + ", Nome: " + cliente.getNome());
            
            ArrayList<ItemPedido> carrinho = cliente.getPedido().getCarrinho();
            if (carrinho.isEmpty()) {
                System.out.println("   - Carrinho vazio.");
            } else {
                System.out.println("   - Carrinho:");
                for (ItemPedido itemPedido : carrinho) {
                    System.out.println("     - Item: " + itemPedido.getItem().getNome() +
                                       ", Quantidade: " + itemPedido.getQuantidade() +
                                       ", Subtotal: R$" + String.format("%.2f", itemPedido.getSubTotal()));
                }
                System.out.println("   - Total do Pedido: R$" + String.format("%.2f", cliente.getPedido().calcularTotal()));
            }
        }
    }


}