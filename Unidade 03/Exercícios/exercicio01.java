import java.util.Scanner;

// Classe que representa um nó da árvore binária com informações de um livro
class Livro {
    String titulo;
    Livro esquerda;
    Livro direita;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.esquerda = null;
        this.direita = null;
    }
}

public class exercicio01 {
    
    static Livro raiz = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // Menu principal da aplicação
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciamento de Biblioteca (Árvore Binária) ---");
            System.out.println("1. Inserir novo livro");
            System.out.println("2. Listar livros em pré-ordem");
            System.out.println("3. Listar livros em ordem");
            System.out.println("4. Listar livros em pós-ordem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> inserirLivro();
                case 2 -> preOrdem(raiz);
                case 3 -> emOrdem(raiz);
                case 4 -> posOrdem(raiz);
                case 0 -> {
                    scanner.close();
                    System.out.println("Encerrando programa...até logo!");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Método para inserir um novo livro na árvore
    public static void inserirLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        raiz = inserirRecursivo(raiz, titulo);
    }

    // Inserção recursiva em uma árvore binária comum
    public static Livro inserirRecursivo(Livro livro, String titulo) {
        if (livro == null) return new Livro(titulo);

        // Critério simples: inserir à esquerda se menor em ordem alfabética
        if (titulo.compareToIgnoreCase(livro.titulo) <= 0) {
            if(livro.titulo.equals(titulo)) {
                System.out.println("Livro já existe na biblioteca.");
                return livro; // Não insere se o livro já existir
            }
            livro.esquerda = inserirRecursivo(livro.esquerda, titulo);
        } else {
            livro.direita = inserirRecursivo(livro.direita, titulo);
        }
        return livro;
    }

    // Percurso em pré-ordem (raiz, esquerda, direita)
    public static void preOrdem(Livro livro) {
        if (livro != null) {
            System.out.println("Pré-ordem:");
            System.out.println(livro.titulo);
            preOrdem(livro.esquerda);
            preOrdem(livro.direita);
        }
        else {
            System.out.println("Sem livros para mostrar, adicione-os primeiro!.");
        }
    }

    // Percurso em ordem (esquerda, raiz, direita)
    public static void emOrdem(Livro livro) {
        if (livro != null) {
            System.out.println("Em ordem:");
            emOrdem(livro.esquerda);
            System.out.println(livro.titulo);
            emOrdem(livro.direita);
        }
        else {
            System.out.println("Sem livros para mostrar, adicione-os primeiro!.");
        }
    }

    // Percurso em pós-ordem (esquerda, direita, raiz)
    public static void posOrdem(Livro livro) {
        if (livro != null) {
            System.out.println("Pós-ordem:");
            posOrdem(livro.esquerda);
            posOrdem(livro.direita);
            System.out.println(livro.titulo);
        }
        else {
            System.out.println("Sem livros para mostrar, adicione-os primeiro!.");
        }
    }

}