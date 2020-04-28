package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.LibraryServicesException;

public interface DaoUsuario {

    /**
     * Consulta un usuario
     * @param username El identificador del usuario
     * @throws LibraryServicesException
     */
    Usuario consultarUsuario(String username) throws LibraryServicesException;
}
