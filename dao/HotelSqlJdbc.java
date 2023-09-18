package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Hotel;

public class HotelSqlJdbc {
    public List<Hotel> getAllHoteis() {
        String sql = "SELECT * FROM hotel";
        List<Hotel> hoteis = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                hoteis = new ArrayList<>();
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setIdHotel(rs.getInt("id_hotel"));
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    h.setEstado(rs.getString("estado"));
                    h.setCnpj(rs.getString("cnpj"));
                    hoteis.add(h);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoteis;
    }

    public void createHotel(Hotel hotel) {
        String sql = "insert into Hotel (idHotel, nome, cidade, estado, cnpj) values (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, hotel.getIdHotel());
            pst.setString(2, hotel.getNome().toUpperCase());
            pst.setString(3, hotel.getCidade().toUpperCase());
            pst.setString(4, hotel.getEstado().toUpperCase());
            pst.setString(5, hotel.getCnpj().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hotel readHotel(int idHotel) {
        String sql = "select * from Hotel where idHotel = ?";
        Hotel hotel = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idHotel);
            rs = pst.executeQuery();

            if (rs.next()) {
                hotel = new Hotel();
                hotel.setIdHotel(rs.getInt("id_hotel"));
                hotel.setNome(rs.getString("nome"));
                hotel.setCidade(rs.getString("cidade"));
                hotel.setEstado(rs.getString("estado"));
                hotel.setCnpj(rs.getString("cnpj"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public void updateHotel(Hotel hotel) {
        String sql = "update Hotel set nome = ?, cidade = ?, estado = ?, cnpj = ? where idHotel = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, hotel.getNome().toUpperCase());
            pst.setString(2, hotel.getCidade().toUpperCase());
            pst.setString(3, hotel.getEstado().toUpperCase());
            pst.setString(4, hotel.getCnpj().toUpperCase());
            pst.setInt(5, hotel.getIdHotel());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHotel(Hotel hotel) {
        String sql = "delete from Hotel where idHotel = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, hotel.getIdHotel());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
