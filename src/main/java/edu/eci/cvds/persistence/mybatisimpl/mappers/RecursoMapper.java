package edu.eci.cvds.persistence.mybatisimpl.mappers;


import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {
    /**
     * Registra un nuevo recurso a la base de datos
     * @param recurso el nuevo recurso
     */
    public void registraNuevoRecurso(@Param("recurso") Recurso recurso);

    /**
     * Elimina un recurso de la base de datos
     * @param recurso El recurso a eliminar
     */
    public void eliminarRecursoPermanente(@Param("recurso") Recurso recurso);

    /**
     * Vuelve el valor de estado a False
     * @param recurso Vuelve el valor de un recurso a false
     */
    public void eliminarRecursoTemporal(@Param("recurso") Recurso recurso);

    /**
     * Vuelve el valor de un recurso a true
     * @param recurso el recurso
     */
    public void volverAAdmitirRecurso(@Param("recurso") Recurso recurso);

    /**
     * Consulta todos los recurso
     * @return una lista con todos los recursos
     */
    public List<Recurso> consultarRecursos();

    /**
     * Consulta un solo resulto
     * @param id el id interno del recurso
     * @return el recurso a buscar
     */
    Recurso consultarRecurso(@Param("id") int id);

    /**
     * Consulta todos los recursos esten o no esten disponibles
     * @return una lista de todos los recursos
     */
    List<Recurso> consultarRecursosAdmin();
}
