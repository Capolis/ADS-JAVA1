// Exercício 07: Ordem de Chegada - Fila de Clientes
// Extensão compatível: .txt (um cliente por linha)
import java.io.*;
import java.util.*;

public class Exercicio07 {

    static Scanner scanner = new Scanner(System.in);
    static Queue<String> filaClientes = new LinkedList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;

        do {
            System.out.println("\n=== Fila de Ordem de Chegada ===");
            System.out.println("1 - Adicionar cliente manualmente");
            System.out.println("2 - Carregar clientes de arquivo (.txt)");
            System.out.println("3 - Exibir fila de clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarClientesManualmente();
                    break;
                case 2:
                    carregarClientesDeArquivo();
                    break;
                case 3:
                    exibirFila();
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

    public static void adicionarClientesManualmente() {
        System.out.print("Quantos clientes deseja adicionar? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do cliente " + (i + 1) + ": ");
            filaClientes.add(scanner.nextLine());
        }
    }

    public static void carregarClientesDeArquivo() {
        System.out.print("Informe o caminho do arquivo .txt: ");
        String caminho = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                filaClientes.add(linha);
            }
            System.out.println("Clientes carregados com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public static void exibirFila() {
        if (filaClientes.isEmpty()) {
            System.out.println("Sem clientes, hora de levantar e fazer um alongamento ;)");
        } else {
            System.out.println("\nOrdem de saída da fila de clientes:");
            int posicao = 1;
            for (String cliente : filaClientes) {
                System.out.println(posicao + ". " + cliente);
                posicao++;
            }
        }
    }

}