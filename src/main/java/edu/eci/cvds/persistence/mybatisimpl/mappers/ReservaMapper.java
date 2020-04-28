package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ReservaMapper {
    /**
     * Reserva un recurso
     * @param recurso El recurso a reservar
     * @param usuario El usuario que realiza la reserva
     * @param fechaIni La fecha de inicio de la reserva
     * @param fechaFin La fecha de finalizacion de la reserva
     */
    void reservarRecurso(@Param("recurso") Recurso recurso, @Param("usuario")Usuario usuario, @Param("fechaIni") Timestamp fechaIni,@Param("fechaFin") Timestamp fechaFin,@Param("tipo") String tipo);

    /**
     * Consulta las reservas de un usuario
     * @param id El id del usuario que consulta las reservas
     * @return Consulta las reservas de un usuario
     */
    List<Reserva> consultarReservasUsuario(@Param("id") String id);

    /**
     * Consulta todas las reservas activas
     * @return todas las reservas
     */
    List<Reserva> consultarReservas();


    /**
     * Consulta las reservas de un recurso
     * @param recurso El recurso del que se desea consultar la reserva
     * @return Las reservas de ese recurso
     */
    List<Reserva> consultarReservaRecurso(@Param("recurso") Recurso recurso);

    /**
     * Eliminar una reserva
     * @param reserva La reserva a eliminar
     */
    void eliminarReserva(@Param("reserva") Reserva reserva);

    /**
     * Consulta todas las reservas activas
     * @return Una lista con todas las reservas activas
     */
    List<Reserva> consultarReservasActivas();


    Reserva consultarReserva(@Param("id") int id);

    List<Reserva> reservasActivasUsuario(@Param("usuario") Usuario usuario);

    List<Reserva> reservasCanceladasUsuario(@Param("usuario") Usuario usuario);
}
