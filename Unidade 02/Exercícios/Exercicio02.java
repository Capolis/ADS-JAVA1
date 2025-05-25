// Exercício 2: Remoção de Elementos Duplicados
// Extensão compatível: .txt (um nome de contato por linha)
import java.io.*;
import java.util.*;

public class Exercicio02 {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> contatos = new ArrayList<>();
        boolean carregadoDeArquivo = false;
        String caminho = "";
        int opcao;

        do {
            System.out.println("\n=== Remoção de Contatos Duplicados ===");
            System.out.println("1 - Adicionar contatos manualmente");
            System.out.println("2 - Carregar contatos de um arquivo (.txt)");
            System.out.println("3 - Remover duplicatas e exibir lista");
            System.out.println("4 - Exibir lista");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Quantos contatos deseja adicionar? ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite o nome do contato " + (i + 1) + ": ");
                        contatos.add(scanner.nextLine());
                    }
                    carregadoDeArquivo = false;
                    break;
                case 2:
                    System.out.print("Informe o caminho do arquivo .txt: ");
                    caminho = scanner.nextLine();
                    contatos = lerContatosDeArquivo(caminho);
                    carregadoDeArquivo = true;
                    break;
                case 3:
                    contatos = removerDuplicatas(contatos);
                    System.out.print("Deseja salvar a lista sem duplicatas em um arquivo? (s/n): ");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        String caminhoSalvar;
                        if (carregadoDeArquivo) {
                            System.out.print("Deseja sobrescrever o arquivo original? (s/n): ");
                            String sobrescrever = scanner.nextLine();
                            if (sobrescrever.equalsIgnoreCase("s")) {
                                salvarContatos(contatos, caminho);
                            } else {
                                System.out.print("Informe o nome do novo arquivo: ");
                                caminhoSalvar = scanner.nextLine();
                                salvarContatos(contatos, caminhoSalvar);
                            }
                        } else {
                            System.out.print("Informe o nome do novo arquivo: ");
                            caminhoSalvar = scanner.nextLine();
                            salvarContatos(contatos, caminhoSalvar);
                    } 
                    } else {
                        System.out.println("Lista não salva.");
                    }
                    break;
                case 4:
                    mostrarLista(contatos);
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static List<String> removerDuplicatas(List<String> contatos) {
        Set<String> unicos = new LinkedHashSet<>(contatos);
        System.out.println("\nLista final sem duplicatas:");
        for (String nome : unicos) {
            System.out.println(nome);
        }
        return new ArrayList<>(unicos);
    }

    public static void mostrarLista(List<String> contatos) {
        
        if(!contatos.isEmpty()) {
            System.out.println("\nLista:");
            for (String nome : contatos) {
                System.out.println(nome);
            }
            System.out.println("Total de contatos: " + contatos.size());
        } 
        
        else {
            System.out.println("\nSem contatos, que triste :/");
        }
    }

    public static List<String> lerContatosDeArquivo(String caminho) throws IOException {
        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
        String linha;
        while ((linha = br.readLine()) != null) {
            lista.add(linha);
        }
        System.out.println("Arquivo lido com sucesso!");
        System.out.println("Contatos carregados: " + lista.size());
        br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarContatos(List<String> contatos, String caminhoSalvar) throws IOException {
        if (!caminhoSalvar.endsWith(".txt")) {
            caminhoSalvar += ".txt";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSalvar))) {
            for (String nome : contatos) {
                bw.write(nome);
                bw.newLine();
            }
            bw.close();
            System.out.println("Arquivo salvo com sucesso em: " + caminhoSalvar);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

}