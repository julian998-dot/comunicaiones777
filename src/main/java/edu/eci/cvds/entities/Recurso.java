package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recurso implements Serializable {
    private String nombre;
    private String ubicacion;
    private TipoRecurso tipoRecurso;
    private int identificadorInterno;
    private Integer capacidad;
    private int reservadas;
    private String estado;
    private List<String> estados;

    /**
     * Constructor vacio de la clase recurso
     */
    public Recurso(){
        super();
        estados = new ArrayList<String>();
        estados.add("Disponible");
        estados.add("No Disponible");
    }

    /**
     * Constructor de la clase Recurso
     * @param nombre El nombre del recurso
     * @param ubicacion La ubicacion del recurso
     * @param tipoRecurso El tipo del recurso
     * @param identificadorInterno El identificador interno
     * @param capacidad La capacidad del recurso
     */
    public Recurso(String nombre,String ubicacion,TipoRecurso tipoRecurso,String estado,int identificadorInterno,Integer capacidad){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
        this.tipoRecurso=tipoRecurso;
        this.identificadorInterno=identificadorInterno;
        this.capacidad=capacidad;
        this.estado=estado;
        estados = new ArrayList<String>();
        estados.add("Disponible");
        estados.add("No Disponible");
    }


    /**
     * Constructor de la clase recurso
     * @param identificadorInterno el identificador interno
     * @param idTipo El id del tipo
     * @param nombre Nombre del recurso
     * @param ubicacion Ubicacion del recuros
     * @param capacidad Capacidad del recurso
     * @param estado Estado del recurso
     * @param idTipo2 El id del tipo
     * @param nombreTipo Nombre del tipo de recurso
     */
    public Recurso(int identificadorInterno,int idTipo,String nombre,String ubicacion,Integer capacidad,String estado,int idTipo2,String nombreTipo){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
        this.tipoRecurso=new TipoRecurso(idTipo,nombreTipo);
        this.identificadorInterno=identificadorInterno;
        this.capacidad=capacidad;
        this.estado=estado;
        estados = new ArrayList<String>();
        estados.add("Disponible");
        estados.add("No Disponible");
    }


    /**
     * Getter de la capacidad
     * @return la capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * Getter del identificado interno
     * @return el identificador interno
     */
    public int getIdentificadorInterno() {
        return identificadorInterno;
    }

    /**
     * Getter del nombre
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de la ubicacion
     * @return la ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }
    public int getReservadas(){
      return reservadas;
    }
    /**
     * Getter del tipo del recurso
     * @return el tipo del recurso
     */
    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    /**
     * Setter de la capacidad
     * @param capacidad la nueva capacidad
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Setter del identificador interno
     * @param identificadorInterno el nuevo identificador interno
     */
    public void setIdentificadorInterno(int identificadorInterno) {
        this.identificadorInterno = identificadorInterno;
    }

    /**
     * Setter del nombre
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setReservadas(int reservadas){
      this.reservadas=reservadas;

    }
    /**
     * Setter del tipo de recurso
     * @param tipoRecurso el tipo del recurso
     */
    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    /**
     * Setter de la ubicacion
     * @param ubicacion la nueva ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Setter del estado
     * @param estado el nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtenedor del estado
     * @return el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Getter de los estados posibles de un recurso
     * @return Una lista con los estados posibles
     */
    public List<String> getEstados() {
        return estados;
    }

    /**
     * Sette de los estados del recurso
     * @param estados Los nuevos estados del recurso
     */
    public void setEstados(List<String> estados){
        this.estados = estados;
    }

    @Override
    public String toString() {
        if(this.capacidad!=null) {
            return this.nombre + " " + this.ubicacion + " " + this.identificadorInterno + " " + this.tipoRecurso.toString() + " " + this.capacidad.toString();
        }
        else{
            return this.nombre + " " + this.ubicacion + " " + this.identificadorInterno + " " + this.tipoRecurso.toString();
        }
    }
}
