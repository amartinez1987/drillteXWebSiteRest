package ServicesRest;

import Dao.DaoUsuarios;
import Model.UsuariosModel;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("Usuarios")
public class Usuarios {

    @GET
    @Path("/getUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuariosModel getUsuarios(@QueryParam("id") int id) {
        DaoUsuarios dus = new DaoUsuarios();
        UsuariosModel us = new UsuariosModel();
        try {
            us = new UsuariosModel(dus.getUsuarios(id));
            us.setErrorRegistro("");
        } catch (SQLException sqlEx) {
            us.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            us.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            us.setErrorRegistro(Ex.getMessage());
        }
        return us;
    }

    @POST
    @Path("/addUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuariosModel addUsuarios(UsuariosModel model) {
        DaoUsuarios dus = new DaoUsuarios();
        try {
            dus.insertUsuarios(model.getModel());
        } catch (SQLException sqlEx) {
            model.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            model.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            model.setErrorRegistro(Ex.getMessage());
        }
        return model;
    }

    @POST
    @Path("/updateUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuariosModel updateUsuarios(UsuariosModel model) {
        DaoUsuarios dus = new DaoUsuarios();
        try {
            dus.updateUsuarios(model.getModel());
        } catch (SQLException sqlEx) {
            model.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            model.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            model.setErrorRegistro(Ex.getMessage());
        }
        return model;
    }

    @GET
    @Path("/getListaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<UsuariosModel> getListaUsuarios() {
        DaoUsuarios dus = new DaoUsuarios();
        List<UsuariosModel> lstusm = new LinkedList<UsuariosModel>();
        try {
            List<Model.Usuarios> lstus = dus.getListUsuarios();
            for (Iterator<Model.Usuarios> i = lstus.iterator(); i.hasNext();) {
                lstusm.add(new UsuariosModel(i.next()));
            }
        } catch (Exception Ex) {
        }
        return lstusm;
    }
    
    @POST
    @Path("/loginUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuariosModel loginUsuarios(UsuariosModel model) {
        DaoUsuarios dus = new DaoUsuarios();
        Model.Usuarios us = null;
        try 
        {
            us = dus.getUsuariosUserName(model.getUserName());
            model.setErrorRegistro("");
            if(!us.getPasword().equals(model.getPasword()))
            {
                 model.setErrorRegistro("Usuario o contraseña invalida");
                 return model;
            }   
            model = new UsuariosModel(us);
        
        } catch (SQLException sqlEx) {
            model.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            model.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            model.setErrorRegistro(Ex.getMessage());
        }
        return model;
    }

}
