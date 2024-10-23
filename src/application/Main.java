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
            logger.info("Digite o nome do funcionário: ");
            String nome = sc.next();

            logger.info("Digite o cargo do funcionário: ");
            String cargo = sc.next();

            logger.info("Digite o salário do funcionário: ");
            Double salario = sc.nextDouble();

            logger.info("Digite a data de admissão do funcionário: (dia/mês/ano)");
            String input = sc.next();
            LocalDate date = LocalDate.parse(input, formato);

            Funcionario novoFuncionario = new Funcionario(i, nome, cargo, salario, date);
            list.adicionarFuncionario(novoFuncionario);
        }

        System.out.println(list.listarFuncionarios());

        sc.close();
    }
}