package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Reserva implements Serializable {
    private int id;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private Recurso recurso;
    private Usuario usuario;
    private String estado;
    private String tipo;

    /**
     * Constructor vacio de la clase Reserva
     */
    public Reserva(){super();}

    /**
     * Constructor de la clase RecursoRentado
     * @param id el id del recurso rentado
     * @param fechaInicio fecha de inicio de la renta
     * @param fechaFin fecha de fin de la renta
     * @param recurso el recurso rentado
     */
    public Reserva(int id,Timestamp fechaInicio,Timestamp fechaFin,Recurso recurso,Usuario usuario,String estado,String tipo){
        this.id=id;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.recurso=recurso;
        this.usuario=usuario;
        this.estado=estado;
        this.tipo=tipo;
    }

    /**
     * Setter del tipo
     * @param tipo el nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter del tipo
     * @return si es recurrente o normal
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del estado
     * @param estado el nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Getter del estado
     * @return el estado de la reserva
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter del id
     * @param id el nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del id
     * @return el id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter de la fecha para finalizar la renta
     * @return la fecha en la que finaliza la renta
     */
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    /**
     * Getter de la fehca de inicio de la renta
     * @return fecha de inico de la renta
     */
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Getter del recuros
     * @return el recurso
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * Setter de la fecha final de renta
     * @param fechaFin La nueva fecha final de renta
     */
    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Setter de la fecha inicial de renta
     * @param fechaInicio Nueva fecha inicial de renta
     */
    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Setter del recurso
     * @param recurso el nuevo recurso
     */
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    /**
     * Getter del usuario de la reserva
     * @return El usuario de la reserva
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Setter del usuario de la reserva
     * @param usuario El nuevo usuario de la reserva
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Getter de la fecha inicial de la reserva en formato de Date
     * @return Date de la fecha inicial
     */
    public Date getFechaIniDate(){
        Date date=new Date(fechaInicio.getTime());
        return date;
    }

    /**
     * Getter de la fecha final de la reserva en formato de Date
     * @return Date de la fecha final
     */
    public Date getFechaFinDate(){
        Date date=new Date(fechaFin.getTime());
        return date;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id)+" "+this.recurso.toString()+" "+this.fechaInicio.toString()+" "+this.fechaFin.toString();
    }
}
