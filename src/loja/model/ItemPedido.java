package loja.model;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    public Produto getProduto() { return this.produto; }
    public int getQuantidade() { return  this.quantidade; }
    public double getSubtotal() { return this.subtotal; }
}
