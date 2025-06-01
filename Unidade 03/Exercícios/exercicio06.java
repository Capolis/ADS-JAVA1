import java.util.*;

public class exercicio06 {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, List<String>> grafo = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    // Menu da aplicação de BFS
    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- Exercício 06: BFS em Grafos ---");
            System.out.println("1. Adicionar vértice");
            System.out.println("2. Adicionar aresta");
            System.out.println("3. Executar BFS");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarVertice();
                case 2 -> adicionarAresta();
                case 3 -> executarBFS();
                case 0 -> {
                    scanner.close();
                    System.out.println("Programa encerrado.");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Adiciona vértice ao grafo
    public static void adicionarVertice() {
        System.out.print("Digite o nome do vértice: ");
        String vertice = scanner.nextLine();
        grafo.putIfAbsent(vertice, new ArrayList<>());
        System.out.println("Vértice adicionado!");
    }

    // Adiciona aresta entre vértices
    public static void adicionarAresta() {
        System.out.print("Digite o vértice de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Digite o vértice de destino: ");
        String destino = scanner.nextLine();
        grafo.putIfAbsent(origem, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origem).add(destino);
        grafo.get(destino).add(origem);
        System.out.println("Aresta adicionada!");
    }

    // Executa Busca em Largura (BFS)
    public static void executarBFS() {
        System.out.print("Digite o vértice inicial: ");
        String inicio = scanner.nextLine();

        Set<String> visitados = new HashSet<>();
        Queue<String> fila = new LinkedList<>();

        fila.add(inicio);
        visitados.add(inicio);

        System.out.println("\nBFS a partir de " + inicio + ":");
        while (!fila.isEmpty()) {
            String atual = fila.poll();
            System.out.print(atual + " ");

            for (String vizinho : grafo.getOrDefault(atual, new ArrayList<>())) {
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                }
            }
        }
        System.out.println();
    }
    
}