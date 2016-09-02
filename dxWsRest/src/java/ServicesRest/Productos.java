package ServicesRest;

import Dao.DaoProductos;
import Model.ProductosModel;
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

@Path("Productos")
public class Productos {

    @GET
    @Path("/getProductos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductosModel getProductos(@QueryParam("id") int id) {
        DaoProductos dpr = new DaoProductos();
        ProductosModel pr = new ProductosModel();
        try {
            pr = new ProductosModel(dpr.getProductos(id));
        } catch (SQLException sqlEx) {
            pr.setErrorRegistro(sqlEx.getMessage());
        } catch (ClassNotFoundException CNFEx) {
            pr.setErrorRegistro(CNFEx.getMessage());
        } catch (Exception Ex) {
            pr.setErrorRegistro(Ex.getMessage());
        }
        return pr;
    }

    @POST
    @Path("/addProductos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductosModel addProductos(ProductosModel model) {
        DaoProductos dpr = new DaoProductos();
        try {
            dpr.insertProductos(model.getModel());
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
    @Path("/updateProductos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductosModel updateProductos(ProductosModel model) {
        DaoProductos dpr = new DaoProductos();
        try {
            dpr.updateProductos(model.getModel());
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
    @Path("/getListaProductos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProductosModel> getListaProductos() {
        DaoProductos dpr = new DaoProductos();
        List<ProductosModel> lstprm = new LinkedList<ProductosModel>();
        try {
            List<Model.Productos> lstpr = dpr.getListProductos();
            for (Iterator<Model.Productos> i = lstpr.iterator(); i.hasNext();) {
                lstprm.add(new ProductosModel(i.next()));
            }
        } catch (Exception Ex) {
        }
        return lstprm;
    }
}
