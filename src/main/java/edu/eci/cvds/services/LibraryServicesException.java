package edu.eci.cvds.services;

public class LibraryServicesException extends Exception {
    public static final String ERROR_DE_PERSISTENCIA="Hubo un error en la base de datos";
    public static final String CAPACIDAD_NEGATIVA="La capacidad no puede ser negativa";
    public static final String SIN_NOMBRE="El nombre de un recurso no puede ser vacio";
    public static final String RECURSO_RESERVADO_EN_HORA="El recurso ya se encuentra reservado a esa hora";
    public static  final String RESERVA_MAYOR_A_DOS_HORAS="Una reserva no puede ser mayor a dos horas";
    public static final String RESERVA_FUERA_DE_FECHA="La reserva no se puede realizar en fechas anteriores";
    public static final String RESERVA_FUERA_DE_HORARIOS="La reserva no se puede hacer fuera de los horarios del recurso";
    public static final String HORARIO_FUERA_DE_HORAS="Los horarios no se pueden colocar fuera de los horarios de clase";
    public static final String ERROR_DE_HORAS_HORARIO="Error en el orden de las horas";
    public static final String ERROR_EN_IO="Error en la escritura del archivo";
    public static final String RECURSO_ELIMINADO="Ese recurso fue eliminado permanentemente comuniquese con su ingeniero de sistemas";
    private String causeE;

    /**
     * Constructor de la clase LibraryServicesException
     * @param Message String el mensaje del error
     */
    public LibraryServicesException(String Message){
        super(Message);
    }

    public LibraryServicesException(String Message,String cause){
        super(Message);
        this.causeE=cause;
    }

    /**
     * Getter de la causa del error
     * @return Un string que es la causa del error
     */
    public String getCauseE() {
        return causeE;
    }

    /**
     * Setter de la causa del error
     * @param causeE la causa del error
     */
    public void setCauseE(String causeE) {
        this.causeE = causeE;
    }
}

