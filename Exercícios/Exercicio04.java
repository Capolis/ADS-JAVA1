import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaEspera = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    listaEspera.add(nome);
                    break;
                case 2:
                    System.out.print("Nome para remover: ");
                    String remover = sc.nextLine();
                    listaEspera.remove(remover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.println("Lista de Espera: " + listaEspera);
        } while (opcao != 0);

        sc.close();
    }

}
