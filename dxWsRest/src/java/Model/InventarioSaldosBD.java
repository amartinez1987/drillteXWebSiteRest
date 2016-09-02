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

    private int cantidadSaldo = 0;

    public void setCantidadSaldo(int cantidadSaldo) {
        this.cantidadSaldo = cantidadSaldo;
    }

    @XmlElement
    public int getCantidadSaldo() {
        return this.cantidadSaldo;
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

}
