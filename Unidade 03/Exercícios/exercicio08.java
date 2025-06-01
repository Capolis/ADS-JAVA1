import java.util.*;

public class exercicio08 {
    static class Node {
        int valor;
        Node esquerda, direita;

        Node(int valor) {
            this.valor = valor;
        }
    }

    // Insere um valor na BST
    public static Node inserir(Node raiz, int valor) {
        if (raiz == null) return new Node(valor);
        if (valor < raiz.valor) raiz.esquerda = inserir(raiz.esquerda, valor);
        else raiz.direita = inserir(raiz.direita, valor);
        return raiz;
    }

    // Encontra o menor valor na BST
    public static int menorValor(Node raiz) {
        if (raiz == null) throw new NoSuchElementException("A árvore está vazia.");
        while (raiz.esquerda != null) raiz = raiz.esquerda;
        return raiz.valor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node raiz = null;
        int opcao;

        do {
            System.out.println("\n=== Exercício 08: Menor Valor na BST ===");
            System.out.println("1. Inserir valor");
            System.out.println("2. Mostrar menor valor");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a inserir: ");
                    int valor = scanner.nextInt();
                    raiz = inserir(raiz, valor);
                    break;
                case 2:
                    try {
                        System.out.println("Menor valor na BST: " + menorValor(raiz));
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
}