package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MaestrosaldosModel {

    public MaestrosaldosModel() {
        
    }

    public void setId(int id) {
        this.model.setId(id);
    }

    @XmlElement
    public int getId() {
        return this.model.getId();
    }

    public void setNombreSaldoBD(String nombreSaldoBD) {
        this.model.setNombreSaldoBD(nombreSaldoBD);
    }

    @XmlElement
    public String getNombreSaldoBD() {
        return this.model.getNombreSaldoBD();
    }

    public void setIdUsuario(int idUsuario) {
        this.model.setIdUsuario(idUsuario);
    }

    @XmlElement
    public int getIdUsuario() {
        return this.model.getIdUsuario();
    }

    private String errorRegistro ="";

    public void setErrorRegistro(String errorRegistro) {
        this.errorRegistro = errorRegistro;
    }
    @XmlElement
    public String getErrorRegistro() {
        return this.errorRegistro;
    }
    private Maestrosaldos model = new Maestrosaldos();

    public MaestrosaldosModel(Maestrosaldos model) {
        this.model = model;
    }
    
    @XmlElement
    public Maestrosaldos getModel() {
        return this.model;
    }
}
