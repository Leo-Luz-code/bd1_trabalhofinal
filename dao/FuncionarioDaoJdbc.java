// Leonardo Luz
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Funcionario;
import model.interfaces.IFuncionarioDao;

public class FuncionarioDaoJdbc implements IFuncionarioDao {

    @Override
    public List<Funcionario> getAllFuncionarios() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> cidades = null;

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                cidades = new ArrayList<>();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCpf(rs.getString("cpf"));
                    f.setEmail(rs.getString("email"));
                    f.setIdGerente(rs.getInt("id_gerente"));
                    f.setTelefone(rs.getString("telefone"));
                    cidades.add(f);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    @Override
    public void createFuncionario(Funcionario funcionario) {
        String sql = "insert into funcionario (nome, email, cpf, telefone, id_gerente) values (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, funcionario.getNome().toUpperCase());
            pst.setString(2, funcionario.getEmail().toUpperCase());
            pst.setString(3, funcionario.getCpf().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cidade readCidade(Long id) {
        String sql = "select * from cidade where id = ?";
        Cidade cidade = null;
        ResultSet rs;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setLong(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getLong("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setPais(rs.getString("pais"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidade;
    }

    @Override
    public void updateCidade(Cidade cidade) {
        String sql = "update cidade set nome = ?, pais = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, cidade.getNome().toUpperCase());
            pst.setString(2, cidade.getPais().toUpperCase());
            pst.setLong(3, cidade.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCidade(Cidade cidade) {
        String sql = "delete from cidade where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setLong(1, cidade.getId());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
