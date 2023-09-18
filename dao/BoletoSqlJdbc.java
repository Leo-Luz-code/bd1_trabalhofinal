package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Boleto;
import model.entities.Cliente;

public class BoletoSqlJdbc {
    public List<Boleto> getAllBoletos() {
        String sql = "SELECT * FROM Boleto";
        List<Boleto> boletos = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                boletos = new ArrayList<>();
                while (rs.next()) {
                    Boleto b = new Boleto();
                    b.setIdPacote(rs.getInt("idPacote"));
                    b.setIdPagamento(rs.getInt("idPagamento"));
                    b.setCPFCliente(rs.getString("cpfCliente"));
                    b.setValor(rs.getDouble("valor"));
                    b.setDesconto(rs.getDouble("desconto"));
                    b.setStatus(rs.getString("status"));
                    b.setDataPagamento(rs.getDate("dataPagamento"));
                    b.setDataCriacao(rs.getDate("dataCriacao"));
                    b.setCodBarras(rs.getString("codBarras"));
                    boletos.add(b);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boletos;
    }

    @Override
    public void createBoleto(Boleto boleto) {
        String sql = "insert into Boleto (idPacote, dataCriacao, idPagamento, cpfCliente, valor, desconto, status, dataPagamento, codBarras) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, p.getIdPacote());
            pst.setDate(2, p.getDataCriacao());
            pst.setInt(3, p.getIdPagamento());
            pst.setString(4, p.getCPFCliente().toUpperCase());
            pst.setDouble(5, p.getValor());
            pst.setDouble(6, p.getDesconto());
            pst.setString(7, p.getStatus().toUpperCase());
            pst.setDate(8, p.getDataPagamento());
            pst.setString(9, p.getCodBarras());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente readBoleto(String codBarras) {
        String sql = "select * from Boleto where codBarras = ?";
        Boleto boleto = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, codBarras);
            rs = pst.executeQuery();

            if (rs.next()) {
                boleto = new Boleto();
                boleto.setIdPacote(rs.getInt("idPacote"));
                boleto.setIdPagamento(rs.getInt("idPagamento"));
                boleto.setCPFCliente(rs.getString("cpfCliente"));
                boleto.setValor(rs.getDouble("valor"));
                boleto.setDesconto(rs.getDouble("desconto"));
                boleto.setStatus(rs.getString("status"));
                boleto.setDataPagamento(rs.getDate("dataPagamento"));
                boleto.setDataCriacao(rs.getDate("dataCriacao"));
                boleto.setCodBarras(rs.getString("codBarras"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boleto;
    }

    @Override
    public void updateBoleto(Boleto boleto) {
        String sql = "update Boleto set dataPagamento = ?, valor = ?, desconto = ?, status = ?, dataCriacao = ?, cpfCliente = ? where idPagamento = ? and idPacote = ? and codBarras = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setDate(1, boleto.getDataPagamento());
            pst.setDouble(2, boleto.getValor());
            pst.setDouble(3, boleto.getDesconto());
            pst.setString(4, boleto.getStatus().toUpperCase());
            pst.setDate(5, boleto.getDataCriacao());
            pst.setString(6, boleto.getCPFCliente().toUpperCase());
            pst.setInt(7, boleto.getIdPagamento());
            pst.setInt(8, boleto.getIdPacote());
            pst.setString(9, boleto.getCodBarras().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBoleto(Boleto boleto) {
        String sql = "delete from Boleto where codBarras = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setString(1, boleto.getCodBarras());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
