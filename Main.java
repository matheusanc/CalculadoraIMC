import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaIMC sistema = new SistemaIMC();
    private static Pessoa ultimaPessoaCadastrada = null;

    public static void main(String[] args) {
        int opcao = -1;

        System.out.println("=============================================");
        System.out.println("   BEM-VINDO À CALCULADORA DE IMC PROFISSIONAL");
        System.out.println("=============================================");

        while (opcao != 0) {
            try {
                exibirMenu();
                opcao = lerInt("Sua opção");

                switch (opcao) {
                    case 1:
                        cadastrarPessoaComum();
                        break;
                    case 2:
                        cadastrarAtleta();
                        break;
                    case 3:
                        calcularIMCUltimaPessoa();
                        break;
                    case 4:
                        sistema.exibirHistorico();
                        break;
                    case 0:
                        System.out.println("\nEncerrando o sistema. Até logo!");
                        break;
                    default:
                        throw new EntradaInvalidaException("Opção inválida! Escolha um número do menu [0-4].");
                }
            } catch (EntradaInvalidaException e) {
                System.out.println("\n⚠️ ERRO DE VALIDAÇÃO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n⚠️ ERRO INESPERADO: " + e.getMessage());
            }
            CalculadoraRecursiva.imprimirDivisor();
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n[1] Cadastrar Pessoa Comum");
        System.out.println("[2] Cadastrar Atleta");
        System.out.println("[3] Calcular e Exibir IMC (Último cadastro)");
        System.out.println("[4] Exibir Histórico de Cálculos");
        System.out.println("[0] Encerrar o Sistema");
    }

    private static void cadastrarPessoaComum() {
        System.out.println("\n--- Cadastro de Pessoa Comum ---");
        String nome = lerString("Nome");
        int idade = lerInt("Idade");
        double peso = lerDouble("Peso (kg)");
        double altura = lerDouble("Altura (m)");

        ultimaPessoaCadastrada = new Pessoa(nome, idade, peso, altura);
        System.out.println("✔️ Pessoa cadastrada com sucesso!");
    }

    private static void cadastrarAtleta() {
        System.out.println("\n--- Cadastro de Atleta ---");
        String nome = lerString("Nome");
        int idade = lerInt("Idade");
        double peso = lerDouble("Peso (kg)");
        double altura = lerDouble("Altura (m)");
        String modalidade = lerString("Modalidade Esportiva");

        // Polimorfismo de referência: Atleta encapsulado em referência de Pessoa
        ultimaPessoaCadastrada = new Atleta(nome, idade, peso, altura, modalidade);
        System.out.println("✔️ Atleta cadastrado com sucesso!");
    }

    private static void calcularIMCUltimaPessoa() {
        if (ultimaPessoaCadastrada == null) {
            throw new EntradaInvalidaException("Nenhuma pessoa ou atleta foi cadastrado ainda nesta sessão!");
        }
        sistema.processar(ultimaPessoaCadastrada);
    }

    // Métodos Auxiliares robustos para Entrada de Dados (Mecanismos de Captura e Proteção)
    private static String lerString(String campo) {
        System.out.print(campo + ": ");
        String valor = scanner.nextLine().trim();
        if (valor.isEmpty()) {
            throw new EntradaInvalidaException(campo + " não pode ficar em branco.");
        }
        return valor;
    }

    private static int lerInt(String campo) {
        System.out.print(campo + ": ");
        try {
            int valor = scanner.nextInt();
            scanner.nextLine(); // Limpeza do buffer
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpeza do buffer em caso de erro
            throw new EntradaInvalidaException("O campo " + campo + " deve ser um número inteiro válido.");
        }
    }

    private static double lerDouble(String campo) {
        System.out.print(campo + ": ");
        try {
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpeza do buffer
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpeza do buffer em caso de erro
            throw new EntradaInvalidaException("O campo " + campo + " deve ser um número decimal válido (Use vírgula ou ponto dependendo do SO).");
        }
    }
}
