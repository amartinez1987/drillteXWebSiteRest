package ServicesRest;

import Dao.DaoInventarioSaldosBD;
import Dao.DaoProductos;
import Model.InventarioSaldosBDModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
            if (model.getCantidadSaldo() < 1) {
                model.setErrorRegistro("Digite la cantidad del saldo consumido");
                return model;
            }

            if (model.getIdMaestroSaldo() == 0) {
                model.setErrorRegistro("Seleccione un saldo a asociar la cantidad a consumir");
                return model;
            }

            if (model.getIdProducto() == 0) {
                model.setErrorRegistro("seleccione un producto");
                return model;
            }

            if (model.getCantidadDescontar() > model.getCantidadSaldo()) {
                model.setErrorRegistro("la cantidad en bodega de este producto es menor a la que se va descontar");
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
            if (model.getCantidadSaldo() < 1) {
                model.setErrorRegistro("Digite la cantidad del saldo consumido");
                return model;
            }

            if (model.getIdMaestroSaldo() == 0) {
                model.setErrorRegistro("Seleccione un saldo a asociar la cantidad a consumir");
                return model;
            }

            if (model.getIdProducto() == 0) {
                model.setErrorRegistro("seleccione un producto");
                return model;
            }
            
            Model.InventarioSaldosBD isbdA = din.getInventarioSaldosBD(model.getId());
            model.setCantidadDescontar(isbdA.getCantidadDescontar()+model.getCantidadDescontar());
            
            if (model.getCantidadDescontar() > model.getCantidadSaldo()) {
                model.setErrorRegistro("la cantidad en bodega de este producto es menor a la que se va descontar");
                return model;
            }
            
           

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
}