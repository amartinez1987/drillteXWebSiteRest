package Dao;

import Model.Maestrosaldos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoMaestrosaldos {

    @SuppressWarnings("ConvertToTryWithResources")
    public int insertMaestrosaldos(Maestrosaldos ma) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        int id = 0;
        String sqlQuery = " insert into Maestrosaldos(nombreSaldoBD,idUsuario) Values (?,?)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ma.getNombreSaldoBD());
        ps.setInt(2, ma.getIdUsuario());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        ps.close();
        con.close();
        return id;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public Maestrosaldos getMaestrosaldos(int id) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,nombreSaldoBD,idUsuario from  Maestrosaldos where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Maestrosaldos ma = new Maestrosaldos();
        while (rs.next()) {
            ma.setId(rs.getInt("id"));
            ma.setNombreSaldoBD(rs.getString("nombreSaldoBD"));
            ma.setIdUsuario(rs.getInt("idUsuario"));
        }
        rs.close();
        ps.close();
        con.close();
        return ma;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public List<Maestrosaldos> getListMaestrosaldos() throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,nombreSaldoBD,idUsuario from  Maestrosaldos";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<Maestrosaldos> lstma = new LinkedList<Maestrosaldos>();
        while (rs.next()) {
            Maestrosaldos ma = new Maestrosaldos();
            ma.setId(rs.getInt("id"));
            ma.setNombreSaldoBD(rs.getString("nombreSaldoBD"));
            ma.setIdUsuario(rs.getInt("idUsuario"));
            lstma.add(ma);
        }
        rs.close();
        ps.close();
        con.close();
        return lstma;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void updateMaestrosaldos(Maestrosaldos ma) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "update Maestrosaldos set nombreSaldoBD = ?,idUsuario = ? where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, ma.getNombreSaldoBD());
        ps.setInt(2, ma.getIdUsuario());
        ps.setInt(3, ma.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void activarMaestrosaldos(Maestrosaldos ma, int idUsuario) {

    }

    public void desactivarMaestrosaldos(Maestrosaldos ma, int idUsuario) {

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void deleteMaestrosaldos(Maestrosaldos ma) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "delete from  Maestrosaldos  where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, ma.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
