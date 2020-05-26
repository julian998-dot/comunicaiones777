package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.LibraryServicesException;

import java.util.List;

public interface DaoRecurso {
    /**
     * Registra un nuevo recurso
     * @param recurso El nuevo recurso
     * @throws LibraryServicesException
     */
    public void registraNuevoRecurso(Recurso recurso) throws LibraryServicesException;

    public void reserva(int id);

    /**
     * Elimina un recurso de forma permanente
     * @param recurso El recurso a eliminar
     * @throws LibraryServicesException
     */
    public void eliminarPermanente(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina de forma temporal un recurso
     * @param recurso El recurso a sacar de servicio
     * @throws LibraryServicesException
     */
    public void eliminarTemporal(Recurso recurso) throws LibraryServicesException;

    /**
     * Vuelve a admitir un recurso que no estaba disponible
     * @param recurso El recurso que toda readmitir
     * @throws LibraryServicesException
     */
    public void volverAAdmitirRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Consulta todos los recursos que esten disponibles
     * @return Una lista de todos los recursos disponibles
     * @throws LibraryServicesException
     */
    public List<Recurso> consultarRecursos() throws LibraryServicesException;

    /**
     * Consulta un recurso por su id
     * @param id El id del recurso
     * @return El recurso al que pertenece el id
     * @throws LibraryServicesException
     */
    Recurso consultarRecurso(int id) throws LibraryServicesException;

    /**
     * Consulta todos los recursos esten o no esten disponibles
     * @return Una lista de todos los recursos
     * @throws LibraryServicesException
     */
    List<Recurso> consultarRecursosAdmin() throws LibraryServicesException;
}
