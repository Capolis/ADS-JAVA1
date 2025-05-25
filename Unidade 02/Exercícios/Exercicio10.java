// Exercício 10: Ordenação de Produtos por Vendas (Merge Sort)
// Extensão compatível: .txt (formato: nomeProduto:vendas)
import java.io.*;
import java.util.*;

public class Exercicio10 {

    static Scanner scanner = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
        do {
            System.out.println("\n=== Exercício 10: Ordenação de Produtos por Vendas ===");
            System.out.println("1 - Inserir produtos manualmente");
            System.out.println("2 - Carregar produtos de arquivo");
            System.out.println("3 - Ordenar produtos por vendas (decrescente)");
            System.out.println("4 - Exibir produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> inserirProdutosManualmente();
                case 2 -> carregarProdutosDeArquivo();
                case 3 -> ordenarProdutos();
                case 4 -> exibirProdutos();
                case 0 -> {
                    System.out.println("Encerrando...");
                    scanner.close();
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static class Produto {
        String nome;
        int vendas;

        Produto(String nome, int vendas) {
            this.nome = nome;
            this.vendas = vendas;
        }
    }

    public static void inserirProdutosManualmente() {
        System.out.print("Quantos produtos deseja adicionar? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();
            System.out.print("Quantidade de vendas: ");
            int vendas = scanner.nextInt();
            scanner.nextLine();
            produtos.add(new Produto(nome, vendas));
        }
    }

    public static void carregarProdutosDeArquivo() {
        System.out.print("Informe o caminho do arquivo .txt: ");
        String caminho = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String nome = partes[0].trim();
                    int vendas = Integer.parseInt(partes[1].trim());
                    produtos.add(new Produto(nome, vendas));
                }
            }
            System.out.println("Produtos carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminho);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler ou converter os dados do arquivo.");
        }
    }

    public static void ordenarProdutos() {
        produtos = mergeSort(produtos);
        System.out.println("Produtos ordenados por vendas (decrescente).");
    }

    public static List<Produto> mergeSort(List<Produto> lista) {
        if (lista.size() <= 1) return lista;

        int meio = lista.size() / 2;
        List<Produto> esquerda = mergeSort(lista.subList(0, meio));
        List<Produto> direita = mergeSort(lista.subList(meio, lista.size()));

        return merge(esquerda, direita);
    }

    public static List<Produto> merge(List<Produto> esquerda, List<Produto> direita) {
        List<Produto> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i).vendas >= direita.get(j).vendas) {
                resultado.add(esquerda.get(i++));
            } else {
                resultado.add(direita.get(j++));
            }
        }

        while (i < esquerda.size()) resultado.add(esquerda.get(i++));
        while (j < direita.size()) resultado.add(direita.get(j++));

        return resultado;
    }

    public static void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível. Adicione produtos primeiro ;/");
            return;
        }
        System.out.println("\nProdutos:");
        for (Produto produto : produtos) {
            System.out.println(produto.nome + " - Vendas: " + produto.vendas);
        }
    }

}