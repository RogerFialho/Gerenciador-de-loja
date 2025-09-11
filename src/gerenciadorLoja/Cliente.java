package gerenciadorLoja;


public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String numero;
    private Pedido pedido;

    public Cliente (int id , String nome, String email, String numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.pedido = new Pedido();

    }

    public String getNome() {
        return nome;
    }  
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getNumero() {
        return numero;
    } 
    public Pedido getPedido() {
        return pedido;
    }

     
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void adicionarItemCarrinho(Item item, int quantidade){
        pedido.addItem(item, quantidade);
    }
    public void removeItemCarrinho(ItemPedido item){
        pedido.rmItem(item);
    }
    public void ediltaItemCarrinho(ItemPedido item, int novaQuant){
        pedido.edItem(item, novaQuant);
    }

    public void registraCompra(){
        for (ItemPedido i : this.pedido.carrinho){
            i.getItem().setEstoque(i.getItem().getEstoque() - i.getQuantidade());
        }
        System.out.println("compra registrada e estoque atualizado");
    }
}