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
            String nome = sc.next();

            System.out.print("Digite o cargo do funcionário: ");
            String cargo = sc.next();

            System.out.print("Digite o salário do funcionário: ");
            Double salario = sc.nextDouble();

            System.out.print("Digite a data de admissão do funcionário: (dia/mês/ano)");
            String input = sc.next();
            LocalDate date = LocalDate.parse(input, formato);

            Funcionario novoFuncionario = new Funcionario(i, nome, cargo, salario, date);
            list.adicionarFuncionario(novoFuncionario);

            System.out.println("--------------------------");
        }
        System.out.println(list.listarFuncionarios());

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

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do funcionário que deseja atualizar: ");
                int id = sc.nextInt();

                System.out.print("Novo nome do funcionário: ");
                String atualizaNome = sc.next();

                System.out.print("Novo cargo do funcionário: ");
                String atualizaCargo = sc.next();

                System.out.print("Novo salário do funcionário: ");
                Double atualizaSalario = sc.nextDouble();

                list.atualizarFuncionario(id, atualizaNome, atualizaCargo, atualizaSalario);

                System.out.println(list.listarFuncionarios());
        }

        sc.close();
    }
}