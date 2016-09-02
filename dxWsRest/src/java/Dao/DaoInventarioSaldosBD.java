package Dao;

import Model.InventarioSaldosBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoInventarioSaldosBD {

    @SuppressWarnings("ConvertToTryWithResources")
    public int insertInventarioSaldosBD(InventarioSaldosBD in) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        int id = 0;
        String sqlQuery = " insert into InventarioSaldosBD(idProducto,idMaestroSaldo,cantidadSaldo,fechaRegistro,idUsuario,cantidadDescontar) Values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, in.getIdProducto());
        ps.setInt(2, in.getIdMaestroSaldo());
        ps.setInt(3, in.getCantidadSaldo());
        ps.setDate(4, new Date(in.getFechaRegistro().getYear(), in.getFechaRegistro().getMonth(), in.getFechaRegistro().getDate()));
        ps.setInt(5, in.getIdUsuario());
        ps.setInt(6, in.getCantidadDescontar());
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
    public InventarioSaldosBD getInventarioSaldosBD(int id) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,idProducto,idMaestroSaldo,cantidadSaldo,fechaRegistro,idUsuario,cantidadDescontar from  InventarioSaldosBD where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        InventarioSaldosBD in = new InventarioSaldosBD();
        while (rs.next()) {
            in.setId(rs.getInt("id"));
            in.setIdProducto(rs.getInt("idProducto"));
            in.setIdMaestroSaldo(rs.getInt("idMaestroSaldo"));
            in.setCantidadSaldo(rs.getInt("cantidadSaldo"));
            in.setFechaRegistro(rs.getDate("fechaRegistro"));
            in.setIdUsuario(rs.getInt("idUsuario"));
            in.setCantidadDescontar(rs.getInt("cantidadDescontar"));
        }
        rs.close();
        ps.close();
        con.close();
        return in;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public List<InventarioSaldosBD> getListInventarioSaldosBD() throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,idProducto,idMaestroSaldo,cantidadSaldo,fechaRegistro,idUsuario,cantidadDescontar from  InventarioSaldosBD";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<InventarioSaldosBD> lstin = new LinkedList<InventarioSaldosBD>();
        while (rs.next()) {
            InventarioSaldosBD in = new InventarioSaldosBD();
            in.setId(rs.getInt("id"));
            in.setIdProducto(rs.getInt("idProducto"));
            in.setIdMaestroSaldo(rs.getInt("idMaestroSaldo"));
            in.setCantidadSaldo(rs.getInt("cantidadSaldo"));
            in.setFechaRegistro(rs.getDate("fechaRegistro"));
            in.setIdUsuario(rs.getInt("idUsuario"));
            in.setCantidadDescontar(rs.getInt("cantidadDescontar"));
            lstin.add(in);
        }
        rs.close();
        ps.close();
        con.close();
        return lstin;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void updateInventarioSaldosBD(InventarioSaldosBD in) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "update InventarioSaldosBD set idProducto = ?,idMaestroSaldo = ?,cantidadSaldo = ?,fechaRegistro = ?,idUsuario = ?,cantidadDescontar = ? where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, in.getIdProducto());
        ps.setInt(2, in.getIdMaestroSaldo());
        ps.setInt(3, in.getCantidadSaldo());
        ps.setDate(4, new Date(in.getFechaRegistro().getYear(), in.getFechaRegistro().getMonth(), in.getFechaRegistro().getDate()));
        ps.setInt(5, in.getIdUsuario());
        ps.setInt(6, in.getCantidadDescontar());
        ps.setInt(7, in.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void activarInventarioSaldosBD(InventarioSaldosBD in, int idUsuario) {

    }

    public void desactivarInventarioSaldosBD(InventarioSaldosBD in, int idUsuario) {

    }
}
