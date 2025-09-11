package gerenciadorLoja;

import java.util.ArrayList;

public class Pedido {
    private int id;
    ArrayList<ItemPedido> carrinho = new ArrayList<ItemPedido>();

    Pedido(int id, ArrayList<ItemPedido> carrinho){
        this.id = id;
        this.carrinho = carrinho;
    }
    public Pedido() {
        this.carrinho = new ArrayList<ItemPedido>();
    }

    public void setCarrinho(ArrayList<ItemPedido> carrinho) {
        this.carrinho = carrinho;
    }
    public ArrayList<ItemPedido> getCarrinho() {
        return carrinho;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void addItem(Item novoItem, int quantidade){
        carrinho.add(new ItemPedido(novoItem, quantidade));
    }
    public void rmItem(ItemPedido item){
        int i = carrinho.indexOf(item);
        if (i != -1) 
            carrinho.remove(i);
        else 
            System.out.println("Item não encontrado");
    }
    public void edItem(ItemPedido item, int novaQuant){
        int i = carrinho.indexOf(item);
        if (i != -1) 
            carrinho.set(i, new ItemPedido(item.getItem(), novaQuant));
        else 
        System.out.println("Item não encontrado");
    }
    public double calcularTotal(){
        double total = 0;
        for (ItemPedido i : this.carrinho){
            total += (i.getQuantidade() * i.getItem().getPreco());
        }
        return total;
    }

}
