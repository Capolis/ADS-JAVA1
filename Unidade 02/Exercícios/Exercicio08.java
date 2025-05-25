// Exercício 08: Contagem de Palavras com HashMap
// Extensão compatível: .txt (um texto por linha)
import java.io.*;
import java.util.*;

public class Exercicio08 {

    static Scanner scanner = new Scanner(System.in);
    static Map<String, Integer> contagemPalavras = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
        do {
            System.out.println("\n=== Exercício 08: Contagem de Palavras ===");
            System.out.println("1 - Inserir frase manualmente");
            System.out.println("2 - Carregar frase de arquivo");
            System.out.println("3 - Exibir contagem de palavras");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: 
                    inserirFraseManual(); 
                    break;
                case 2: 
                    carregarFraseDeArquivo();
                    break;
                case 3: 
                    exibirContagem();
                    break;
                case 0: 
                    System.out.println("Encerrando...");
                    scanner.close();
                    break;                
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void inserirFraseManual() {
        System.out.print("Digite a frase: ");
        String frase = scanner.nextLine();
        contarPalavras(frase);
    }

    public static void carregarFraseDeArquivo() {
        System.out.print("Informe o caminho do arquivo .txt: ");
        String caminho = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                contarPalavras(linha);
            }
            System.out.println("Frase carregada e analisada com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminho);
        }
    }

    public static void contarPalavras(String frase) {
        String[] palavras = frase.toLowerCase().split("\\W+");
        for (String palavra : palavras) {
            if (!palavra.isBlank()) {
                contagemPalavras.put(palavra, contagemPalavras.getOrDefault(palavra, 0) + 1);
            }
        }
    }

    public static void exibirContagem() {
        if (contagemPalavras.isEmpty()) {
            System.out.println("Nenhuma palavra analisada ainda.");
            return;
        }
        System.out.println("\nFrequência das palavras:");
        for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}