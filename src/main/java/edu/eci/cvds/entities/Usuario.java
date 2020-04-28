package edu.eci.cvds.entities;
import java.io.Serializable;

public class Usuario implements Serializable{

    private String nombre;
    private String passw;
    private String tipo;
    private String id;
    private Integer carnet;
    private String carrera;

    /**
     * Constructor vacio de la clase Usuario
     */
    public Usuario() { super(); }

    /**
     * Constructor de la clase Usuario
     * @param nombre Nombre del usuario
     * @param passw Password del usuario
     * @param tipo tipo de usuario pueden ser regular o administrador
     * @param id Correo del usuario
     * @param carnet Carnet del usuario
     */
    public Usuario(String nombre,String passw,String tipo,String id,Integer carnet,String carrera) {
        this.nombre = nombre;
        this.passw=passw;
        this.tipo = tipo;
        this.id=id;
        this.carnet=carnet;
        this.carrera=carrera;
    }

    /**
     * Getter de la carrera
     * @return la carrera de la persona
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Setter de la carrera
     * @param carrera la nueva carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Setter del id
     * @param id la nueva id o correo
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del id
     * @return el id del usuario
     */
    public String getId() {
        return id;
    }

    /**
     * Getter del carnet
     * @return el carnet del usuario
     */
    public Integer getCarnet() {
        return carnet;
    }

    /**
     * Setter del carnet
     * @param carnet El nuevo carnet
     */
    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
    }

    /**
     * Getter del nombre
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre del usuario
     * @param nombre el nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la password
     * @return la password del usuario
     */
    public String getPassw() {
        return passw;
    }

    /**
     * Setter de la password
     * @param passw la nueva password del usuario
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * Getter del tipo
     * @return el tipo de usuario
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del tipo
     * @param tipo el nuevo tipo de usuario
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id+" "+nombre+" "+tipo;
    }
}
