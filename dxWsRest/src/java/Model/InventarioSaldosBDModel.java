package Model;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InventarioSaldosBDModel {

    public void setId(int id) {
        this.model.setId(id);
    }

    @XmlElement
    public int getId() {
        return this.model.getId();
    }

    public void setIdProducto(int idProducto) {
        this.model.setIdProducto(idProducto);
    }

    @XmlElement
    public int getIdProducto() {
        return this.model.getIdProducto();
    }

    public void setIdMaestroSaldo(int idMaestroSaldo) {
        this.model.setIdMaestroSaldo(idMaestroSaldo);
    }

    @XmlElement
    public int getIdMaestroSaldo() {
        return this.model.getIdMaestroSaldo();
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.model.setFechaRegistro(fechaRegistro);
    }

    @XmlElement
    public Date getFechaRegistro() {
        return this.model.getFechaRegistro();
    }

    public void setIdUsuario(int idUsuario) {
        this.model.setIdUsuario(idUsuario);
    }

    @XmlElement
    public int getIdUsuario() {
        return this.model.getIdUsuario();
    }

    public void setCantidadDescontar(int cantidadDescontar) {
        this.model.setCantidadDescontar(cantidadDescontar);
    }

    @XmlElement
    public int getCantidadDescontar() {
        return this.model.getCantidadDescontar();
    }
    
    public void setProductos(Productos productos)
    {
            this.model.setProductos( productos);
    }
    
    @XmlElement
    public Productos getProductos()
    {
        return this.model.getProductos();
    }
    
    public void setMaestrosaldos(Maestrosaldos maestrosaldos)
    {
            this.model.setMaestrosaldos(maestrosaldos);
    }
    
    @XmlElement
    public Maestrosaldos getMaestrosaldos()
    {
        return this.model.getMaestrosaldos();
    }
    private String errorRegistro ="";

    public void setErrorRegistro(String errorRegistro) {
        this.errorRegistro = errorRegistro;
    }

    public String getErrorRegistro() {
        return this.errorRegistro;
    }
    private InventarioSaldosBD model = new InventarioSaldosBD();

    public InventarioSaldosBDModel(InventarioSaldosBD model) {
        this.model = model;
    }
    
    public InventarioSaldosBDModel() {
        
    }

    public InventarioSaldosBD getModel() {
        return this.model;
    }
}
