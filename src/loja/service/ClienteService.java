package loja.service;

import loja.model.Cliente;

import java.util.ArrayList;

public class ClienteService {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome, String email) {
        if (nome.isEmpty() || email.isEmpty()) {
            return;
        } else {
            Cliente cliente = new Cliente(nome, email);
            clientes.add(cliente);
        }
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public Cliente buscarClientId(int id) {
        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }














}
