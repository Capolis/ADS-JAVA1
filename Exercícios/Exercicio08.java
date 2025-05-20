import java.util.*;

public class Exercicio08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> frequencia = new HashMap<>();

        System.out.println("Digite códigos dos pedidos (fim com -1):");
        while (true) {
            int codigo = sc.nextInt();
            if (codigo == -1) break;
            frequencia.put(codigo, frequencia.getOrDefault(codigo, 0) + 1);
        }

        int maisFrequente = -1, max = 0;
        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maisFrequente = entry.getKey();
            }
        }

        System.out.println("Pedido mais frequente: " + maisFrequente + " (ocorreu " + max + " vezes)");
        sc.close();
    }
    
}