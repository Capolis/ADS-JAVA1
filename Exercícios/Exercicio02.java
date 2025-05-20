import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int codigo;
        String continuar;

        do {
            System.out.print("Digite o código do produto: ");
            codigo = sc.nextInt();

            if (codigo % 2 == 0) {
                System.out.println("O código é PAR.");
            } else {
                System.out.println("O código é ÍMPAR.");
            }

            System.out.print("Deseja verificar outro produto? (s/n): ");
            continuar = sc.next();
        } while (continuar.equalsIgnoreCase("s"));

        sc.close();
    }
}