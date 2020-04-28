package edu.eci.cvds.entities;

import java.io.Serializable;

public class TipoRecurso implements Serializable {
    private int id;
    private String tipo;

    /**
     * Constructor vacio de la clase TipoRecurso
     */
    public TipoRecurso(){super();}

    /**
     * Constructor de la clase ID
     * @param id el id del tipo
     */
    public TipoRecurso(int id,String tipo){
        this.tipo=tipo;
        this.id=id;
    }

    /**
     * Getter de tipo
     * @return el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del tipo
     * @param tipo el nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter del id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id
     * @param id el id nuevo
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Integer.toString(id)+" "+tipo;
    }
}
