// Exercício 5: Inversão com Pilha
// Extensão compatível: .txt (um produto por linha)

import java.io.*;
import java.util.*;

public class Exercicio05 {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        List<String> produtos = new ArrayList<>();
        String caminho = "";
        int opcao;

        do {
            System.out.println("\n=== Inversão de Produtos com Pilha ===");
            System.out.println("1 - Adicionar produtos manualmente");
            System.out.println("2 - Carregar produtos de um arquivo (.txt)");
            System.out.println("3 - Inverter produtos e exibir");
            System.out.println("4 - Exibir lista atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    produtos.clear();
                    System.out.print("Quantos produtos deseja adicionar? ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite o nome do produto " + (i + 1) + ": ");
                        produtos.add(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Informe o caminho do arquivo .txt: ");
                    caminho = scanner.nextLine();
                    produtos = lerProdutosDeArquivo(caminho);
                    break;
                case 3:
                    List<String> invertidos = inverterProdutos(produtos);
                    System.out.print("Deseja salvar a lista invertida em um arquivo? (s/n): ");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        System.out.print("Informe o nome do arquivo para salvar: ");
                        String novoArquivo = scanner.nextLine();
                        salvarProdutos(invertidos, novoArquivo);
                    }
                    break;
                case 4:
                    exibirLista(produtos);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static List<String> inverterProdutos(List<String> produtos) {
        Stack<String> pilha = new Stack<>();
        for (String produto : produtos) {
            pilha.push(produto);
        }
        List<String> invertida = new ArrayList<>();
        while (!pilha.isEmpty()) {
            invertida.add(pilha.pop());
        }
        System.out.println("\nLista invertida:");
        for (String p : invertida) {
            System.out.println(p);
        }
        return invertida;
    }

    public static List<String> lerProdutosDeArquivo(String caminho) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(linha);
            }
            System.out.println("Produtos carregados com sucesso!");
            System.out.println("Total de produtos: " + lista.size());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarProdutos(List<String> produtos, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho + ".txt"))) {
            for (String produto : produtos) {
                bw.write(produto);
                bw.newLine();
            }
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static void exibirLista(List<String> produtos) {
        if (!produtos.isEmpty()) {
            System.out.println("\nLista de produtos:");
            for (String p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Lista vazia.");
        }
    }
}