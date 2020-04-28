package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class Horario implements Serializable {

    private int id;
    private Recurso recurso;
    private Time horaInicio;
    private Time horaFin;


    /**
     * Constructor vacio de la clase horario
     */
    public Horario(){super();}

    /**
     * Constructor de la clase horario
     * @param id el id del horario
     * @param recurso El recurso del horario
     * @param horaInicio Hora de inicio
     * @param horaFin Hora de fin
     */
    public Horario(int id,Recurso recurso,Time horaInicio, Time horaFin){
        this.id=id;
        this.recurso=recurso;
        this.horaFin=horaFin;
        this.horaInicio=horaInicio;
    }

    /**
     * Getter del recurso
     * @return recurso del horario
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * Setter del recurso
     * @param recurso El nuevo recurso
     */
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    /**
     * Setter de la Hora final del horario
     * @return la hora final del horario
     */
    public Time getHoraFin() {
        return horaFin;
    }

    /**
     * Setter de la hora inicial del horario
     * @return Hora inical del horario
     */
    public Time getHoraInicio() {
        return horaInicio;
    }

    /**
     * Setter de la hora final del recurso
     * @param horaFin La nueva hora final
     */
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Setter de la hora inicial del recurso
     * @param horaInicio La nueva hora inicial
     */
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Getter del id
     * @return el id del horario
     */
    public int getId() {
        return id;
    }

    /**
     * Setter dle id
     * @param id el nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Verifica si la hora dada esta antes de la hora inicio del horario
     * @param time La hora dada
     * @return Si la hora esta antes de la hora inicio del horario
     */
    public boolean after(Time time){
        if(time.getHours()>horaInicio.getHours()){
            return true;
        }
        if(time.getHours()==horaInicio.getHours() && time.getMinutes()>horaInicio.getMinutes()){
            return true;
        }
        if(time.getMinutes()==horaInicio.getMinutes() && time.getSeconds()>horaInicio.getSeconds()){
            return true;
        }
        return false;
    }

    /**
     * Verifica si la hora dada esta despues de la hora fin del horario
     * @param time La hora dada
     * @return Si la hora esta antes de la hora fin del horario
     */
    public boolean before(Time time){
        boolean ans=false;
        ans=(time.getHours()<horaFin.getHours())? true:ans;
        ans=(time.getHours()==horaFin.getHours() && time.getMinutes()<horaFin.getMinutes())? true:ans;
        ans=(time.getMinutes()==horaFin.getMinutes() && time.getSeconds()<horaFin.getSeconds())? true:ans;
        return ans;
    }

    @Override
    public String toString() {
        return horaInicio.toString()+" "+horaFin.toString();
    }

}
