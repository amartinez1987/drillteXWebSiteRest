package Model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuariosModel {

    public void setId(int id) {
        this.model.setId(id);
    }

    @XmlElement
    public int getId() {
        return this.model.getId();
    }

    public void setUserName(String userName) {
        this.model.setUserName(userName);
    }

    @XmlElement
    public String getUserName() {
        return this.model.getUserName();
    }

    public void setPrimerNombre(String primerNombre) {
        this.model.setPrimerNombre(primerNombre);
    }

    @XmlElement
    public String getPrimerNombre() {
        return this.model.getPrimerNombre();
    }

    public void setSegundoNombre(String segundoNombre) {
        this.model.setSegundoNombre(segundoNombre);
    }

    @XmlElement
    public String getSegundoNombre() {
        return this.model.getSegundoNombre();
    }

    public void setPrimerApellido(String primerApellido) {
        this.model.setPrimerApellido(primerApellido);
    }

    @XmlElement
    public String getPrimerApellido() {
        return this.model.getPrimerApellido();
    }

    public void setSegundoApellido(String segundoApellido) {
        this.model.setSegundoApellido(segundoApellido);
    }

    @XmlElement
    public String getSegundoApellido() {
        return this.model.getSegundoApellido();
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.model.setFechaNacimiento(fechaNacimiento);
    }

    @XmlElement
    public Date getFechaNacimiento() {
        return this.model.getFechaNacimiento();
    }

    public void setIdUsuario(int idUsuario) {
        this.model.setIdUsuario(idUsuario);
    }

    @XmlElement
    public int getIdUsuario() {
        return this.model.getIdUsuario();
    }

    public void setPasword(String pasword) {
        this.model.setPasword(pasword);
    }

    @XmlElement
    public String getPasword() {
        return this.model.getPasword();
    }

    public void setConfirmPasword(String confirmPasword) {
        this.model.setConfirmPasword(confirmPasword);
    }

    @XmlElement
    public String getConfirmPasword() {
        return this.model.getConfirmPasword();
    }

    private String errorRegistro = "";

    public void setErrorRegistro(String errorRegistro) {
        this.errorRegistro = errorRegistro;
    }

    public String getErrorRegistro() {
        return this.errorRegistro;
    }
    private Usuarios model = new Usuarios();

    public UsuariosModel(Usuarios model) {
        this.model = model;
    }
    
     public UsuariosModel() {
        
    }

    public Usuarios getModel() {
        return this.model;
    }
}
