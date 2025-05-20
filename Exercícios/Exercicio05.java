public class Exercicio05 {
    public static void main(String[] args) {

        float[] notas = {7.5f, 9.0f, 8.5f, 9.9f, 6.5f, 5.0f, 8.0f, 9.5f, 7.0f, 6.0f};
        float maior = notas[0];

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i+1) + ": " + notas[i]);
        }

        for (float nota : notas) {
            if (nota > maior) {
                maior = nota;
            }
        }

        System.out.println("Maior nota da turma: " + maior);

    }
}
