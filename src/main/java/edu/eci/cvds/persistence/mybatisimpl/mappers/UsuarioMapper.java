package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {

    /**
     * Consulta un usuario
     * @param id el id interno del usuario
     * @return el recurso a buscar
     */
    Usuario consultarUsuario(@Param("id") String id);
}
