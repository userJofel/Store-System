package loja.model;

public class Produto {

    private static int nextId = 1;
    private final int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, Double preco, int quantidade) {
        this.id = nextId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        nextId++;
    }

    public Produto(String nome, Double preco) {
        this.id = nextId;
        this.nome = nome;
        this.preco = preco;
        nextId++;
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public double getPreco() { return this.preco; }
    public int getQuantidade() { return this.quantidade; }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero!");
        } else {
            this.quantidade += quantidade;
            System.out.println(quantidade + " itens adicionado ao estoque | Novo estoque: " + this.quantidade);
        }
    }
    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero!");
        } else if (quantidade > this.quantidade) {
            System.out.println("Você não pode remover mais do que você já tem!");
        } else {
            this.quantidade += quantidade;
            System.out.println(quantidade + " itens adicionado ao estoque | Novo estoque: " + this.quantidade);
        }
    }

    @Override
    public String toString() {
        return ( this.getId() + "# | Nome: " + this.getNome() + " | Preço: " + this.getPreco() + " | Estoque: " + this.getQuantidade());
    }
}
