package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.LibraryServicesException;

import java.util.List;

public interface DaoHorario {
    /**
     * Da una lista de todos los horarios
     * @return Lista de todos los horarios
     * @throws LibraryServicesException
     */
    List<Horario> horarios() throws LibraryServicesException;

    /**
     * Ingresa un nuevo horario a un recurso
     * @param recurso El recurso al que se le quiere ingresar
     * @param horario El nuevo horario
     * @throws LibraryServicesException
     */
    void ingresarHorario(Recurso recurso, Horario horario) throws LibraryServicesException;

    /**
     * Consulta todos los horarios de un recurso
     * @param recurso El recurso del que se quiere consultar
     * @return Una lista con horarios de un recurso
     * @throws LibraryServicesException
     */
    List<Horario> horarioRecurso(Recurso recurso) throws LibraryServicesException;
}
