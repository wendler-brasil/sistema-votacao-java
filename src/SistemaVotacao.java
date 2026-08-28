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
                    cadastrarCandidatos();
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

    static void cadastrarCandidatos() {


        int quantidade;

        do {
            //Definir quantos candidatos serão cadastrados
            quantidade = lerInteiro("Quantidade de candidatos entre 1 e 5: ");

            if (quantidade < 1 || quantidade > MAX_CANDIDATOS) {
                System.out.print("\n Quantidade inválida  \n");
                return;
            }
            System.out.println("Ok ");
        } while (quantidade < 1 || quantidade > MAX_CANDIDATOS);

        for (int i = 0; i < quantidade; i++) {

            int numero;

            while (true) {
                numero = lerInteiro("\n numero do candidato " + (i + 1) + " :");
                if (numero <= 0) {
                    System.out.println("O número deve ser maior que zero.");
                    continue;

                }

                boolean numeroRepetido = false;
                for (int j = 0; j < i; j++) {
                    if (numerosCandidatos[j] == numero) {
                        numeroRepetido = true;
                        break;
                    }
                }
                if (numeroRepetido) {
                    System.out.println("ESse número ja está cadastrado.");
                    continue;
                }
                break;
            }

            //Ler e armazenar o nome
            String nome;

            do {
                System.out.print("Nome do candidato: ");
                nome = scan.nextLine().trim();

                if (nome.isEmpty()) {
                    System.out.println("O nome não pode ficar vazio.");
                }

            } while (nome.isEmpty());

            numerosCandidatos[i] = numero;
            nomesCandidatos[i] = nome;
            votosCandidatos[i] = 0;
            quantidadeCandidatos++;


        }

    }

    //Procurar candidato pelo número
    static int buscarCandidato(int numero) {
        int indiceEncontrado = -1;

        for (int i = 0; i < quantidadeCandidatos; i++) {
            if (numerosCandidatos[i] == numero) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    //Mostrar os candidatos disponíveis
    static void mostrarCandidatos() {
        System.out.println("\nCandidatos disponíveis: ");

        for (int i = 0; i < quantidadeCandidatos; i++) {
            System.out.println(
                    numerosCandidatos[i] + " - " + nomesCandidatos[i]
            );
        }

    }

    static void escolherTurma() {
        int turma;
        do {
            turma = lerInteiro("Informe a turma de 1 a 3: ");

            if (turma < 1 || turma > TOTAL_TURMAS) System.out.println("Turma inválida");

        }while(turma < 1 || turma > TOTAL_TURMAS);

        int indiceTurma = turma -1;




    }

}





