package gerenciadorLoja;

public class ItemPedido {
    private Item item;
    private int quantidade;

    public ItemPedido(Item item, int quantidade){
        this.item = item;
        this.quantidade = quantidade;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }
    public int getQuantidade() {
        return quantidade;
    }

    double getSubTotal(){
        return this.item.getPreco() * this.quantidade;
    }
}