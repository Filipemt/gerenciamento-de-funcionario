package module.entities;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio {

    private List<Funcionario> funcionarioList = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioList.add(funcionario);
    }

    public void atualizarFuncionario(int id, String nome, String cargo, Double salario) {
        boolean encontrado = false;

        for (Funcionario funcionario : funcionarioList) {
            if (funcionario.getId() == id) {
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
                encontrado = true;

                break;
            }
        }
        if (!encontrado) {
            System.out.println("Não existe funcionário com este Id");
        }
    }

    public void removerFuncionario(int id) {
        funcionarioList.removeIf(funcionario -> funcionario.getId() == id);

    }

    public Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionarioList) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }

        System.out.println("Não existe funcionário com esse ID!");
        return null;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioList;
    }
}
