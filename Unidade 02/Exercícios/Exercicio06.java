// Exercício 6: Implementação de um Sistema de Fila de Espera
// Extensão compatível: .txt (um paciente por linha)
import java.io.*;
import java.util.*;

public class Exercicio06 {
    static Queue<String> fila = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        int opcao;
        do {
            System.out.println("\n=== Sistema de Fila de Espera da Clínica ===");
            System.out.println("1 - Adicionar pacientes manualmente");
            System.out.println("2 - Carregar pacientes de um arquivo (.txt)");
            System.out.println("3 - Exibir fila de pacientes");
            System.out.println("4 - Atender próximo paciente");
            System.out.println("5 - Excluir próximo paciente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPacientesManualmente();
                    break;
                case 2:
                    carregarPacientesDeArquivo();
                    break;
                case 3:
                    exibirFila();
                    break;
                case 4:
                    removerPaciente(false); // Atender paciente
                    break;
                case 5:
                    removerPaciente(true); // Remover paciente
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void adicionarPacientesManualmente() {
        System.out.print("Quantos pacientes deseja adicionar? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do paciente " + (i + 1) + ": ");
            fila.add(scanner.nextLine());
        }
    }

    public static void carregarPacientesDeArquivo() throws IOException {
        System.out.print("Informe o caminho do arquivo .txt: ");
        String caminho = scanner.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linha;
            int contador = 0;
            while ((linha = br.readLine()) != null) {
                fila.add(linha);
                contador++;
            }
            br.close();
            System.out.println("Pacientes carregados: " + contador);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("Sem pacientes aguardando, momento para ir beber aguá :)");
        } else {
            System.out.println("\nFila de pacientes:");
            int pos = 1;
            for (String paciente : fila) {
                System.out.println(pos++ + ". " + paciente);
            }
        }
    }

    public static void removerPaciente(boolean detalhe){
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente para atender.");
        } else {
            String atendido = fila.poll();
            if(detalhe){
                System.out.println("Paciente removido: " + atendido);
            } else {
                System.out.println("Paciente atendido: " + atendido);
            }
        }
    }
}