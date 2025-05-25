// ================================
// Exercício 3 - Mesclar Listas Intercalando Convidados
// ================================
// Esta aplicação mescla duas listas de convidados de maneira intercalada
// e exibe a nova lista. Permite também a leitura dos dados a partir de arquivos .txt.

import java.util.*;
import java.io.*;

public class Exercicio03 {

    public static void main(String[] args) {
        menuMesclarListas();
    }

    public static void menuMesclarListas() {
        Scanner scanner = new Scanner(System.in);
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        System.out.println("==============================");
        System.out.println("  MESCLAR LISTAS DE CONVIDADOS");
        System.out.println("==============================");
        System.out.println("1 - Inserir listas manualmente");
        System.out.println("2 - Carregar listas de arquivos (.txt)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Quantos convidados na lista 1? ");
                int n1 = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < n1; i++) {
                    System.out.print("Convidado lista 1 - " + (i + 1) + ": ");
                    lista1.add(scanner.nextLine());
                }

                System.out.print("Quantos convidados na lista 2? ");
                int n2 = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < n2; i++) {
                    System.out.print("Convidado lista 2 - " + (i + 1) + ": ");
                    lista2.add(scanner.nextLine());
                }
                break;
            case 2:
                System.out.print("Informe o caminho do arquivo da lista 1 (.txt): ");
                String caminho1 = scanner.nextLine();
                lista1 = lerListaDeArquivo(caminho1);

                System.out.print("Informe o caminho do arquivo da lista 2 (.txt): ");
                String caminho2 = scanner.nextLine();
                lista2 = lerListaDeArquivo(caminho2);
                break;
            case 0:
                System.out.println("Encerrando...");
                scanner.close();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        List<String> mesclada = mesclarListas(lista1, lista2);
        System.out.println("\nLista Mesclada:");
        for (String nome : mesclada) {
            System.out.println(nome);
        }
    }

    // Função que mescla duas listas de forma intercalada
    public static List<String> mesclarListas(List<String> l1, List<String> l2) {
        List<String> resultado = new ArrayList<>();
        int max = Math.max(l1.size(), l2.size());

        for (int i = 0; i < max; i++) {
            if (i < l1.size()) resultado.add(l1.get(i));
            if (i < l2.size()) resultado.add(l2.get(i));
        }

        return resultado;
    }

    // Função que lê uma lista de nomes de um arquivo txt
    public static List<String> lerListaDeArquivo(String caminho) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    lista.add(linha.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lista;
    }
}