package ServicesRest;

import Dao.DaoInventarioSaldosBD;
import Model.InventarioSaldosBDModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Path("InventarioSaldosBD")
public class InventarioSaldosBD {

    @GET
    @Path("/getInventarioSaldosBD")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InventarioSaldosBDModel getInventarioSaldosBD(@QueryParam("id") int id) {
        DaoInventarioSaldosBD din = new DaoInventarioSaldosBD();
        InventarioSaldosBDModel in = new InventarioSaldosBDModel();
        try {

            in = new InventarioSaldosBDModel(din.getInventarioSaldosBD(id));
        } catch (SQLException sqlEx) {
            in.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            in.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            in.setErrorRegistro(Ex.getMessage());
        }
        return in;
    }

    @POST
    @Path("/addInventarioSaldosBD")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InventarioSaldosBDModel addInventarioSaldosBD(InventarioSaldosBDModel model) {
        DaoInventarioSaldosBD din = new DaoInventarioSaldosBD();

        try {
            
            if (model.getIdMaestroSaldo() == 0) {
                model.setErrorRegistro("Seleccione un saldo a asociar la cantidad a consumir");
                return model;
            }

            if (model.getIdProducto() == 0) {
                model.setErrorRegistro("seleccione un producto");
                return model;
            }

            if(model.getCantidadDescontar()> model.getProductos().getCantidadBD())
            {
                model.setErrorRegistro("La cantidad a descontar supera la disponible por el producto");
                return model;
            }

            List<Model.InventarioSaldosBD> lstin = din.getListInventarioSaldosBD();
            for (Iterator<Model.InventarioSaldosBD> i = lstin.iterator(); i.hasNext();) {
                Model.InventarioSaldosBD isbd = i.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm");
                if (isbd.getIdProducto() == model.getIdProducto()
                        && isbd.getIdMaestroSaldo() == model.getIdMaestroSaldo()
                        && sdf.format(isbd.getFechaRegistro()) == sdf.format(model.getFechaRegistro())) {
                    model.setErrorRegistro("Ya existe en el mes seleccionado un registro con el saldo seleccionado y el producto.");
                    return model;
                }
            }

            din.insertInventarioSaldosBD(model.getModel());
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
    @Path("/updateInventarioSaldosBD")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InventarioSaldosBDModel updateInventarioSaldosBD(InventarioSaldosBDModel model) {
        DaoInventarioSaldosBD din = new DaoInventarioSaldosBD();
        try {
           

            if (model.getIdMaestroSaldo() == 0) {
                model.setErrorRegistro("Seleccione un saldo a asociar la cantidad a consumir");
                return model;
            }

            if (model.getIdProducto() == 0) {
                model.setErrorRegistro("seleccione un producto");
                return model;
            }
            
            Model.InventarioSaldosBD isbdA = din.getInventarioSaldosBD(model.getId());
            
            if(model.getCantidadDescontar()> model.getProductos().getCantidadBD())
            {
                model.setErrorRegistro("La cantidad a descontar supera la disponible por el producto");
                return model;
            }
            model.getProductos().setCantidadBD(model.getProductos().getCantidadBD()- model.getCantidadDescontar());
            model.setCantidadDescontar(isbdA.getCantidadDescontar()+model.getCantidadDescontar());
             
            
            din.updateInventarioSaldosBD(model.getModel());
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
    @Path("/getListaInventarioSaldosBD")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<InventarioSaldosBDModel> getListaInventarioSaldosBD() {
        DaoInventarioSaldosBD din = new DaoInventarioSaldosBD();
        List<InventarioSaldosBDModel> lstinm = new LinkedList<InventarioSaldosBDModel>();
        try {
            List<Model.InventarioSaldosBD> lstin = din.getListInventarioSaldosBD();
            for (Iterator<Model.InventarioSaldosBD> i = lstin.iterator(); i.hasNext();) {
                lstinm.add(new InventarioSaldosBDModel(i.next()));
            }
        } catch (Exception Ex) {
        }
        return lstinm;
    }
    
    @GET
    @Path("/getListaInventarioSaldosBDFilters")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<InventarioSaldosBDModel> getListaInventarioSaldosBDFilters(@QueryParam("periodo") String periodo
                                                                         , @QueryParam("idProductos") int idProductos
                                                                         , @QueryParam("idMaestroSaldo") int idMaestroSaldo) 
    {
        DaoInventarioSaldosBD din = new DaoInventarioSaldosBD();
        List<InventarioSaldosBDModel> lstinm = new LinkedList<InventarioSaldosBDModel>();
        if(periodo != null && idProductos == 0 && idMaestroSaldo == 0)
        {
            try 
            {
                List<Model.InventarioSaldosBD> lstin = din.getListInventarioSaldosBD();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dperiodo = sdf.parse(periodo);
                for (Iterator<Model.InventarioSaldosBD> i = lstin.iterator(); i.hasNext();) 
                {
                    Model.InventarioSaldosBD isbd = i.next();                    
                    if(isbd.getFechaRegistro().getYear()==dperiodo.getYear() && isbd.getFechaRegistro().getMonth()==dperiodo.getMonth())
                    {
                        lstinm.add(new InventarioSaldosBDModel(isbd));
                    }
                }
            } catch (Exception Ex) {
            }
        }   
        
        if(periodo != null && idProductos != 0 && idMaestroSaldo == 0)
        {
            try 
            {
                List<Model.InventarioSaldosBD> lstin = din.getListInventarioSaldosBD();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dperiodo = sdf.parse(periodo);
                for (Iterator<Model.InventarioSaldosBD> i = lstin.iterator(); i.hasNext();) {
                    Model.InventarioSaldosBD isbd = i.next();                    
                    if(isbd.getFechaRegistro().getYear()==dperiodo.getYear() && isbd.getFechaRegistro().getMonth()==dperiodo.getMonth() &&
                       isbd.getIdProducto() == idProductos)
                    {
                        lstinm.add(new InventarioSaldosBDModel(isbd));
                    }
                }
            } catch (Exception Ex) {
            }
        }       
        
        if(periodo != null && idProductos != 0 && idMaestroSaldo != 0)
        {
            try 
            {
                List<Model.InventarioSaldosBD> lstin = din.getListInventarioSaldosBD();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dperiodo = sdf.parse(periodo);
                for (Iterator<Model.InventarioSaldosBD> i = lstin.iterator(); i.hasNext();) {
                    Model.InventarioSaldosBD isbd = i.next();                    
                    if(isbd.getFechaRegistro().getYear()==dperiodo.getYear() && isbd.getFechaRegistro().getMonth()==dperiodo.getMonth() &&
                       isbd.getIdProducto() == idProductos &&
                       isbd.getIdMaestroSaldo()== idMaestroSaldo)
                    {
                        lstinm.add(new InventarioSaldosBDModel(isbd));
                    }
                }
            } catch (Exception Ex) {
            }
        }       
        
        return lstinm;
    }
}
