package gerenciadorLoja;

import java.util.ArrayList;

public class Pedido {
    private int id;
    ArrayList<ItemPedido> carrinho = new ArrayList<ItemPedido>();

    Pedido(int id, ArrayList<ItemPedido> carrinho){
        this.id = id;
        this.carrinho = carrinho;
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

    public void addItem(Item novoItem){

    }
    public void rmItem(Item item){

    }
    public void edItem(Item item, int novaQuant){

    }
    public double calcularTotal(){
        double total = 0;
        for (ItemPedido i : this.carrinho){
            total += (i.getQuantidade() * i.getItem().getPreco());
        }
        return total;
    }

}
