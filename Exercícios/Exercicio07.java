import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];
        String jogador1, jogador2;
        int jogadas = 0;
        String atual;

        // Interface inicial
        System.out.println("Mapa das posições (use os números abaixo para jogar):");
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + num + "]");
                num++;
            }
            System.out.println();
        }

        System.out.print("Digite o nome do Jogador 1 (X): ");
        jogador1 = sc.nextLine();
        System.out.print("Digite o nome do Jogador 2 (O): ");
        jogador2 = sc.nextLine();

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tabuleiro[i][j] = " ";

        boolean venceu = false;

        do {
            atual = (jogadas % 2 == 0) ? "X" : "O";
            String nome = (atual.equals("X")) ? jogador1 : jogador2;

            int posicao;
            do {
                System.out.print(nome + " (" + atual + "), escolha uma posição (1 a 9): ");
                posicao = sc.nextInt();
            } while (posicao < 1 || posicao > 9 || !tabuleiro[(posicao - 1) / 3][(posicao - 1) % 3].equals(" "));

            tabuleiro[(posicao - 1) / 3][(posicao - 1) % 3] = atual;
            jogadas++;

            // Mostrar tabuleiro atualizado
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("[" + tabuleiro[i][j] + "]");
                }
                System.out.println();
            }

            // Verificar vitória
            venceu = verificaVencedor(tabuleiro, atual);

        } while (!venceu && jogadas < 9);

        if (venceu) {
            String vencedor = (atual.equals("X")) ? jogador1 : jogador2;
            System.out.println("Parabéns, " + vencedor + "! Você venceu!");
        } else {
            System.out.println("Empate!");
        }

        sc.close();
    }

    public static boolean verificaVencedor(String[][] t, String simb) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0].equals(simb) && t[i][1].equals(simb) && t[i][2].equals(simb)) return true;
            if (t[0][i].equals(simb) && t[1][i].equals(simb) && t[2][i].equals(simb)) return true;
        }
        return (t[0][0].equals(simb) && t[1][1].equals(simb) && t[2][2].equals(simb)) ||
               (t[0][2].equals(simb) && t[1][1].equals(simb) && t[2][0].equals(simb));
    }
}
