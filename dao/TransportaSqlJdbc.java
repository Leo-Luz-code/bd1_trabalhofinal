package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Transporta;

public class TransportaSqlJdbc {
     public List <Transporta> getAllTransportas {
        List <Transporta> transportas = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                transportas = new ArrayList<>();
                while (rs.next()) {
                    Transporta t = new Transporta();
                    t.setIdViagem(rs.getInt ("idViagem"));
                    t.setDataViagem(rs.getDate("dataViagem"));
                    t.setCheck_in(rs.getDate("check_in"));
                    t.setValor (rs.getDouble ("valor"));
                    t.setMeioTransporte (rs.getString("meioTransporte"));
                    transportas.add(t);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transportas;
    }

    @Override
    public void createTransporta (Transporta t) {
        String sql = "insert into Transporta (idViagem, dataViagem, check_in, valor, meioTransporte) values (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, t.getIdViagem().toUpperCase());
            pst.setDate(2, t.getDataViagem().toUpperCase());
            pst.setDate (3, t.getCheck_in().toUpperCase());
            pst.setDouble (4, t.getValor().toUpperCase());
            pst.setString (5, t.getMeioTransporte().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente readTransporta (int idViagem) {
        String sql = "select * from Transporta where idViagem = ?";
        Transporta t = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idViagem);
            rs = pst.executeQuery();

            if (rs.next()) {
                t = new Transporta();
                t.setIdViagem(rs.getInt("idViagem"));
                t.setDataViagem(rs.getDate("dataViagem"));
                t.setCheck_in(rs.getDate("check_in"));
                t.setValor(rs.getDouble("valor"));
                t.setMeioTransporte(rs.getString("meioTransporte"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void updateTransporte (Transporta t) {
        String sql = "update Transporta set dataViagem = ?, check_in = ?, valor = ?, meioTransporte = ? where idViagem = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setDate(1, t.getDataViagem());
            pst.setDate(2, t.getCheck_in());
            pst.setDouble (3, t.getValor());
            pst.setString (4, t.getMeioTransporte().toUpperCase());
            pst.setInt(5, t.getIdViagem());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransporta (Transporta t) {
        String sql = "delete from Transporta where idViagem = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, t.getIdViagem());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
