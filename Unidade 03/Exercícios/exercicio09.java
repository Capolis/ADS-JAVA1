import java.util.*;

public class exercicio09 {
    static class Aresta {
        int destino, peso;

        Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    static class Grafo {
        List<List<Aresta>> adjacencias;

        Grafo(int vertices) {
            adjacencias = new ArrayList<>();
            for (int i = 0; i < vertices; i++) adjacencias.add(new ArrayList<>());
        }

        void adicionarAresta(int origem, int destino, int peso) {
            adjacencias.get(origem).add(new Aresta(destino, peso));
            adjacencias.get(destino).add(new Aresta(origem, peso)); // bidirecional
        }

        void dijkstra(int inicio, int fim) {
            int[] dist = new int[adjacencias.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[inicio] = 0;

            PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            fila.add(new int[]{inicio, 0});

            while (!fila.isEmpty()) {
                int[] atual = fila.poll();
                int u = atual[0];

                for (Aresta aresta : adjacencias.get(u)) {
                    int v = aresta.destino;
                    int peso = aresta.peso;

                    if (dist[u] + peso < dist[v]) {
                        dist[v] = dist[u] + peso;
                        fila.add(new int[]{v, dist[v]});
                    }
                }
            }

            if (dist[fim] == Integer.MAX_VALUE) {
                System.out.println("Não há caminho entre os vértices.");
            } else {
                System.out.println("Distância mínima entre " + inicio + " e " + fim + ": " + dist[fim]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de vértices: ");
        int n = scanner.nextInt();
        Grafo grafo = new Grafo(n);

        int opcao;
        do {
            System.out.println("\n=== Exercício 09: Caminho mais curto ===");
            System.out.println("1. Adicionar aresta");
            System.out.println("2. Encontrar caminho mais curto");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Peso: ");
                    int peso = scanner.nextInt();
                    grafo.adicionarAresta(origem, destino, peso);
                    break;
                case 2:
                    System.out.print("Início: ");
                    int inicio = scanner.nextInt();
                    System.out.print("Fim: ");
                    int fim = scanner.nextInt();
                    grafo.dijkstra(inicio, fim);
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