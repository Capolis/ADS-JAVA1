import java.util.ArrayList;
import java.util.Scanner;

public class exercicio03 {
    static ArrayList<String> contatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // Menu da agenda de contatos
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Agenda de Contatos ---");
            System.out.println("1. Adicionar contato (número sem formatação)");
            System.out.println("2. Mostrar contatos");
            System.out.println("3. Buscar número (Busca Linear)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> mostrarContatos();
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

    // Adiciona um contato à lista
    public static void adicionarContato() {
        System.out.print("Digite o número (somente dígitos): ");
        String numero = scanner.nextLine();
        contatos.add(numero);
        System.out.println("Contato adicionado!");
    }

    // Exibe todos os contatos
    public static void mostrarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("Lista de contatos:");
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println((i + 1) + ". " + contatos.get(i));
            }
        }
    }

    // Realiza busca linear por um número
    public static int buscarNumero() {
        System.out.print("Digite o número a ser buscado: ");
        String busca = scanner.nextLine();
        int posicao = -1;
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).equals(busca)) {
                posicao = i;
                break;
            }
        }

        return posicao;
    }

}