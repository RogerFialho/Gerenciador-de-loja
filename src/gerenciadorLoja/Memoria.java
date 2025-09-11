package gerenciadorLoja;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Memoria {
    
    public static void salvaUsuarios(String nomearquivo, List<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Cliente c : clientes){
                bw.write(c.getId() + "," + c.getNome() + "," + c.getEmail() + "," + c.getNumero());
                bw.newLine();
            }
            System.out.println("ususarios salvos");
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public static List<Cliente> carregaUsuarios(String nomearquivo){
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                String numero = dados[3];
                clientes.add(new Cliente(id, nome, email, numero));
            }
            System.out.println("Clientes carregados");
        } catch (Exception e) {
            System.out.println("Erro ao ler csv, iniciando sistema com lista vazia");
        }
        return clientes;
    }

    public static void salvaCarrinho(String nomearquivo, List<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Cliente c : clientes){
                ArrayList<ItemPedido> carrinho = c.getPedido().getCarrinho();
                for (ItemPedido item : carrinho){
                    // Write the client ID, item ID, item name, and quantity to the file
                    bw.write(c.getId() + "," + item.getItem().getId() + "," + item.getItem().getNome() + "," + item.getQuantidade());
                    bw.newLine();
                }
                System.out.println("Carrinho salvo");
            }
        } catch (Exception e) {
             e.printStackTrace();
        }

    }
    public static void carregaCarrinho(String nomearquivo, List<Cliente> clientes, List<Item> estoque){
        try (BufferedReader br = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] dados = linha.split(",");
                int idCliente = Integer.parseInt(dados[0]);
                int idItem = Integer.parseInt(dados[1]);
                String nomeItem = dados[2]; // não utilizado
                int quantidade = Integer.parseInt(dados[3]);
                encontraClientePorId(clientes, idCliente).adicionarItemCarrinho(encontraItemPorId(estoque, idItem), quantidade);
            }
            System.out.println( "Carrinhos de clientes carregados");
        } catch (Exception e) {
            System.out.println("Arquivo de carrinho não encontrado, iniciando lista de clientes com carrinhos vazios");
        }
    } 
    
    private static Cliente encontraClientePorId(List<Cliente> clientes, int id){
        for (Cliente c : clientes){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    private static Item encontraItemPorId(List<Item> itens, int id){
        for (Item i : itens){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }
    
    public static void salvaEstoque(String nomearquivo, List<Item> itens){
        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(nomearquivo))){
            for (Item i : itens){
                bw.write(i.getId() + "," + i.getNome() + "," + i.getPreco() + "," + i.getEstoque());
                bw.newLine();
            }
            System.out.println("Estoque salvo em " + nomearquivo);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    public static List<Item> carregaEstoque(String nomearquivo){
        List<Item> itens = new ArrayList<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(nomearquivo))){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double preco = Double.parseDouble(dados[2]);
                int estoque = Integer.parseInt(dados[3]);
                itens.add(new Item(id, nome, preco, estoque));
            }
            System.out.println("Estoque carregado");
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo de estoque. Iniciando com lista vazia.");
        }
        return itens;
    }
}
