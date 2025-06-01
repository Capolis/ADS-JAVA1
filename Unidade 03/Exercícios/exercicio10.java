import java.util.*;

public class exercicio10 {
    static class Grafo {
        int V;
        List<List<Integer>> adj;

        Grafo(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        }

        void adicionarAresta(int origem, int destino) {
            adj.get(origem).add(destino);
        }

        void ordenacaoTopologica() {
            int[] grauEntrada = new int[V];
            for (List<Integer> lista : adj) {
                for (int destino : lista) grauEntrada[destino]++;
            }

            Queue<Integer> fila = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (grauEntrada[i] == 0) fila.add(i);
            }

            List<Integer> resultado = new ArrayList<>();
            while (!fila.isEmpty()) {
                int u = fila.poll();
                resultado.add(u);

                for (int vizinho : adj.get(u)) {
                    grauEntrada[vizinho]--;
                    if (grauEntrada[vizinho] == 0) fila.add(vizinho);
                }
            }

            if (resultado.size() != V) {
                System.out.println("O grafo contém ciclos e não pode ser ordenado topologicamente.");
            } else {
                System.out.println("Ordenação topológica: " + resultado);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de vértices: ");
        int V = scanner.nextInt();
        Grafo grafo = new Grafo(V);
        int opcao;

        do {
            System.out.println("\n=== Exercício 10: Ordenação Topológica ===");
            System.out.println("1. Adicionar aresta");
            System.out.println("2. Executar ordenação topológica");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Destino: ");
                    int destino = scanner.nextInt();
                    grafo.adicionarAresta(origem, destino);
                    break;
                case 2:
                    grafo.ordenacaoTopologica();
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