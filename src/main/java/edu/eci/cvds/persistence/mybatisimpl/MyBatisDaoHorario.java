package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.DaoHorario;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;
import java.util.List;

public class MyBatisDaoHorario implements DaoHorario {

     @Inject
     private HorarioMapper horarioMapper;

    @Override
    public List<Horario> horarios() throws LibraryServicesException {
        try {
            return horarioMapper.horarios();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public void ingresarHorario(Recurso recurso, Horario horario) throws LibraryServicesException {
        try{
            if(horario.getHoraInicio().getHours()<7 || horario.getHoraFin().getHours()>19){
                throw new LibraryServicesException(LibraryServicesException.HORARIO_FUERA_DE_HORAS);
            }
            if(horario.getHoraFin().before(horario.getHoraInicio())){
                throw new LibraryServicesException(LibraryServicesException.ERROR_DE_HORAS_HORARIO);
            }
            horarioMapper.ingresarHorario(recurso,horario);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Horario> horarioRecurso(Recurso recurso) throws LibraryServicesException{
        try{
            return horarioMapper.horariosRecurso(recurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }
}
