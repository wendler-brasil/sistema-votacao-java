import java.util.Scanner;

public class SistemaVotacao {

    //variáveis """"globais""""
    static Scanner scan = new Scanner(System.in);
    static final int MAX_CANDIDATOS = 5;
    static final int TOTAL_TURMAS = 3;
    static final int MAX_VOTANTES_POR_TURMA = 10;

    //matrizes
    static int[] numerosCandidatos = new int[MAX_CANDIDATOS];
    static String[] nomesCandidatos = new String[MAX_CANDIDATOS];
    static int[] votosCandidatos = new int[MAX_CANDIDATOS];

    static int[][] votosPorTurma = new int[TOTAL_TURMAS][MAX_VOTANTES_POR_TURMA];

    static int[] quantidadeVotosTruma = new int[TOTAL_TURMAS];
    static int quantidadeCandidatos = 0;

    // -------- | --------- | --------


    public static void main(String[] args) {

        int opcao;

//Menu principal

        do {
            System.out.println();
            System.out.println("""
                     --------------------------------
                    |       SISTEMA DE VOTAÇÃO       |
                     --------------------------------""");
            System.out.println("\n 1 - Cadastrar candidatos");
            System.out.println("2 - Iniciar votação");
            System.out.println("3 - Exibir resultado");
            System.out.println("4 - Exibir matriz de votos");
            System.out.println("5 - Sair");


            opcao = lerInteiro("\n Escolha uma opção: ");
            System.out.println();


            switch (opcao) {

                case 1:
                    System.out.println("Cadastro selecionado");
                    cadastro();
                    break;
                case 2:
                    System.out.println("Votação selecionado");
                    break;
                case 3:
                    System.out.println("Resultado selecionado");
                    break;
                case 4:
                    System.out.println("Matriz selecionada");
                    break;
                case 5:
                    System.out.println("Sistema encerrado");
                    break;
                default:
                    System.out.println("Não há essa opção");

            }

        } while (opcao != 5);


    }

    static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scan.hasNextInt()) {
                int valor = scan.nextInt();
                scan.nextLine();
                return valor;
            }
            System.out.println("Entrada inválida. Digite um número.");
            scan.nextLine();
        }
    }

    static void cadastro() {

       do {
            //Definir quantos candidatos serão cadastrados
            quantidadeCandidatos = lerInteiro("Informe quantos candidatos serão cadastrados: ");

            if (quantidadeCandidatos < 1 || quantidadeCandidatos > MAX_CANDIDATOS) {
                System.out.print("\n O máximo de candidatos é 5 e o mínimo é 1 \n");
                return;
            }
            System.out.println("Ok ");
        } while (quantidadeCandidatos < 1 || quantidadeCandidatos > MAX_CANDIDATOS);


    }


    }


