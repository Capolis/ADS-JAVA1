import java.util.*;

class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEndereco() { return endereco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}

public class Exercicio09 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Pessoa> clientes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1. Adicionar cliente\n2. Editar cliente\n3. Remover cliente\n4. Listar clientes\n0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    clientes.add(new Pessoa(nome, idade, endereco));
                }
                case 2 -> {
                    System.out.print("Índice do cliente para editar: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    if (idx >= 0 && idx < clientes.size()) {
                        Pessoa p = clientes.get(idx);
                        System.out.print("Novo nome: ");
                        p.setNome(sc.nextLine());
                        System.out.print("Nova idade: ");
                        p.setIdade(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Novo endereço: ");
                        p.setEndereco(sc.nextLine());
                    }
                }
                case 3 -> {
                    System.out.print("Índice do cliente para remover: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < clientes.size()) {
                        clientes.remove(idx);
                        System.out.println("Cliente removido.");
                    }
                }
                case 4 -> {
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i));
                    }
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

}
