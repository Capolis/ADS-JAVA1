import java.util.Scanner;

// Classe que representa um nó com uma categoria (String)
class NoCategoria {
    String valor;
    NoCategoria esquerda, direita;

    public NoCategoria(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class exercicio02 {
    static NoCategoria raiz = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // Menu principal da aplicação
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Verificação de Árvore Binária como BST (Strings) ---");
            System.out.println("1. Inserir categoria");
            System.out.println("2. Verificar se a árvore é uma BST");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> inserirCategoria();
                case 2 -> {
                    System.out.println("\nCategorias (em ordem):");
                    exibirEmOrdem(raiz);
                    boolean resultado = BST(raiz, null, null);
                    System.out.println("\n\nA árvore " + (resultado ? "é" : "não é") + " uma BST válida.");
                }
                case 0 -> {
                    scanner.close();
                    System.out.println("Programa encerrado.");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // O usuário define onde colocar o novo nó (esquerda ou direita de algum nó)
    public static void inserirCategoria() {
        System.out.print("Digite o nome da nova categoria: ");
        String novaCategoria = scanner.nextLine();
        NoCategoria novoNo = new NoCategoria(novaCategoria);

        if (raiz == null) {
            raiz = novoNo;
            System.out.println("Categoria inserida como raiz.");
            return;
        }

        NoCategoria atual = raiz;
        while (true) {
            System.out.println("Você está no nó: " + atual.valor);
            System.out.print("Deseja inserir à esquerda (E) ou à direita (D)? ");
            String direcao = scanner.nextLine().toUpperCase();

            if (direcao.equals("E")) {
                if (atual.esquerda == null) {
                    atual.esquerda = novoNo;
                    System.out.println("Categoria inserida à esquerda de " + atual.valor);
                    return;
                } else {
                    atual = atual.esquerda;
                }
            } else if (direcao.equals("D")) {
                if (atual.direita == null) {
                    atual.direita = novoNo;
                    System.out.println("Categoria inserida à direita de " + atual.valor);
                    return;
                } else {
                    atual = atual.direita;
                }
            } else {
                System.out.println("Direção inválida. Digite 'E' ou 'D'.");
            }
        }
    }

    // Exibe os nós em ordem
    public static void exibirEmOrdem(NoCategoria no) {
        if (no != null) {
            exibirEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            exibirEmOrdem(no.direita);
        }
    }

    // Verifica se a árvore binária pode ser considerada uma BST
    public static boolean BST(NoCategoria no, String min, String max) {
        if (no == null) return true;

        if ((min != null && no.valor.compareToIgnoreCase(min) <= 0) ||
            (max != null && no.valor.compareToIgnoreCase(max) >= 0)) {
            return false;
        }

        return BST(no.esquerda, min, no.valor) &&
               BST(no.direita, no.valor, max);
    }

}