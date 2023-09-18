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
                    f.setIdFuncionario(rs.getInt("id_func"));
                    f.setNome(rs.getString("nome"));
                    f.setNome(rs.getString("email"));
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
        String sql = "SELECT * FROM funcionario WHERE id";
        List<Funcionario> funcionarios = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                funcionarios = new ArrayList<>();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("id_func"));
                    f.setNome(rs.getString("nome"));
                    f.setEmail(rs.getString("email"));
                    f.setIdGerente(rs.getInt("id_gerente"));
                    funcionarios.add(f);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public void createFuncionarioSemGerente(Funcionario funcionario) {
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

    public void createFuncionarioComGerente(Funcionario funcionario) {
        String sql = "insert into funcionario (id_func, nome, email, id_gerente) values (?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, funcionario.getIdFuncionario());
            pst.setString(2, funcionario.getNome().toUpperCase());
            pst.setString(3, funcionario.getEmail().toUpperCase());
            pst.setInt(4, funcionario.getIdGerente());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario readFuncionario(int idFuncionario) {
        String sql = "select * from funcionario where id_func = ?";
        Funcionario funcionario = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idFuncionario);
            rs = pst.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_func"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setIdGerente(rs.getInt("id_gerente"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public void updateFuncionario(Funcionario funcionario) {
        String sql = "update funcionario set nome = ?, email = ?, id_gerente = ? where id_func = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, funcionario.getNome().toUpperCase());
            pst.setString(2, funcionario.getEmail().toUpperCase());
            pst.setInt(3, funcionario.getIdGerente());
            pst.setInt(4, funcionario.getIdFuncionario());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFuncionario(Funcionario funcionario) {
        String sql = "delete from funcionario where id_func = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, funcionario.getIdFuncionario());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
