import java.util.*;

class Produto {
    private String nome;
    private int quantidade;
    private float preco;

    public Produto(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setPreco(float preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Quantidade: " + quantidade + ", Preço: R$" + preco;
    }
}

class Estoque {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        System.out.print("Preço: ");
        float preco = sc.nextFloat();
        sc.nextLine();
        produtos.add(new Produto(nome, qtd, preco));
    }

    public void removerProduto(Scanner sc) {
        listarProdutos();
        System.out.print("Índice do produto a remover: ");
        int idx = sc.nextInt();
        sc.nextLine();
        if (idx >= 0 && idx < produtos.size()) {
            produtos.remove(idx);
            System.out.println("Produto removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void atualizarProduto(Scanner sc) {
        listarProdutos();
        System.out.print("Índice do produto a atualizar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        if (idx >= 0 && idx < produtos.size()) {
            Produto p = produtos.get(idx);
            System.out.print("Novo nome: ");
            p.setNome(sc.nextLine());
            System.out.print("Nova quantidade: ");
            p.setQuantidade(sc.nextInt());
            System.out.print("Novo preço: ");
            p.setPreco(sc.nextFloat());
            sc.nextLine();
        }
    }

    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(i + " - " + produtos.get(i));
        }
    }
}

public class Exercicio10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        int opcao;

        do {
            System.out.println("\n1. Adicionar produto\n2. Remover produto\n3. Atualizar produto\n4. Listar produtos\n0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> estoque.adicionarProduto(sc);
                case 2 -> estoque.removerProduto(sc);
                case 3 -> estoque.atualizarProduto(sc);
                case 4 -> estoque.listarProdutos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

}
