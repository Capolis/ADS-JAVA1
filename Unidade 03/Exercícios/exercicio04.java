import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exercicio04 {
    static ArrayList<Integer> numeros = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // Menu da aplicação de busca binária
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Busca Binária em Lista Ordenada ---");
            System.out.println("1. Adicionar número");
            System.out.println("2. Mostrar números");
            System.out.println("3. Buscar número (Busca Binária)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarNumero();
                case 2 -> mostrarNumeros();
                case 3 -> {
                    int posicao = buscarNumero();
                    if (posicao >= 0) {
                        System.out.println("Número encontrado na posição: " + (posicao + 1));
                    } else {
                        System.out.println("Número não encontrado.");
                    }
                }
                case 0 -> {
                    scanner.close();
                    System.out.println("Programa encerrado.");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Adiciona um número à lista e ordena
    public static void adicionarNumero() {
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        numeros.add(numero);
        Collections.sort(numeros);
        System.out.println("Número adicionado!");
    }

    // Mostra a lista ordenada de números
    public static void mostrarNumeros() {
        if (numeros.isEmpty()) {
            System.out.println("Nenhum número adicionado.");
        } else {
            System.out.println("Lista de números ordenados:");
            for (int i = 0; i < numeros.size(); i++) {
                System.out.println((i + 1) + ". " + numeros.get(i));
            }
        }
    }

    // Realiza busca binária em lista ordenada
    public static int buscarNumero() {
        System.out.print("Digite o número a ser buscado: ");
        int chave = scanner.nextInt();
        int esquerda = 0, direita = numeros.size() - 1;
        int posicao = -1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (numeros.get(meio) == chave) {
                posicao = meio;
                break;
            } else if (numeros.get(meio) < chave) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return posicao;
    }

}