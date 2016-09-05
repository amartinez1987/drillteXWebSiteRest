package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductosModel {

    public void setId(int id) {
        this.model.setId(id);
    }

    @XmlElement
    public int getId() {
        return this.model.getId();
    }

    public void setNombreProducto(String nombreProducto) {
        this.model.setNombreProducto(nombreProducto);
    }

    @XmlElement
    public String getNombreProducto() {
        return this.model.getNombreProducto();
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.model.setNumeroReferencia(numeroReferencia);
    }

    @XmlElement
    public String getNumeroReferencia() {
        return this.model.getNumeroReferencia();
    }

    public void setCantidadBD(int cantidadBD) {
        this.model.setCantidadBD(cantidadBD);
    }
    
    @XmlElement
    public int getCantidadBD() {
        return this.model.getCantidadBD();
    }
    
    public void setIdUsuario(int idUsuario) {
        this.model.setIdUsuario(idUsuario);
    }

    @XmlElement
    public int getIdUsuario() {
        return this.model.getIdUsuario();
    }

    private String errorRegistro = "";

    public void setErrorRegistro(String errorRegistro) {
        this.errorRegistro = errorRegistro;
    }

    public String getErrorRegistro() {
        return this.errorRegistro;
    }
    private Productos model = new Productos();

    public ProductosModel(Productos model) {
        this.model = model;
    }

    public ProductosModel() {

    }

    public Productos getModel() {
        return this.model;
    }
}
