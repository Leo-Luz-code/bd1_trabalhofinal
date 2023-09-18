package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Funcionario;

public class FuncionarioSqlJdbc {
    public List<Funcionario> getAllFuncionarios() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> funcionarios = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                funcionarios = new ArrayList<>();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("if_func"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEmail(rs.getString("email"));
                    f.setTelefone(rs.getString("telefone"));
                    f.setIdGerente(rs.getInt("id_gerente"));
                    funcionarios.add(f);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public List<Funcionario> getAllGerentes() {
        String sql = "SELECT * FROM funcionario  WHERE ";
        List<Funcionario> funcionarios = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                funcionarios = new ArrayList<>();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("idFuncionario"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEmail(rs.getString("email"));
                    f.setTelefone(rs.getString("telefone"));
                    f.setIdGerente(rs.getInt("id_gerente"));
                    funcionarios.add(f);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public void createFuncionario(Funcionario funcionario) {
        String sql = "insert into funcionario (id_func, nome, email) values (?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, funcionario.getIdFuncionario());
            pst.setString(2, funcionario.getNome().toUpperCase());
            pst.setString(3, funcionario.getEmail().toUpperCase());

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario readFuncionario(int idFuncionario) {
        String sql = "select * from Funcionario where id_func = ?";
        Funcionario funcionario = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idFuncionario);
            rs = pst.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public void updateFuncionario(Funcionario funcionario) {
        String sql = "update Funcionario set nome = ?, email = ? where idFuncionario = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, funcionario.getNome().toUpperCase());
            pst.setString(2, funcionario.getEmail().toUpperCase());
            pst.setInt(3, funcionario.getIdFuncionario());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFuncionario(Funcionario funcionario) {
        String sql = "delete from Funcionario where idFuncionario = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, funcionario.getIdFuncionario());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
