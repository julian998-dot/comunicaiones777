package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import java.sql.Timestamp;
import java.util.List;


public interface ServicesLibrary {
    public String reg();
    /**
     * Consulta todos los recursos
     * @return una lista con todos los recursos
     */
    public List<Recurso> consultarRecursos() throws LibraryServicesException;

    public void reserva(int id);

    /**
     * Consulta un unico recurso
     * @param id la id interna del recurso
     * @return El recurso consultado
     */
    public Recurso consultarRecurso(int id) throws LibraryServicesException;

    /**
     * Reserva un recurso en una fecha
     * @param recurso El recurso a reservar
     * @param usuario El usuario que hace la reserva
     * @param fechaIni La fecha de inicio
     * @param fechaFin La fecha de fin
     * @throws LibraryServicesException
     */
    void reservarRecurso(Recurso recurso, Usuario usuario,Timestamp fechaIni,Timestamp fechaFin) throws LibraryServicesException;

    /**
     * Reserva un recurso de forma recurrente
     * @param recurso El recurso a reservar
     * @param usuario El usuario que realiza la reserva
     * @param fechaIni La fecha de inicio
     * @param fechaFin La fecha de fin
     * @param tipoRecurrencia El tipo de recurrencia (Diaria, semanal o mensual)
     * @param cantidadRecurrencia La cantidad de veces que se va a hacer la recurrencia
     * @throws LibraryServicesException
     */
    void reservaRecursorecurrente(Recurso recurso, Usuario usuario, Timestamp fechaIni,Timestamp fechaFin,String tipoRecurrencia,String cantidadRecurrencia) throws  LibraryServicesException;

    /**
     * Consulta las reservas de un usuario
     * @param id El id del usuario
     * @return Una lista de todas las reservas del usuario
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservasUsuario(String id) throws LibraryServicesException;

    /**
     * Consulta todas las reservas
     * @return Todas las reservas activas
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservas() throws LibraryServicesException;

    /**
     * Lista de los horarios de los recursos
     * @return los horarios de los recursos
     * @throws LibraryServicesException
     */
    List<Horario> horariosRecursos() throws LibraryServicesException;

    /**
     * Consulta las reservas por su recurso
     * @param recurso El recurso de la reserva
     * @return Las reservas del recurso
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservaRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina una reserva
     * @param reserva La reserva a eliminar
     * @throws LibraryServicesException
     */
    void eliminarReserva(Reserva reserva) throws LibraryServicesException;


    /**
     * Consulta un usuario
     * @param username El identificador del usuario
     * @throws LibraryServicesException
     */
    Usuario consultarUsuario(String username) throws LibraryServicesException;

    /**
     * Consulta el horario de un recurso
     * @param recurso el recurso del que se desea hacer la consulta
     * @return una lista con todos los horarios del recurso
     * @throws LibraryServicesException
     */
    List<Horario> horarioRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Consulta todas las reservas activas
     * @return una lista con todas las reservas activas
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservasActivas() throws LibraryServicesException;

    Reserva consultarReserva(int id) throws LibraryServicesException;

    List<Reserva> reservasActivasUsuario(Usuario usuario) throws LibraryServicesException;

    List<Reserva> reservasCanceladasUsuario(Usuario usuario) throws LibraryServicesException;
}
