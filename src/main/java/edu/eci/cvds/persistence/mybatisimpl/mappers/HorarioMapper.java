package edu.eci.cvds.persistence.mybatisimpl.mappers;


import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HorarioMapper  {
    /**
     * Consulta todos los horarios
     * @return Una lista de todos los horarios
     */
    List<Horario> horarios();

    /**
     * Ingresa un nuevo horario con las reservas
     * @param recurso
     * @param horario
     */
    void ingresarHorario(@Param("recurso") Recurso recurso,@Param("horario") Horario horario);

    /**
     * Consulta todos los horarios de un recurso
     * @param recurso El recurso del que se quiere consultar
     * @return
     */
    List<Horario> horariosRecurso(@Param("recurso") Recurso recurso);
}
