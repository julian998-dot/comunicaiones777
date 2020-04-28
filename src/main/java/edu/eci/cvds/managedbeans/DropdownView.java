package edu.eci.cvds.managedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "dropdown")
@SessionScoped
public class DropdownView implements Serializable {

    private Map<String, Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String tipoRepeticionSeleccionado;
    private String cantidadRepeticiones;
    private Map<String,String> tipoRepeticiones;
    private Map<String,String> cantidadesRepeticiones;

    @PostConstruct
    public void init() {
        tipoRepeticiones  = new HashMap<String, String>();
        tipoRepeticiones.put("Diaria", "Diaria");
        tipoRepeticiones.put("Semanal", "Semanal");
        tipoRepeticiones.put("Mensual", "Mensual");

        Map<String,String> map = new HashMap<String, String>();
        map.put("4 dias", "4");
        map.put("3 dias", "3");
        map.put("2 dias", "2");
        map.put("1 dia", "1");
        data.put("Diaria", map);

        map = new HashMap<String, String>();
        map.put("4 semanas", "4");
        map.put("3 semanas", "3");
        map.put("2 semanas", "2");
        map.put("1 semanas", "1");
        data.put("Semanal", map);

        map = new HashMap<String, String>();
        map.put("4 meses", "4");
        map.put("3 meses", "3");
        map.put("2 meses", "2");
        map.put("1 mes", "1");
        data.put("Mensual", map);
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getTipoRepeticionSeleccionado() {
        return tipoRepeticionSeleccionado;
    }

    public void setTipoRepeticionSeleccionado(String tipoRepeticionSeleccionado) {
        this.tipoRepeticionSeleccionado = tipoRepeticionSeleccionado;
    }

    public String getCantidadRepeticiones() {
        return cantidadRepeticiones;
    }

    public void setCantidadRepeticiones(String cantidadRepeticiones) {
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    public Map<String, String> getTipoRepeticiones() {
        return tipoRepeticiones;
    }

    public Map<String, String> getCantidadesRepeticiones() {
        return cantidadesRepeticiones;
    }

    public void onTipoCambiado() {
        if(tipoRepeticionSeleccionado !=null && !tipoRepeticionSeleccionado.equals(""))
            cantidadesRepeticiones = data.get(tipoRepeticionSeleccionado);
        else
            cantidadesRepeticiones = new HashMap<String, String>();
    }
}