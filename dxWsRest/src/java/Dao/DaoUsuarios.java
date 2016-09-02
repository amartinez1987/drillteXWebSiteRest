package Dao;

import Model.Usuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoUsuarios {

    @SuppressWarnings("ConvertToTryWithResources")
    public int insertUsuarios(Usuarios us) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        int id = 0;
        String sqlQuery = " insert into Usuarios(userName,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,idUsuario,pasword,confirmPasword) Values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, us.getUserName());
        ps.setString(2, us.getPrimerNombre());
        ps.setString(3, us.getSegundoNombre());
        ps.setString(4, us.getPrimerApellido());
        ps.setString(5, us.getSegundoApellido());
        ps.setDate(6,new Date( us.getFechaNacimiento().getYear(),  us.getFechaNacimiento().getMonth(),  us.getFechaNacimiento().getDate()));        
        ps.setInt(7, us.getIdUsuario());
        ps.setString(8, us.getPasword());
        ps.setString(9, us.getConfirmPasword());
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
    public Usuarios getUsuarios(int id) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,userName,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,idUsuario,pasword,confirmPasword from  Usuarios where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Usuarios us = new Usuarios();
        while (rs.next()) {
            us.setId(rs.getInt("id"));
            us.setUserName(rs.getString("userName"));
            us.setPrimerNombre(rs.getString("primerNombre"));
            us.setSegundoNombre(rs.getString("segundoNombre"));
            us.setPrimerApellido(rs.getString("primerApellido"));
            us.setSegundoApellido(rs.getString("segundoApellido"));
            us.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            us.setIdUsuario(rs.getInt("idUsuario"));
            us.setPasword(rs.getString("pasword"));
            us.setConfirmPasword(rs.getString("confirmPasword"));
        }
        rs.close();
        ps.close();
        con.close();
        return us;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public Usuarios getUsuariosUserName(String userName) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,userName,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,idUsuario,pasword,confirmPasword from  Usuarios where userName = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        Usuarios us = new Usuarios();
        while (rs.next()) {
            us.setId(rs.getInt("id"));
            us.setUserName(rs.getString("userName"));
            us.setPrimerNombre(rs.getString("primerNombre"));
            us.setSegundoNombre(rs.getString("segundoNombre"));
            us.setPrimerApellido(rs.getString("primerApellido"));
            us.setSegundoApellido(rs.getString("segundoApellido"));
            us.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            us.setIdUsuario(rs.getInt("idUsuario"));
            us.setPasword(rs.getString("pasword"));
            us.setConfirmPasword(rs.getString("confirmPasword"));
        }
        rs.close();
        ps.close();
        con.close();
        return us;
    }

    
    @SuppressWarnings("ConvertToTryWithResources")
    public List<Usuarios> getListUsuarios() throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = " Select id,userName,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,idUsuario,pasword,confirmPasword from  Usuarios";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        List<Usuarios> lstus = new LinkedList<Usuarios>();
        while (rs.next()) {
            Usuarios us = new Usuarios();
            us.setId(rs.getInt("id"));
            us.setUserName(rs.getString("userName"));
            us.setPrimerNombre(rs.getString("primerNombre"));
            us.setSegundoNombre(rs.getString("segundoNombre"));
            us.setPrimerApellido(rs.getString("primerApellido"));
            us.setSegundoApellido(rs.getString("segundoApellido"));
            us.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            us.setIdUsuario(rs.getInt("idUsuario"));
            us.setPasword(rs.getString("pasword"));
            us.setConfirmPasword(rs.getString("confirmPasword"));
            lstus.add(us);
        }
        rs.close();
        ps.close();
        con.close();
        return lstus;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void updateUsuarios(Usuarios us) throws ClassNotFoundException, SQLException {
        Connection con = (Connection) ConnetorBD.getDriverManagerConnection();
        String sqlQuery = "update Usuarios set userName = ?,primerNombre = ?,segundoNombre = ?,primerApellido = ?,segundoApellido = ?,fechaNacimiento = ?,idUsuario = ?,pasword = ?,confirmPasword = ? where id = ? ";
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        
        ps.setString(1, us.getUserName());
        ps.setString(2, us.getPrimerNombre());
        ps.setString(3, us.getSegundoNombre());
        ps.setString(4, us.getPrimerApellido());
        ps.setString(5, us.getSegundoApellido());
        ps.setDate(6,new Date( us.getFechaNacimiento().getYear(),  us.getFechaNacimiento().getMonth(),  us.getFechaNacimiento().getDate()));
        ps.setInt(7, us.getIdUsuario());
        ps.setString(8, us.getPasword());
        ps.setString(9, us.getConfirmPasword());
        ps.setInt(10, us.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void activarUsuarios(Usuarios us, int idUsuario) {

    }

    public void desactivarUsuarios(Usuarios us, int idUsuario) {

    }
}
