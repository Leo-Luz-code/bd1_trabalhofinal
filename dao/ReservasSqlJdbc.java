package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reservas;

public class ReservasSqlJdbc {
     public List <Reservas> getAllReservas() {
        String sql = "SELECT * FROM Reservas";
        List <Reservas> reservas = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                reservas = new ArrayList<>();
                while (rs.next()) {
                    Reservas rs = new Reservas();
                    rs.setIdCliente(rs.getInt("idCliente"));
                    rs.setIdAtendimento(rs.getInt("idAtendimento"));
                    rs.setEmail(rs.getString ("email"));
                    rs.setTelefone(rs.getDate ("telefone"));
                    rs.setNome(rs.getString("nome"));
                    rs.setCpf(rs.getString("cpf"));
                    rs.setDataAtendimento (rs.getDate("dataAtendimento"));
                    reservass.add(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    @Override
    public void createReservas (Reservas rs) {
        String sql = "insert into Reservas (idCliente, nome, cpf) values (?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, rs.getIdCliente().toUpperCase());
            pst.setString(2, rs.getNome().toUpperCase());
            pst.setString (3, rs.getCpf().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente readReservas (int idReserva) {
        String sql = "select * from Reserva where idReserva = ?";
        Reservas reservas = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idReserva);
            rs = pst.executeQuery();

            if (rs.next()) {
                reservas = new Reservas();
                reservas.setIdCliente(rs.getInt("idCliente"));
                reservas.setNome(rs.getString("nome"));
                reservas.setCpf(rs.getString("cpf"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public void updateReservas (Reservas reservas) {
        String sql = "update Reservas set nome = ?, cpf = ? where idReserva = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, reservas.getNome().toUpperCase());
            pst.setString(2, reservas.getCpf().toUpperCase());
            pst.setLong(3, reservas.getIdCliente().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservas (Reservas reservas) {
        String sql = "delete from Reservas where idReserva = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, reservas.getIdReserva());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
