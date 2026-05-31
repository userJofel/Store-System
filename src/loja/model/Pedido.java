package loja.model;

import java.util.ArrayList;

public class Pedido {
    private static int nextId = 1;
    private final int id;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private double total;

    public Pedido(Cliente cliente) {
        this.id = nextId;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        nextId++;
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);

        this.total = calcularTotal();
    }

    public double calcularTotal() {
        double soma = 0;
        for (ItemPedido item : itens) {
            soma += item.getSubtotal();
        }
        return soma;
    }

    public void exibirDetalhes() {
        System.out.println("========== PEDIDO #" + id + " ==========");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("---------- Itens ----------");
        for (ItemPedido item : itens) {
            System.out.println(item);
        }
        System.out.println("---------------------------");
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.println("===================================");
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", itens=" + itens.size() +
                ", total=R$ " + String.format("%.2f", total) +
                "}";
    }
} 
