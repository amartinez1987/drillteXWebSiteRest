package Dao;

import Model.Productos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoProductos {

    @SuppressWarnings("ConvertToTryWithResources")
    public int insertProductos(Productos pr) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        int id = 0;
        String sqlQuery = " insert into Productos(id,nombreProducto,numeroReferencia,idUsuario,) Values (?,?,?,?,)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(0, pr.getId());
        ps.setString(1, pr.getNombreProducto());
        ps.setString(2, pr.getNumeroReferencia());
        ps.setInt(3, pr.getIdUsuario());
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
    public Productos getProductos(int id) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,nombreProducto,numeroReferencia,idUsuario, from  Productos where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Productos pr = new Productos();
        while (rs.next()) {
            pr.setId(rs.getInt("id"));
            pr.setNombreProducto(rs.getString("nombreProducto"));
            pr.setNumeroReferencia(rs.getString("numeroReferencia"));
            pr.setIdUsuario(rs.getInt("idUsuario"));
        }
        rs.close();
        ps.close();
        con.close();
        return pr;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public List<Productos> getListProductos() throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,nombreProducto,numeroReferencia,idUsuario from  Productos";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<Productos> lstpr = new LinkedList<Productos>();
        while (rs.next()) {
            Productos pr = new Productos();
            pr.setId(rs.getInt("id"));
            pr.setNombreProducto(rs.getString("nombreProducto"));
            pr.setNumeroReferencia(rs.getString("numeroReferencia"));
            pr.setIdUsuario(rs.getInt("idUsuario"));
            lstpr.add(pr);
        }
        rs.close();
        ps.close();
        con.close();
        return lstpr;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void updateProductos(Productos pr) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "update Productos set id = ?,nombreProducto = ?,numeroReferencia = ?,idUsuario = ?, where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(0, pr.getId());
        ps.setString(1, pr.getNombreProducto());
        ps.setString(2, pr.getNumeroReferencia());
        ps.setInt(3, pr.getIdUsuario());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void activarProductos(Productos pr, int idUsuario) {

    }

    public void desactivarProductos(Productos pr, int idUsuario) {

    }
}
