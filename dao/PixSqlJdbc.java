package sql;

import model.Pix;
import model.Pacote_Pagamento;

public class PixSqlJdbc {
     public List<Pix> getAllPixels() {
        String sql = "SELECT * FROM Boleto";
        List <Pix> pixels = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                pixels = new ArrayList<>();
                while (rs.next()) {
                    Pix px = new Boleto();
                    px.setIdPacote (rs.getInt("idPacote"));
                    px.setIdPagamento(rs.getInt("idPagamento"));
                    px.setCPFCliente(rs.getString ("cpfCliente"));
                    px.setValor(rs.getDouble ("valor"));
                    px.setDesconto(rs.getDouble("desconto"));
                    px.setStatus(rs.getString("status"));
                    px.setDataPagamento (rs.getDate("dataPagamento"));
                    px.setDataCriacao(rs.getDate("dataCriacao"));
                    px.setInstituicao(rs.getString("instituicao"));
                    px.setNumConta(rs.getString("numConta"));
                    pixels.add(px);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pixels;
    }

    @Override
    public void createPix (Pix p) {
        String sql = "insert into Pix (idPacote, dataCriacao, idPagamento, cpfCliente, valor, desconto, status, dataPagamento, instituicao, numConta) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
                pst.setInt(1, p.getIdPacote());
                pst.setDate(2, p.getDataCriacao());
                pst.setInt (3, p.getIdPagamento());
                pst.setString (4, p.getCPFCliente().toUpperCase());
                pst.setDouble (5, p.getValor());
                pst.setDouble (6, p.getDesconto());
                pst.setString(7, p.getStatus().toUpperCase());
                pst.setDate (8, p.getDataPagamento());
                pst.setString (9, p.getInstituicao());
                pst.setString(10, p.getNumConta());
                pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente readPix (String numConta) {
        String sql = "select * from Boleto where numConta = ?";
        Pix pix = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, numConta);
            rs = pst.executeQuery();

            if (rs.next()) {
                pix = new Pix();
                pix.setIdPacote (rs.getInt("idPacote"));
                pix.setIdPagamento(rs.getInt("idPagamento"));
                pix.setCPFCliente(rs.getString ("cpfCliente"));
                pix.setValor(rs.getDouble ("valor"));
                pix.setDesconto(rs.getDouble("desconto"));
                pix.setStatus(rs.getString("status"));
                pix.setDataPagamento (rs.getDate("dataPagamento"));
                pix.setDataCriacao(rs.getDate("dataCriacao"));
                pix.setInstituicao(rs.getString("instituicao"));
                pix.setNumConta(rs.getString("numConta"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pix;
    }

    @Override
    public void updatePix (Pix pix) {
        String sql = "update Pix set dataPagamento = ?, valor = ?, desconto = ?, status = ?, dataCriacao = ?, cpfCliente = ? where idPagamento = ? and idPacote = ? and numConta = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setDate(1, pix.getDataPagamento());
            pst.setDouble(2, pix.getValor());
            pst.setDouble(3, pix.getDesconto());
            pst.setString (4, pix.getStatus().toUpperCase());
            pst.setDate (5, pix.getDataCriacao());
            pst.setString (6, pix.getCPFCliente().toUpperCase());
            pst.setInt (7, pix.getIdPagamento());
            pst.setInt (8, pix.getIdPacote());
            pst.setString (9, pix.getInstituicao().toUpperCase());
            pst.setString (10, pix.getNumConta().toUpperCase());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePix (Pix pix) {
        String sql = "delete from Pix where numConta = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setString(1, pix.getNumConta());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
