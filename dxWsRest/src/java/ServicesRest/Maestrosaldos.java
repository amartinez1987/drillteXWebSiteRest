package ServicesRest;

import Dao.DaoMaestrosaldos;
import Model.MaestrosaldosModel;
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

@Path("Maestrosaldos")
public class Maestrosaldos {

    @GET
    @Path("/getMaestrosaldos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MaestrosaldosModel getMaestrosaldos(@QueryParam("id") int id) {
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        MaestrosaldosModel ma = new MaestrosaldosModel();
        try {
            ma = new MaestrosaldosModel(dma.getMaestrosaldos(id));
        } catch (SQLException sqlEx) {
            ma.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            ma.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            ma.setErrorRegistro(Ex.getMessage());
        }
        return ma;
    }

    @POST
    @Path("/addMaestrosaldos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MaestrosaldosModel addMaestrosaldos(MaestrosaldosModel model) {
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        if (model.getNombreSaldoBD() == "") {
            model.setErrorRegistro("Digite el nombre del saldo");
        }

        try {
            dma.insertMaestrosaldos(model.getModel());
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
    @Path("/updateMaestrosaldos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MaestrosaldosModel updateMaestrosaldos(MaestrosaldosModel model) {
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        try {
            dma.updateMaestrosaldos(model.getModel());
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
    @Path("/getListaMaestrosaldos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MaestrosaldosModel> getListaMaestrosaldos() {
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        List<MaestrosaldosModel> lstmam = new LinkedList<MaestrosaldosModel>();
        try {
            List<Model.Maestrosaldos> lstma = dma.getListMaestrosaldos();
            for (Iterator<Model.Maestrosaldos> i = lstma.iterator(); i.hasNext();) {
                lstmam.add(new MaestrosaldosModel(i.next()));
            }
        } catch (Exception Ex) {
        }
        return lstmam;
    }

    @GET
    @Path("/getListaMaestrosaldosNombre")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MaestrosaldosModel> getListaMaestrosaldos(@QueryParam("nombre") String nombre) {
        if (nombre == null) {
            nombre = "";
        }
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        List<MaestrosaldosModel> lstmam = new LinkedList<MaestrosaldosModel>();
        try {
            List<Model.Maestrosaldos> lstma = dma.getListMaestrosaldos();            
            if(!nombre.equals(""))
            {
                for (Iterator<Model.Maestrosaldos> i = lstma.iterator(); i.hasNext();) {
                    Model.Maestrosaldos ms = i.next();
                    if(ms.getNombreSaldoBD().toLowerCase().contains(nombre))
                    {
                        lstmam.add(new MaestrosaldosModel(i.next()));
                    }                    
                }
            }else
            {            
                for (Iterator<Model.Maestrosaldos> i = lstma.iterator(); i.hasNext();) {
                    lstmam.add(new MaestrosaldosModel(i.next()));
                }
            }
            
        } catch (Exception Ex) {
        }
        return lstmam;
    }
    
    @POST
    @Path("/deleteMaestrosaldos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MaestrosaldosModel deleteMaestrosaldos(MaestrosaldosModel model) {
        DaoMaestrosaldos dma = new DaoMaestrosaldos();
        try {
            dma.deleteMaestrosaldos(model.getModel());
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
