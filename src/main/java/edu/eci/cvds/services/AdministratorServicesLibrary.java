package edu.eci.cvds.services;

import edu.eci.cvds.entities.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdministratorServicesLibrary {
    /**
     * Registra un nuevo tipo de recurso
     * @param tipoRecurso el nuevo tipo de recurso
     */
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException;

    /**
     * Regustra un recurso
     * @param recurso el recurso a registrar
     */
    public void registrarRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina un recurso de forma permanente
     * @param recurso el recurso a eliminar
     */
    public void eliminarUnRecursoPermanente(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina un recurso de forma temporal
     * @param recurso el recurso
     */
    public void eliminarUnRecursoTemporal(Recurso recurso) throws LibraryServicesException;

    /**
     * Vuelve a admitir un recurso
     * @param recurso el recurso
     */
    public void volverAAdmitirElRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Consulta todos los recursos esten o no disponibles
     * @return Lista de todos los recursos
     * @throws LibraryServicesException
     */
    List<Recurso> consultarRecursosAdmin() throws LibraryServicesException;

    /**
     * Permite a un administrador reservar un recurso
     * @param recurso El recurso a reservar
     * @param usuario El usuario del recurso
     * @param fechaIni La fecha de inicio
     * @param fechaFin La fecha de fin
     * @throws LibraryServicesException
     */
    void reservarRecurso(Recurso recurso, Usuario usuario, Timestamp fechaIni, Timestamp fechaFin) throws LibraryServicesException;

    /**
     * Ingresa un nuevo horario a un recurso
     * @param recurso El recurso al ingresar el horario
     * @param horario El nuevo horario
     * @throws LibraryServicesException
     */
    void ingresarHorario(Recurso recurso, Horario horario) throws LibraryServicesException;

    /**
     * Obtiene el reporte de las reservas 
     * @throws LibraryServicesException
     */
    Map<Integer,Integer> recursosMasUsados() throws LibraryServicesException;

    Map<Time, Integer> horasMasSolicitadas() throws LibraryServicesException;

    Map<Integer,Integer> recursosMenosUsados() throws LibraryServicesException;

    Map<Time,Integer> horasMenosSolicitadas() throws LibraryServicesException;

    void obtenerRegistroOcupacion() throws LibraryServicesException;
}
