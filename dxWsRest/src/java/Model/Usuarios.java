package Model;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Usuarios
{
private int id = 0;
public void setId( int id)
{
this.id = id;
}
@XmlElement
public int getId()
 {
 return this.id;
}

private String userName = "";
public void setUserName( String userName)
{
this.userName = userName;
}
@XmlElement
public String getUserName()
 {
 return this.userName;
}

private String primerNombre = "";
public void setPrimerNombre( String primerNombre)
{
this.primerNombre = primerNombre;
}
@XmlElement
public String getPrimerNombre()
 {
 return this.primerNombre;
}

private String segundoNombre = "";
public void setSegundoNombre( String segundoNombre)
{
this.segundoNombre = segundoNombre;
}
@XmlElement
public String getSegundoNombre()
 {
 return this.segundoNombre;
}

private String primerApellido = "";
public void setPrimerApellido( String primerApellido)
{
this.primerApellido = primerApellido;
}
@XmlElement
public String getPrimerApellido()
 {
 return this.primerApellido;
}

private String segundoApellido = "";
public void setSegundoApellido( String segundoApellido)
{
this.segundoApellido = segundoApellido;
}
@XmlElement
public String getSegundoApellido()
 {
 return this.segundoApellido;
}

private Date fechaNacimiento = new Date();
public void setFechaNacimiento( Date fechaNacimiento)
{
this.fechaNacimiento = fechaNacimiento;
}
@XmlElement
public Date getFechaNacimiento()
 {
 return this.fechaNacimiento;
}

private int idUsuario = 0;
public void setIdUsuario( int idUsuario)
{
this.idUsuario = idUsuario;
}
@XmlElement
public int getIdUsuario()
 {
 return this.idUsuario;
}

private String pasword = "";
public void setPasword( String pasword)
{
this.pasword = pasword;
}
@XmlElement
public String getPasword()
 {
 return this.pasword;
}

private String confirmPasword = "";
public void setConfirmPasword( String confirmPasword)
{
this.confirmPasword = confirmPasword;
}
@XmlElement
public String getConfirmPasword()
 {
 return this.confirmPasword;
}

}