package ec.edu.uce.dominio;

import java.util.Date;

public class Ticket {
    private int idTicket;
    private Date fechaIngreso;
//    private int horaIngreso;
    private float montoTotal;
    private  float tarifaHora;
    private  Date fechaSalida;
    private String numeroMatricula;
    private String espacioAparcamiento;

    public Ticket() {
        this.idTicket = 0;
        this.fechaIngreso = new Date( 2024,01,01, 18,55 );
        this.montoTotal = 10f;
        this.tarifaHora = 1.5f;
        this.fechaSalida =  new Date(2024 , 01, 01,19, 55);
        this.numeroMatricula ="ABC123";
        this.espacioAparcamiento = "A1";

    }

    public Ticket(int idTicket, Date fechaIngreso, float montoTotal, float tarifaHora, Date fechaSalida, String numeroMatricula , String espacioAparcamiento) {
        this.idTicket = idTicket;
        this.fechaIngreso = fechaIngreso;
        this.montoTotal = montoTotal;
        this.tarifaHora = tarifaHora;
        this.fechaSalida = fechaSalida;
        this.numeroMatricula = numeroMatricula;
        this.espacioAparcamiento = espacioAparcamiento;
    }

   //METODOS GGETER Y SETTERS

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(float tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getEspacioAparcamiento() {
        return espacioAparcamiento;
    }

    public void setEspacioAparcamiento(String espacioAparcamiento) {
        this.espacioAparcamiento = espacioAparcamiento;
    }

    //METODOS CRUD
    public void crearTicket(){
    }
    public void consultarTicket(){

    }
}
