package loja.service;

import loja.model.Produto;

import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();
    public void cadastrarProduto(String nome, double preco, int quantidade) {
        if (nome.isEmpty()) {
            return;
        } else if (preco == 0) {
            return;
        } else if (quantidade == 0) {
            return;
        } else {
            Produto product = new Produto(nome, preco, quantidade);
            produtos.add(product);
        }
    }

    public void listaProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public void buscarPorId(int id) {
        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                System.out.println(produto);
            }
        }
    }

    public boolean exiteProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
