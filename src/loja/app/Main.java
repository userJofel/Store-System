package loja.app;

import loja.model.Cliente;
import loja.model.Pedido;
import loja.model.Produto;
import loja.service.ClienteService;
import loja.service.PedidoService;
import loja.service.ProdutoService;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();

        int op;

        do {
            System.out.println("\n===== SISTEMA DE LOJA =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Cadastrar cliente");
            System.out.println("5 - Listar clientes");
            System.out.println("6 - Criar pedido");
            System.out.println("7 - Listar pedidos");
            System.out.println("8 - Ver detalhes de pedido");
            System.out.println("9 - Sair");

            System.out.print("Escolha: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    produtoService.cadastrarProduto(nomeProduto, preco, quantidade);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n===== PRODUTOS =====");
                    produtoService.listaProdutos();
                    break;

                case 3:
                    System.out.print("Digite o ID do produto: ");
                    int idProduto = scanner.nextInt();
                    scanner.nextLine();

                    produtoService.buscarProdutoPorId(idProduto);
                    break;

                case 4:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Email do cliente: ");
                    String email = scanner.nextLine();

                    clienteService.cadastrarCliente(nomeCliente, email);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 5:
                    System.out.println("\n===== CLIENTES =====");
                    clienteService.listarClientes();
                    break;

                case 6:
                    System.out.print("Digite o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente = clienteService.buscarClientId(idCliente);

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    pedidoService.criarPedido(cliente);

                    System.out.println("Pedido criado para o cliente: " + cliente.getNome());

                    System.out.print("Digite o ID do pedido criado: ");
                    int idPedidoCriado = scanner.nextInt();
                    scanner.nextLine();

                    Pedido pedido = pedidoService.buscarPedidoPorId(idPedidoCriado);

                    if (pedido == null) {
                        System.out.println("Pedido não encontrado.");
                        break;
                    }

                    int continuar;

                    do {
                        System.out.print("Digite o ID do produto: ");
                        int idProd = scanner.nextInt();

                        Produto produto = produtoService.buscarProdutoPorId(idProd);

                        if (produto == null) {
                            System.out.println("Produto não encontrado.");
                        } else {
                            System.out.print("Digite a quantidade: ");
                            int qtdPedido = scanner.nextInt();

                            pedidoService.adicionarProdutoAoPedido(pedido, produto, qtdPedido);
                            System.out.println("Produto adicionado ao pedido.");
                        }

                        System.out.print("Deseja adicionar outro produto? 1 - Sim | 0 - Não: ");
                        continuar = scanner.nextInt();
                        scanner.nextLine();

                    } while (continuar == 1);

                    break;

                case 7:
                    System.out.println("\n===== PEDIDOS =====");
                    pedidoService.listarPedidos();
                    break;

                case 8:
                    System.out.print("Digite o ID do pedido: ");
                    int idPedido = scanner.nextInt();
                    scanner.nextLine();

                    Pedido pedidoEncontrado = pedidoService.buscarPedidoPorId(idPedido);

                    if (pedidoEncontrado == null) {
                        System.out.println("Pedido não encontrado.");
                    } else {
                        System.out.println("\n===== DETALHES DO PEDIDO =====");
                        System.out.println(pedidoEncontrado);
                    }
                    break;

                case 9:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (op != 9);

        scanner.close();
    }
} 
