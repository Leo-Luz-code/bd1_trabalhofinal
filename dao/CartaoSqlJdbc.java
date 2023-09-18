package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cartao;

public class CartaoSqlJdbc {
     public List<Cartao> getAllCartoes() {
        String sql = "SELECT * FROM Cartao";
        List <Cartao> cartoes = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                cartoes = new ArrayList<>();
                while (rs.next()) {
                    Cartao ca = new Cartao();
                    ca.setIdPacote (rs.getInt("idPacote"));
                    ca.setIdPagamento(rs.getInt("idPagamento"));
                    ca.setCPFCliente(rs.getString ("cpfCliente"));
                    ca.setValor(rs.getDouble ("valor"));
                    ca.setDesconto(rs.getDouble("desconto"));
                    ca.setStatus(rs.getString("status"));
                    ca.setDataPagamento (rs.getDate("dataPagamento"));
                    ca.setDataCriacao(rs.getDate("dataCriacao"));
                    ca.setNumCartao(rs.getString("numCartao"));
                    cartao.add(ca);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartoes;
    }

    @Override
    public void createCartao (Cartao cartao) {
        String sql = "insert into Cartao (idPacote, dataCriacao, idPagamento, cpfCliente, valor, desconto, status, dataPagamento, numCartao) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, cartao.getIdPacote());
            pst.setDate(2, cartao.getDataCriacao());
            pst.setInt (3, cartao.getIdPagamento());
            pst.setString (4, cartao.getCPFCliente().toUpperCase());
            pst.setDouble (5, cartao.getValor());
            pst.setDouble (6, cartao.getDesconto());
            pst.setString(7, cartao.getStatus().toUpperCase());
            pst.setDate (8, cartao.getDataPagamento());
            pst.setString (9, cartao.getNumCartao());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cartao readCartao (String numCartao) {
        String sql = "select * from Cliente where idCliente = ?";
        Cartao cartao = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setString(1, numCartao);
            rs = pst.executeQuery();

            if (rs.next()) {
                cartao = new Cartao();
                cartao.setIdPacote (rs.getInt("idPacote"));
                cartao.setIdPagamento(rs.getInt("idPagamento"));
                cartao.setCPFCliente(rs.getString ("cpfCliente"));
                cartao.setValor(rs.getDouble ("valor"));
                cartao.setDesconto(rs.getDouble("desconto"));
                cartao.setStatus(rs.getString("status"));
                cartao.setDataPagamento (rs.getDate("dataPagamento"));
                cartao.setDataCriacao(rs.getDate("dataCriacao"));
                cartao.setNumCartao(rs.getString("numCartao"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartao;
    }

    @Override
    public void updateCartao (Cartao cartao) {
        String sql = "update Boleto set dataPagamento = ?, valor = ?, desconto = ?, status = ?, dataCriacao = ?, cpfCliente = ? where idPagamento = ? and idPacote = ? and numCartao = ?";;

        try (Connection connection = new ConnectionTravel().getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setDate(1, boleto.getDataPagamento());
            pst.setDouble(2, boleto.getValor());
            pst.setDouble(3, boleto.getDesconto());
            pst.setString (4, boleto.getStatus().toUpperCase());
            pst.setDate (5, boleto.getDataCriacao());
            pst.setString (6, boleto.getCPFCliente().toUpperCase());
            pst.setInt (7, boleto.getIdPagamento());
            pst.setInt (8, boleto.getIdPacote());
            pst.setString (9, boleto.getNumCartao().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartao (Cartao cartao) {
        String sql = "delete from Cartao where numCartao = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, cartao.getNumCartao());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
