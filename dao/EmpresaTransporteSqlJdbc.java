package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.EmpresaTransporte;

public class EmpresaTransporteSqlJdbc {
    public List<EmpresaTransporte> getAllEmpresaTransportes() {
        String sql = "SELECT * FROM empresatransporte";
        List<EmpresaTransporte> hoteis = null;

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs != null) {
                hoteis = new ArrayList<>();
                while (rs.next()) {
                    EmpresaTransporte h = new EmpresaTransporte();
                    h.setIdEmpresa(rs.getInt("id_empresa"));
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

    public void createEmpresaTransporte(EmpresaTransporte e) {
        String sql = "insert into empresatransporte (idEmpresa, nome, cidade, estado, cnpj) values (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setInt(1, e.getIdEmpresa());
            pst.setString(2, e.getNome().toUpperCase());
            pst.setString(3, e.getCidade().toUpperCase());
            pst.setString(4, e.getEstado().toUpperCase());
            pst.setString(5, e.getCnpj().toUpperCase());
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public EmpresaTransporte readEmpresaTransporte(int idEmpresa) {
        String sql = "select * from EmpresaTransporte where idEmpresa = ?";
        EmpresaTransporte empresa = null;
        ResultSet rs;
        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, idEmpresa);
            rs = pst.executeQuery();

            if (rs.next()) {
                empresa = new EmpresaTransporte();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setEstado(rs.getString("estado"));
                empresa.setCnpj(rs.getString("cnpj"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    public void updateEmpresaTransporte(EmpresaTransporte empresa) {
        String sql = "update EmpresaTransporte set nome = ?, cidade = ?, estado = ?, cnpj = ? where idEmpresa = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {
            pst.setString(1, empresa.getNome().toUpperCase());
            pst.setString(2, empresa.getCidade().toUpperCase());
            pst.setString(3, empresa.getEstado().toUpperCase());
            pst.setString(4, empresa.getCnpj().toUpperCase());
            pst.setInt(5, empresa.getIdEmpresa());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpresaTransporte(EmpresaTransporte empresa) {
        String sql = "delete from EmpresaTransporte where idEmpresa = ?";

        try (Connection connection = new ConnectionTravel().getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);) {

            pst.setInt(1, empresa.getIdEmpresa());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
