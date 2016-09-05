package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Productos {

    private int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return this.id;
    }

    private String nombreProducto = "";

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @XmlElement
    public String getNombreProducto() {
        return this.nombreProducto;
    }

    private String numeroReferencia = "";

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    @XmlElement
    public String getNumeroReferencia() {
        return this.numeroReferencia;
    }

    private int idUsuario = 0;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlElement
    public int getIdUsuario() {
        return this.idUsuario;
    }

}
