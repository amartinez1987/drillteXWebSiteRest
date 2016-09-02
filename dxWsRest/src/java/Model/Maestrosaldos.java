package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Maestrosaldos {

    private int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return this.id;
    }

    private String nombreSaldoBD = "";

    public void setNombreSaldoBD(String nombreSaldoBD) {
        this.nombreSaldoBD = nombreSaldoBD;
    }

    @XmlElement
    public String getNombreSaldoBD() {
        return this.nombreSaldoBD;
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
