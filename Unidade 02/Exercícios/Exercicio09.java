// Exercício 09: Mesclar Mapas com HashMap
// Extensão compatível: .txt (cada linha no formato chave:valor)
import java.io.*;
import java.util.*;

public class Exercicio09 {

    static Scanner scanner = new Scanner(System.in);
    static Map<String, Integer> produto1 = new HashMap<>();
    static Map<String, Integer> produto2 = new HashMap<>();
    static Map<String, Integer> produtoFinal = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
        do {
            System.out.println("\n=== Exercício 09: Mesclar Mapas ===");
            System.out.println("1 - Adicionar dados manualmente ao registro de produtos 1");
            System.out.println("2 - Adicionar dados manualmente ao registro de produtos 2");
            System.out.println("3 - Carregar registro de produtos 1 de arquivo");
            System.out.println("4 - Carregar registro de produtos 2 de arquivo");
            System.out.println("5 - Mesclar e mostrar resultado");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarManual(produto1, "Mapa 1");
                case 2 -> adicionarManual(produto2, "Mapa 2");
                case 3 -> carregarDeArquivo(produto1, "Mapa 1");
                case 4 -> carregarDeArquivo(produto2, "Mapa 2");
                case 5 -> mesclarMapas();
                case 0 -> {
                    System.out.println("Encerrando...");
                    scanner.close();
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void adicionarManual(Map<String, Integer> mapa, String nomeMapa) {
        System.out.print("Quantas entradas deseja adicionar em " + nomeMapa + "? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do produto: ");
            String produto = scanner.nextLine();
            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            mapa.put(produto, quantidade);
        }
    }

    public static void carregarDeArquivo(Map<String, Integer> mapa, String nomeMapa) {
        System.out.print("Informe o caminho do arquivo .txt para " + nomeMapa + "(arquivo deve estar com PRODUTO:QUANTIDADE): ");
        String caminho = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    int valor = Integer.parseInt(partes[1].trim());
                    mapa.put(chave, valor);
                }
            }
            System.out.println(nomeMapa + " carregado com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminho);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valores numéricos no arquivo.");
        }
    }

    public static void mesclarMapas() {
        produtoFinal.clear();
        produtoFinal.putAll(produto1);
        for (Map.Entry<String, Integer> entry : produto2.entrySet()) {
            produtoFinal.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("Mapas mesclados com sucesso!");
        exibirprodutoFinal();
    }

    public static void exibirprodutoFinal() {
        if (produtoFinal.isEmpty()) {
            System.out.println("Está vazio. Não pule as etapas, estou de olho em você!");
            return;
        }
        System.out.println("\nProdutos mesclados:");
        for (Map.Entry<String, Integer> entry : produtoFinal.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
}