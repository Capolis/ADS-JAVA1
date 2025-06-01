import java.util.*;

public class exercicio05 {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, List<String>> grafo = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    // Menu principal do grafo
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Exercício 05: Representação de Grafos ---");
            System.out.println("1. Adicionar vértice");
            System.out.println("2. Adicionar aresta");
            System.out.println("3. Mostrar grafo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarVertice();
                case 2 -> adicionarAresta();
                case 3 -> mostrarGrafo();
                case 0 -> {
                    scanner.close();
                    System.out.println("Programa encerrado.");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Adiciona um vértice ao grafo
    public static void adicionarVertice() {
        System.out.print("Digite o nome do vértice: ");
        String vertice = scanner.nextLine();
        grafo.putIfAbsent(vertice, new ArrayList<>());
        System.out.println("Vértice adicionado!");
    }

    // Adiciona uma aresta entre dois vértices
    public static void adicionarAresta() {
        System.out.print("Digite o vértice de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Digite o vértice de destino: ");
        String destino = scanner.nextLine();
        grafo.putIfAbsent(origem, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origem).add(destino);
        grafo.get(destino).add(origem); // Grafo não direcionado
        System.out.println("Aresta adicionada!");
    }

    // Exibe o grafo
    public static void mostrarGrafo() {
        System.out.println("\nRepresentação do Grafo:");
        for (String vertice : grafo.keySet()) {
            System.out.print(vertice + " -> ");
            System.out.println(grafo.get(vertice));
        }
    }
    
}