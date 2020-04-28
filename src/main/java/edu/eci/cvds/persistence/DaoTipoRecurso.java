package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.services.LibraryServicesException;

public interface DaoTipoRecurso {
    /**
     * Registra un nuevo tipo de recurso
     * @param tipoRecurso El tipo de recurso a registrar
     * @throws LibraryServicesException
     */
    void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException;
}
