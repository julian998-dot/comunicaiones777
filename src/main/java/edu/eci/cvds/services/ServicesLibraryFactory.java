package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.impl.AdministratorServicesLibraryImpl;
import edu.eci.cvds.services.impl.ServicesLibraryImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServicesLibraryFactory {

    private static ServicesLibraryFactory instance=new ServicesLibraryFactory();

    private static Injector injector;

    private static Injector testInjector;

    /**
     * Fabrica de los servicios
     */
    private ServicesLibraryFactory(){
        injector=createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServicesLibrary.class).to(ServicesLibraryImpl.class);
                bind(AdministratorServicesLibrary.class).to(AdministratorServicesLibraryImpl.class);
                bind(DaoRecurso.class).to(MyBatisDaoRecurso.class);
                bind(DaoReserva.class).to(MyBatisDaoReserva.class);
                bind(DaoTipoRecurso.class).to(MyBatisTipoRecurso.class);
                bind(DaoHorario.class).to(MyBatisDaoHorario.class);
                bind(DaoUsuario.class).to(MyBatisDaoUsuario.class);
            }
        });

        testInjector=createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServicesLibrary.class).to(ServicesLibraryImpl.class);
                bind(AdministratorServicesLibrary.class).to(AdministratorServicesLibraryImpl.class);
                bind(DaoRecurso.class).to(MyBatisDaoRecurso.class);
                bind(DaoReserva.class).to(MyBatisDaoReserva.class);
                bind(DaoTipoRecurso.class).to(MyBatisTipoRecurso.class);
                bind(DaoHorario.class).to(MyBatisDaoHorario.class);
                bind(DaoUsuario.class).to(MyBatisDaoUsuario.class);
            }
        });
    }


    /**
     * Obtener los servicios de prueba
     * @return ServicesLibrary de prueba
     */
    public ServicesLibrary testServicesLibrary(){
        return testInjector.getInstance(ServicesLibrary.class);
    }

    /**
     * Obtener los servicios de prueba de administrador
     * @return AdministratorServicesLibrary de prueba
     */
    public AdministratorServicesLibrary testAdminServicesLibrary(){
        return testInjector.getInstance(AdministratorServicesLibrary.class);
    }

    /**
     * Get de los servicios de administrador
     * @return AdministratorServices
     */
    public AdministratorServicesLibrary getAdministratorServices(){
        return injector.getInstance(AdministratorServicesLibrary.class);
    }

    /**
     * Get de los serivicios de usuario
     * @return ServicesLibrary
     */
    public ServicesLibrary getServicesLibrary(){
        return injector.getInstance(ServicesLibrary.class);
    }

    /**
     * Get de la instancia de la fabrica
     * @return la fabrica
     */
    public static ServicesLibraryFactory getInstance(){
        return instance;
    }

}
