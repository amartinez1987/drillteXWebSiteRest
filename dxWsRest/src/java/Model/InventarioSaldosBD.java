package Model;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InventarioSaldosBD {

    private int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return this.id;
    }

    private int idProducto = 0;

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @XmlElement
    public int getIdProducto() {
        return this.idProducto;
    }

    private int idMaestroSaldo = 0;

    public void setIdMaestroSaldo(int idMaestroSaldo) {
        this.idMaestroSaldo = idMaestroSaldo;
    }

    @XmlElement
    public int getIdMaestroSaldo() {
        return this.idMaestroSaldo;
    }

    private Date fechaRegistro = new Date();

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlElement
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    private int idUsuario = 0;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlElement
    public int getIdUsuario() {
        return this.idUsuario;
    }

    private int cantidadDescontar = 0;

    public void setCantidadDescontar(int cantidadDescontar) {
        this.cantidadDescontar = cantidadDescontar;
    }

    @XmlElement
    public int getCantidadDescontar() {
        return this.cantidadDescontar;
    }
    
    private Productos productos = new Productos();
    
    public void setProductos(Productos productos)
    {
            this.productos = productos;
    }
    
    @XmlElement
    public Productos getProductos()
    {
        return this.productos;
    }
    
    private Maestrosaldos maestrosaldos = new Maestrosaldos();
    
    public void setMaestrosaldos(Maestrosaldos maestrosaldos)
    {
            this.maestrosaldos = maestrosaldos;
    }
    
    @XmlElement
    public Maestrosaldos getMaestrosaldos()
    {
        return this.maestrosaldos;
    }

}
