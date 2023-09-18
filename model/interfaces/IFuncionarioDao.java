// Leonardo Luz
package model.interfaces;

import java.util.List;

import model.entities.Funcionario;

public interface IFuncionarioDao {
    public List<Funcionario> getAllFuncionarios();

    public void createFuncionario(Funcionario funcionario);

    public Funcionario readFuncionario(Long id);

    public void updateFuncionario(Funcionario funcionario);

    public void deleteFuncionario(Funcionario funcionario);
}
