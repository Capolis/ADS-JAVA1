// Exercício 4: Verificação de Expressões com Parênteses Balanceados
// Extensão compatível: .txt (uma expressão por linha)
import java.io.*;
import java.util.*;

public class Exercicio04 {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> expressoes = new ArrayList<>();
        String caminho = "";
        int opcao;

        do {
            System.out.println("\n=== Verificação de Parênteses Balanceados ===");
            System.out.println("1 - Digitar expressões manualmente");
            System.out.println("2 - Carregar expressões de um arquivo (.txt)");
            System.out.println("3 - Verificar expressões");
            System.out.println("4 - Exibir expressões");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    expressoes.clear();
                    System.out.print("Quantas expressões deseja adicionar? ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite a expressão " + (i + 1) + ": ");
                        expressoes.add(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Informe o caminho do arquivo .txt: ");
                    caminho = scanner.nextLine();
                    expressoes = lerExpressaoDeArquivo(caminho);
                    break;
                case 3:
                    verificarExpressoes(expressoes);
                    break;
                case 4:
                    exibirExpressao(expressoes);
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

    public static void verificarExpressoes(List<String> expressoes) {
        System.out.println("\nVerificando expressões:");
        for (String expr : expressoes) {
            if (estaBalanceada(expr)) {
                System.out.println(expr + " -> Parênteses balanceados");
            } else {
                System.out.println(expr + " -> Parênteses desbalanceados");
            }
        }
    }

        public static boolean estaBalanceada(String expressao) {
        Stack<Character> pilha = new Stack<>();
        for (char c : expressao.toCharArray()) {
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isEmpty() || pilha.pop() != '(') {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }

    public static void exibirExpressao(List<String> expressoes) {
        if (!expressoes.isEmpty()) {
            System.out.println("\nExpressões armazenadas:");
            for (String expr : expressoes) {
                System.out.println(expr);
            }
        } else {
            System.out.println("Nenhuma expressão armazenada.");
        }
    }

    public static List<String> lerExpressaoDeArquivo(String caminho) throws IOException {
        List<String> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        while ((linha = br.readLine()) != null) {
            lista.add(linha);
        }
        br.close();
        System.out.println("Arquivo carregado com sucesso! Total de linhas: " + lista.size());
        return lista;
    }

}