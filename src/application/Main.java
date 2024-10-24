package application;

import module.entities.Funcionario;
import module.entities.FuncionarioRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(Main.class.getName());

        FuncionarioRepositorio list = new FuncionarioRepositorio();

        logger.info("Quantos funcionários serão cadastrados? ");
        int n = sc.nextInt();

        for (int i=1; i<= n; i++) {
            System.out.print("Digite o nome do funcionário: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Digite o cargo do funcionário: ");
            String cargo = sc.nextLine();

            System.out.print("Digite o salário do funcionário: ");
            Double salario = sc.nextDouble();

            System.out.print("Digite a data de admissão do funcionário: (dia/mês/ano): ");
            String input = sc.next();
            LocalDate date = LocalDate.parse(input, formato);

            Funcionario novoFuncionario = new Funcionario(i, nome, cargo, salario, date);
            list.adicionarFuncionario(novoFuncionario);

            System.out.println("--------------------------");
        }

        logger.info("""
                OPÇÕES: 
                [1] Atualizar dados do funcionário;
                [2] Deletar dados do funcionário;
                [3] Buscar dados de algum funcionário por ID;
                [4] Listar dados de todos funcionários registrados;
                [5] Encerrar sistema;
                
                Digite a sua opção: 
                """);

        int opcao = sc.nextInt();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do funcionário que deseja atualizar: ");
                    int id = sc.nextInt();

                    Funcionario funcionarioExiste = list.buscarFuncionarioPorId(id);

                    if (funcionarioExiste != null) {
                        System.out.print("Novo nome do funcionário: ");
                        sc.nextLine();
                        String atualizaNome = sc.nextLine();

                        System.out.print("Novo cargo do funcionário: ");
                        String atualizaCargo = sc.nextLine();

                        System.out.print("Novo salário do funcionário: ");
                        Double atualizaSalario = sc.nextDouble();

                        list.atualizarFuncionario(id, atualizaNome, atualizaCargo, atualizaSalario);
                    }

                    break;

                case 2:
                    System.out.print("Digite o ID do funcionário que deseja deletar: ");
                    id = sc.nextInt();

                    funcionarioExiste = list.buscarFuncionarioPorId(id);

                    if (funcionarioExiste != null) {
                        list.removerFuncionario(id);
                    }

                    break;

                case 3:
                    System.out.print("Digite o ID do funcionário que deseja encontrar: ");
                    id = sc.nextInt();

                    System.out.println(list.buscarFuncionarioPorId(id));

                    break;

                case 4:
                    System.out.println(list.listarFuncionarios());

                    break;

                default:
                    logger.info("OPCAO INVÁLIDA!");
            }

            logger.info("""
                OPÇÕES: 
                [1] Atualizar dados do funcionário;
                [2] Deletar dados do funcionário;
                [3] Buscar dados de algum funcionário por ID;
                [4] Listar dados de todos funcionários registrados;
                [5] Encerrar sistema;
                
                Digite a sua opção: 
                """);

            opcao = sc.nextInt();
        }

        sc.close();
    }
}