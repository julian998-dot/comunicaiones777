package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.TipoRecurso;
import org.apache.ibatis.annotations.Param;

public interface TipoRecursoMapper {
    /**
     * Registra un nuevo tipo de recurso
     * @param tipoRecurso El nuevo tipo de recurso
     */
    void registrarTipoRecurso(@Param("tipoRecurso") TipoRecurso tipoRecurso);
}
