package Dao;

import Model.InventarioSaldosBD;
import Model.Maestrosaldos;
import Model.Productos;
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
        String sqlQuery = " insert into InventarioSaldosBD(idProducto,idMaestroSaldo,fechaRegistro,idUsuario,cantidadDescontar) Values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, in.getIdProducto());
        ps.setInt(2, in.getIdMaestroSaldo());       
        ps.setDate(3, new Date(in.getFechaRegistro().getYear(), in.getFechaRegistro().getMonth(), in.getFechaRegistro().getDate()));
        ps.setInt(4, in.getIdUsuario());
        ps.setInt(5, in.getCantidadDescontar());
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
        String sqlQuery = " Select id,idProducto,idMaestroSaldo,fechaRegistro,idUsuario,cantidadDescontar from  InventarioSaldosBD where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        InventarioSaldosBD in = new InventarioSaldosBD();
        while (rs.next()) {
            in.setId(rs.getInt("id"));
            in.setIdProducto(rs.getInt("idProducto"));
            in.setIdMaestroSaldo(rs.getInt("idMaestroSaldo"));            
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
        String sqlQuery = " Select isbd.id " +
                          "      ,isbd.idProducto " +
                          "      ,isbd.idMaestroSaldo " +                          
                          "      ,isbd.fechaRegistro " +
                          "      ,isbd.idUsuario " +
                          "      ,isbd.cantidadDescontar " +
                          "      ,p.nombreProducto " +
                          "      ,p.numeroReferencia " +
                          "      ,p.cantidadBD " +
                          "      ,ms.nombreSaldoBD " +                          
                          " from  InventarioSaldosBD isbd " +
                          "    inner join productos p on isbd.idProducto = p.id " +
                          "    inner join maestrosaldos ms on isbd.idMaestroSaldo = ms.id ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<InventarioSaldosBD> lstin = new LinkedList<InventarioSaldosBD>();
        while (rs.next()) {
            InventarioSaldosBD in = new InventarioSaldosBD();
            Productos p = new Productos();
            Maestrosaldos ms = new Maestrosaldos();
            in.setId(rs.getInt("id"));
            in.setIdProducto(rs.getInt("idProducto"));
            in.setIdMaestroSaldo(rs.getInt("idMaestroSaldo"));          
            in.setFechaRegistro(rs.getDate("fechaRegistro"));
            in.setIdUsuario(rs.getInt("idUsuario"));
            in.setCantidadDescontar(rs.getInt("cantidadDescontar"));
            
            p.setId(rs.getInt("idProducto"));
            p.setNumeroReferencia(rs.getString("numeroReferencia"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setCantidadBD(rs.getInt("cantidadBD"));
            p.setIdUsuario(rs.getInt("idUsuario"));
            
            ms.setId(rs.getInt("idMaestroSaldo"));
            ms.setNombreSaldoBD(rs.getString("nombreSaldoBD"));
            ms.setIdUsuario(rs.getInt("idUsuario"));
            
            in.setProductos(p);
            in.setMaestrosaldos(ms);
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
        String sqlQuery = " update InventarioSaldosBD , Productos "
                + " set InventarioSaldosBD.idProducto = ?, "
                + "     InventarioSaldosBD.idMaestroSaldo = ?, "
                + "     InventarioSaldosBD.fechaRegistro = ?, "
                + "     InventarioSaldosBD.idUsuario = ?, "
                + "     InventarioSaldosBD.cantidadDescontar = ? ,"
                + "     Productos.cantidadBD = ? "                
                + "     where InventarioSaldosBD.id = ? and "
                + "           InventarioSaldosBD.idProducto = Productos.id ";
     
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        
        ps.setInt(1, in.getIdProducto());
        ps.setInt(2, in.getIdMaestroSaldo());       
        ps.setDate(3, new Date(in.getFechaRegistro().getYear(), in.getFechaRegistro().getMonth(), in.getFechaRegistro().getDate()));
        ps.setInt(4, in.getIdUsuario());
        ps.setInt(5, in.getCantidadDescontar());
        ps.setInt(6, in.getProductos().getCantidadBD());
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
