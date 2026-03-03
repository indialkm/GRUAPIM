package view;

import java.util.Scanner;
import controller.*;
import repository.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        ClienteRepository clienteRepo = new ClienteRepository();
        ProdutoRepository produtoRepo = new ProdutoRepository();
        ContaRepository contaRepo = new ContaRepository(clienteRepo);
        
        ClienteCotroller clienteCtrl = new ClienteCotroller(clienteRepo);
        ProdutoController produtoCtrl = new ProdutoController(produtoRepo);
        ContaController contaCtrl = new ContaController(clienteRepo, produtoCtrl, contaRepo);
        int opcaoPrincipal = 0;

        while (opcaoPrincipal != 9) {
            System.out.println("\n========= VCRiquinho v1.0 =========");
            System.out.println("1 - Menu Clientes");
            System.out.println("2 - Menu Contas");
            System.out.println("3 - Menu Produtos");
            System.out.println("4 - Realizar Simulação de Rendimentos");
            System.out.println("9 - Sair");
            System.out.print("Opção: ");
            
            if (leitor.hasNextInt()) {
                opcaoPrincipal = leitor.nextInt();
                leitor.nextLine(); 

                switch (opcaoPrincipal) {
                    case 1 -> menuClientes(leitor, clienteCtrl);
                    case 2 -> menuContas(leitor, contaCtrl, clienteRepo);
                    case 3 -> menuProdutos(leitor, produtoCtrl);
                    case 4 -> realizarSimulacaoMenu(leitor, contaCtrl, clienteRepo);
                    case 9 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida!");
                }
            } else {
                leitor.next();
                System.out.println("Por favor, digite um número.");
            }
        }
        leitor.close();
    }

    private static void menuClientes(Scanner leitor, ClienteCotroller ctrl) {
        System.out.println("\n--- GESTÃO DE CLIENTES ---");
        System.out.println("1-Cadastrar | 2-Listar | 3-Atualizar | 4-Remover | 5-Voltar");
        int op = leitor.nextInt(); leitor.nextLine();
        switch (op) {
            case 1 -> {
                System.out.print("Nome: "); String n = leitor.nextLine();
                System.out.print("Email: "); String e = leitor.nextLine();
                System.out.print("Doc: "); String d = leitor.nextLine();
                ctrl.cadastrar(n, e, d);
            }
            case 2 -> ctrl.listarTodos();
            case 3 -> {
                System.out.print("Doc atual do cliente: "); String d = leitor.nextLine();
                System.out.print("Novo Nome: "); String n = leitor.nextLine();
                System.out.print("Novo Email: "); String e = leitor.nextLine();
                ctrl.atualizar(d, n, e);
            }
            case 4 -> {
                System.out.print("Doc para remover: "); String d = leitor.nextLine();
                ctrl.remover(d);
            }
        }
    }

    private static void menuContas(Scanner leitor, ContaController ctrl, ClienteRepository repo) {
        System.out.println("\n--- GESTÃO DE CONTAS ---");
        System.out.println("1-Criar | 2-Listar de um Cliente | 3-Remover | 4-Voltar");
        int op = leitor.nextInt(); leitor.nextLine();
        switch (op) {
            case 1 -> {
                System.out.print("Doc Cliente: "); String d = leitor.nextLine();
                System.out.print("Número: "); String n = leitor.nextLine();
                System.out.println("Tipo: 1-Corrente | 2-CDI | 3-Inv. Automático");
                int t = leitor.nextInt();
      
                ctrl.criarConta(d, n, t);

            }
            case 2 -> {
                System.out.print("Doc Cliente: "); String d = leitor.nextLine();
                ctrl.listarContasDoCliente(d);
                System.out.println();
                ctrl.listarProdutosConta(d);
            }
            case 3 -> {
                System.out.print("Doc Cliente: "); String d = leitor.nextLine();
                System.out.print("Número da conta: "); String n = leitor.nextLine();
                ctrl.removerConta(d, n);
            }
        }
    }

    private static void menuProdutos(Scanner leitor, ProdutoController ctrl) {
        System.out.println("\n--- GESTÃO DE PRODUTOS ---");
        System.out.println("1-Cadastrar | 2-Listar | 3-Atualizar Descrição | 4-Remover | 5-Voltar");
        int op = leitor.nextInt(); leitor.nextLine();
        switch (op) {
            case 1 -> {
                System.out.println("1-Fixa | 2-Variável");
                int t = leitor.nextInt(); leitor.nextLine();
                System.out.print("Nome: "); String n = leitor.nextLine();
                System.out.print("Desc: "); String d = leitor.nextLine();
                System.out.print("Taxa: "); double tx = leitor.nextDouble();
                if(t == 1) {
                    System.out.print("Carência: "); int c = leitor.nextInt();
                    ctrl.cadastrarRendaFixa(n, d, tx, c);
                } else {
                    ctrl.cadastrarRendaVariavel(n, d, tx);
                }
            }
            case 2 -> ctrl.listarProdutos();
            case 3 -> {
                System.out.print("Nome do produto: "); String n = leitor.nextLine();
                System.out.print("Nova Descrição: "); String d = leitor.nextLine();
                ctrl.atualizarDescricao(n, d);
            }
            case 4 -> {
                System.out.print("Nome para remover: "); String n = leitor.nextLine();
                ctrl.remover(n);
            }
        }
    }

    private static void realizarSimulacaoMenu(Scanner leitor, ContaController ctrl, ClienteRepository repo) {
        System.out.print("Doc do Cliente: ");
        String doc = leitor.nextLine();
        Cliente c = repo.buscarPorDocumento(doc);
        if (c != null) {
            System.out.print("Dias p/ simulação: ");
            int dias = leitor.nextInt();
            System.out.print("Saldo p/ teste (R$): ");
            double saldo = leitor.nextDouble();
            for(Conta conta : c.getContas()) { conta.setSaldo(saldo); }
            ctrl.realizarSimulacao(c, dias);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}