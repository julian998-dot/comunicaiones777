package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;
import java.util.List;

public class MyBatisDaoRecurso implements DaoRecurso {

    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void reserva(int id){
      recursoMapper.reserva(id);
    }

    @Override
    public void registraNuevoRecurso(Recurso recurso) throws LibraryServicesException{
        if(recurso.getCapacidad()!=null) {
            if (recurso.getCapacidad().intValue() < 0) {
                throw new LibraryServicesException(LibraryServicesException.CAPACIDAD_NEGATIVA);
            }
        }
        if (recurso.getNombre().equals("")){
            throw new LibraryServicesException(LibraryServicesException.SIN_NOMBRE);
        }
        try{
            if(recurso.getTipoRecurso().getTipo().equals("Computador")){
                recurso.setCapacidad(0);
            }
            recurso.setEstado("Disponible");
            recursoMapper.registraNuevoRecurso(recurso);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public void eliminarPermanente(Recurso recurso) throws LibraryServicesException{
        try{
            recursoMapper.eliminarRecursoPermanente(recurso);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public void eliminarTemporal(Recurso recurso) throws LibraryServicesException{
        try{
            if(recursoMapper.consultarRecurso(recurso.getIdentificadorInterno()).getEstado().equals("Eliminado")){
                throw new LibraryServicesException(LibraryServicesException.RECURSO_ELIMINADO);
            }
            recursoMapper.eliminarRecursoTemporal(recurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public void volverAAdmitirRecurso(Recurso recurso) throws LibraryServicesException{
        try{
            if(recursoMapper.consultarRecurso(recurso.getIdentificadorInterno()).getEstado().equals("Eliminado")){
                throw new LibraryServicesException(LibraryServicesException.RECURSO_ELIMINADO);
            }
            recursoMapper.volverAAdmitirRecurso(recurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Recurso> consultarRecursos() throws LibraryServicesException{
        try{
            return recursoMapper.consultarRecursos();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public Recurso consultarRecurso(int id) throws LibraryServicesException{
        try {
            return recursoMapper.consultarRecurso(id);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }

    @Override
    public List<Recurso> consultarRecursosAdmin() throws LibraryServicesException {
        try{
            return recursoMapper.consultarRecursosAdmin();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }
}
