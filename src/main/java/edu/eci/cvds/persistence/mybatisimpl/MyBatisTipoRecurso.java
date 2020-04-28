package edu.eci.cvds.persistence.mybatisimpl;


import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.DaoTipoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.TipoRecursoMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;

public class MyBatisTipoRecurso implements DaoTipoRecurso {

    @Inject
    TipoRecursoMapper tiporecursoMapper;

    @Override
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException{
        try {
            tiporecursoMapper.registrarTipoRecurso(tipoRecurso);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(LibraryServicesException.ERROR_DE_PERSISTENCIA,e.getMessage());
        }
    }
}
