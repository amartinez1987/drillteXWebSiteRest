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
        String sqlQuery = " insert into Productos(nombreProducto,numeroReferencia, cantidadBD ,idUsuario) Values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, pr.getNombreProducto());
        ps.setString(2, pr.getNumeroReferencia());
        ps.setInt(3, pr.getCantidadBD());
        ps.setInt(4, pr.getIdUsuario());
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
        String sqlQuery = " Select id,nombreProducto,numeroReferencia, cantidadBD ,idUsuario from  Productos where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Productos pr = new Productos();
        while (rs.next()) {
            pr.setId(rs.getInt("id"));
            pr.setNombreProducto(rs.getString("nombreProducto"));
            pr.setNumeroReferencia(rs.getString("numeroReferencia"));
            pr.setCantidadBD(rs.getInt("cantidadBD"));
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
        String sqlQuery = " Select id,nombreProducto,numeroReferencia, cantidadBD ,idUsuario from  Productos";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<Productos> lstpr = new LinkedList<Productos>();
        while (rs.next()) {
            Productos pr = new Productos();
            pr.setId(rs.getInt("id"));
            pr.setNombreProducto(rs.getString("nombreProducto"));
            pr.setNumeroReferencia(rs.getString("numeroReferencia"));
            pr.setCantidadBD(rs.getInt("cantidadBD"));
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
        String sqlQuery = "update Productos set nombreProducto = ?,numeroReferencia = ?, cantidadBD = ? ,idUsuario = ? where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);

        ps.setString(1, pr.getNombreProducto());
        ps.setString(2, pr.getNumeroReferencia());        
        ps.setInt(3, pr.getCantidadBD());
        ps.setInt(4, pr.getIdUsuario());
        ps.setInt(5, pr.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void activarProductos(Productos pr, int idUsuario) {

    }

    public void desactivarProductos(Productos pr, int idUsuario) {

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void deleteProductos(Productos model) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "delete from Productos where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, model.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
