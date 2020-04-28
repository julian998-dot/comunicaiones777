package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.DaoHorario;
import edu.eci.cvds.persistence.DaoReserva;
import edu.eci.cvds.persistence.DaoUsuario;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.services.ServicesLibraryFactory;

import javax.inject.Inject;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ServicesLibraryImpl implements ServicesLibrary {
    @Inject
    private DaoRecurso recursoDao;
    @Inject
    private DaoReserva reservaDao;
    @Inject
    private DaoHorario horarioDao;
    @Inject
    private DaoUsuario usuarioDao;

    @Override
    public List<Recurso> consultarRecursos() throws LibraryServicesException {
        return recursoDao.consultarRecursos();
    }

    @Override
    public Recurso consultarRecurso(int id) throws LibraryServicesException {
        return recursoDao.consultarRecurso(id);
    }

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario, Timestamp fechaIni, Timestamp fechaFin) throws LibraryServicesException {
        reservaDao.reservarRecurso(recurso,usuario,fechaIni,fechaFin,"Normal");
    }

    @Override
    public void reservaRecursorecurrente(Recurso recurso, Usuario usuario, Timestamp fechaIni, Timestamp fechaFin,String tipoRecurrencia,String cantidadRecurrencia) throws LibraryServicesException{
        ArrayList<Timestamp> fechas = null;
        if(tipoRecurrencia.equals("Diaria"))
            fechas = sumarDias(cantidadRecurrencia,fechaIni.toLocalDateTime(),fechaFin.toLocalDateTime());
        else if (tipoRecurrencia.equals("Semanal"))
            fechas = sumarSemanas(cantidadRecurrencia,fechaIni.toLocalDateTime(),fechaFin.toLocalDateTime());
        else if (tipoRecurrencia.equals("Mensual"))
            fechas = sumarMeses(cantidadRecurrencia, fechaIni.toLocalDateTime(), fechaFin.toLocalDateTime());
        for (int i = 0; i <fechas.size() ; i+=2) {
            reservaDao.reservarRecurso(recurso, usuario, fechas.get(i), fechas.get(i+1),"Recurrente");
        }
    }
    private ArrayList<Timestamp> sumarMeses(String cantidadRecurrencia, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        ArrayList<Timestamp> fechas=new ArrayList<>();
        fechas.add(Timestamp.valueOf(fechaIni));
        fechas.add(Timestamp.valueOf(fechaFin));
        for (int i = 0; i <Integer.parseInt(cantidadRecurrencia); i++) {
            fechaIni = fechaIni.plusMonths(1);
            fechaFin = fechaFin.plusMonths(1);
            fechas.add(Timestamp.valueOf(fechaIni));
            fechas.add(Timestamp.valueOf(fechaFin));
        }
        return fechas;
    }

    private ArrayList<Timestamp> sumarSemanas(String cantidadRecurrencia, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        ArrayList<Timestamp> fechas=new ArrayList<>();
        fechas.add(Timestamp.valueOf(fechaIni));
        fechas.add(Timestamp.valueOf(fechaFin));
        for (int i = 0; i <Integer.parseInt(cantidadRecurrencia); i++) {
            fechaIni = fechaIni.plusWeeks(1);
            fechaFin = fechaFin.plusWeeks(1);
            fechas.add(Timestamp.valueOf(fechaIni));
            fechas.add(Timestamp.valueOf(fechaFin));
        }
        return fechas;
    }

    private ArrayList<Timestamp> sumarDias(String cantidadRecurrencia, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        ArrayList<Timestamp> fechas=new ArrayList<>();
        fechas.add(Timestamp.valueOf(fechaIni));
        fechas.add(Timestamp.valueOf(fechaFin));
        for (int i = 0; i <Integer.parseInt(cantidadRecurrencia); i++) {
            fechaIni = fechaIni.plusDays(1);
            fechaFin = fechaFin.plusDays(1);
            fechas.add(Timestamp.valueOf(fechaIni));
            fechas.add(Timestamp.valueOf(fechaFin));
        }
        return fechas;
    }

    @Override
    public List<Reserva> consultarReservasUsuario(String id) throws LibraryServicesException {
        return reservaDao.consultarReservasUsuario(id);
    }

    @Override
    public List<Reserva> consultarReservas() throws LibraryServicesException {
        return reservaDao.consultarReservas();
    }

    @Override
    public List<Horario> horariosRecursos() throws LibraryServicesException{
        return horarioDao.horarios();
    }

    @Override
    public List<Reserva> consultarReservaRecurso(Recurso recurso) throws LibraryServicesException {
        return reservaDao.consultarReservaRecurso(recurso);
    }

    @Override
    public void eliminarReserva(Reserva reserva) throws LibraryServicesException {
        reservaDao.eliminarReserva(reserva);
    }

    @Override
    public Usuario consultarUsuario(String username) throws LibraryServicesException {
        return usuarioDao.consultarUsuario(username);
    }

    @Override
    public List<Horario> horarioRecurso(Recurso recurso) throws LibraryServicesException {
        return horarioDao.horarioRecurso(recurso);
    }

    @Override
    public List<Reserva> consultarReservasActivas() throws LibraryServicesException {
        return reservaDao.consultarReservasActivas();
    }

    @Override
    public Reserva consultarReserva(int id) throws LibraryServicesException {
        return reservaDao.consultarReserva(id);
    }

    @Override
    public List<Reserva> reservasActivasUsuario(Usuario usuario) throws LibraryServicesException {
        return reservaDao.reservasActivasUsuario(usuario);
    }

    @Override
    public List<Reserva> reservasCanceladasUsuario(Usuario usuario) throws LibraryServicesException {
        return reservaDao.reservasCanceladasUsuario(usuario);
    }

}