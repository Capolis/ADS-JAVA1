// Exercício 1: Inversão de Lista
// Extensão compatível: .txt (uma tarefa por linha)
import java.io.*;
import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Inversão de Lista de Tarefas ===");
            System.out.println("1 - Digitar tarefas manualmente");
            System.out.println("2 - Carregar tarefas de um arquivo (.txt)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Quantas tarefas deseja adicionar? ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite a tarefa " + (i + 1) + ": ");
                        tarefas.add(scanner.nextLine());
                    }
                    exibirOrdemInversa(tarefas);
                    break;
                case 2:
                    System.out.print("Informe o caminho do arquivo .txt: ");
                    String caminho = scanner.nextLine();
                    tarefas = lerTarefasDeArquivo(caminho);
                    exibirOrdemInversa(tarefas);
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void exibirOrdemInversa(List<String> lista) {
        System.out.println("\nTarefas em ordem inversa:");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.println(lista.get(i));
        }
    }

    public static List<String> lerTarefasDeArquivo(String caminho) throws IOException {
        List<String> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        while ((linha = br.readLine()) != null) {
            lista.add(linha);
        }
        System.out.println("Arquivo lido com sucesso!");
        br.close();
        return lista;
    }
}
