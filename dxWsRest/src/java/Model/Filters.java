/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AnibalGuillermo
 */
@XmlRootElement
public class Filters 
{
    private String periodo;
    private int idProductos;
    private int idMaestroSaldo;   

    public void setPeriodo(String periodo) 
    {
        this.periodo = periodo;
    }
    
    @XmlElement
    public String getPeriodo() 
    {
        return this.periodo;
    }       

    public void setIdProductos(int idProductos) 
    {
        this.idProductos = idProductos;
    }
    
    @XmlElement
    public int getIdProductos() 
    {
        return this.idProductos;
    }   

    public void setIdMaestroSaldo(int idMaestroSaldo) 
    {
        this.idMaestroSaldo = idMaestroSaldo;
    }
    
    @XmlElement
    public int getIdMaestroSaldo() 
    {
        return this.idMaestroSaldo;
    }
    
    public Filters()
    {
    
    }
}
