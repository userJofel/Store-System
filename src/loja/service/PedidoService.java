package loja.service;

import loja.model.Cliente;
import loja.model.Pedido;
import loja.model.Produto;

import java.util.ArrayList;

public class PedidoService {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
    }

    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto, int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        for (Pedido pedido1 : pedidos) {
            if (pedido1.getId() == pedido.getId()) {
                pedido1.adicionarItem(produto, quantidade);
                break;
            }
        }

    }

    public void listarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
}
