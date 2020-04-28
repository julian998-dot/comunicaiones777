package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;

import edu.eci.cvds.persistence.DaoReserva;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class MyBatisDaoReserva implements DaoReserva {

    @Inject
    private ReservaMapper reservaMapper;
    @Inject
    private HorarioMapper horarioMapper;

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario, Timestamp fechaIni,Timestamp fechaFin,String tipo) throws LibraryServicesException{
        try {
            Date today=new Date(System.currentTimeMillis());
            Date fechaIniDate=new Date(fechaIni.getTime());
            Time horaInicio=new Time(fechaIni.getTime());
            Time horaFin=new Time(fechaFin.getTime());
            if (fechaIni.after(fechaFin)|| fechaIni.equals(fechaFin)){
                throw new LibraryServicesException(LibraryServicesException.ERROR_DE_HORAS_HORARIO);
            }
            if(fechaIniDate.before(today)){
                throw new LibraryServicesException(LibraryServicesException.RESERVA_FUERA_DE_FECHA);
            }
            List<Horario> horariosRecursos=horarioMapper.horariosRecurso(recurso);
            boolean flag=true;
            for (Horario i:horariosRecursos){
                if(i.getHoraInicio()!=null && i.getHoraFin()!=null) {
                    if(i.after(horaInicio) && i.before(horaFin)) {
                        flag=false;
                    }
                }
            }
            if(flag){
                throw new LibraryServicesException(LibraryServicesException.RESERVA_FUERA_DE_HORARIOS);
            }
            if(fechaFin.getTime()-fechaIni.getTime()>7200000){
                throw new LibraryServicesException(LibraryServicesException.RESERVA_MAYOR_A_DOS_HORAS);
            }
            List<Reserva> reservasActuales=reservaMapper.consultarReservaRecurso(recurso);
            for(Reserva i:reservasActuales){
                if(i.getFechaFin()!=null && i.getFechaInicio()!=null) {
                    Timestamp fechaIniActual = i.getFechaInicio();
                    Timestamp fechaFinActual = i.getFechaFin();
                    boolean fechaInicio = ((fechaIni.before(fechaFinActual)) && (fechaIni.after(fechaIniActual)||fechaIni.equals(fechaIniActual)));
                    boolean fechaFinB = ((fechaFin.before(fechaFinActual)||fechaFin.equals(fechaFinActual)) && fechaFin.after(fechaIniActual));
                    if (fechaInicio || fechaFinB) {
                        throw new LibraryServicesException(LibraryServicesException.RECURSO_RESERVADO_EN_HORA);
                    }
                }
            }
            reservaMapper.reservarRecurso(recurso, usuario, fechaIni, fechaFin,tipo);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> consultarReservasUsuario(String id) throws LibraryServicesException{
        try{
            return reservaMapper.consultarReservasUsuario(id);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> consultarReservas() throws LibraryServicesException {
        try{
            return reservaMapper.consultarReservas();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> consultarReservaRecurso(Recurso recurso) throws LibraryServicesException{
        try {
            return reservaMapper.consultarReservaRecurso(recurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public void eliminarReserva(Reserva reserva) throws LibraryServicesException{
        try{
            reservaMapper.eliminarReserva(reserva);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> consultarReservasActivas() throws LibraryServicesException {
        try{
            return reservaMapper.consultarReservasActivas();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public Reserva consultarReserva(int id) throws LibraryServicesException {
        try{
            return reservaMapper.consultarReserva(id);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> reservasActivasUsuario(Usuario usuario) throws LibraryServicesException {
        try{
            return reservaMapper.reservasActivasUsuario(usuario);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Reserva> reservasCanceladasUsuario(Usuario usuario) throws LibraryServicesException {
        try{
            return reservaMapper.reservasCanceladasUsuario(usuario);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }
}
