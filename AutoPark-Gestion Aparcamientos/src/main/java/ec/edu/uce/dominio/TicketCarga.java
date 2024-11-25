package ec.edu.uce.dominio;

public class TicketCarga {
    private double tarifaEspecial;
    private float tarifaHoraCarga;

    public TicketCarga() {
        this.tarifaEspecial = 0;
        this.tarifaHoraCarga = 1.5f;
    }

    public TicketCarga(double tarifaEspecial, float tarifaHoraCarga) {
        this.tarifaEspecial = tarifaEspecial;
        this.tarifaHoraCarga = tarifaHoraCarga;
    }

    //GETTERS Y SETTERS

    public double getTarifaEspecial() {
        return tarifaEspecial;
    }

    public void setTarifaEspecial(double tarifaEspecial) {
        this.tarifaEspecial = tarifaEspecial;
    }

    public float getTarifaHoraCarga() {
        return tarifaHoraCarga;
    }

    public void setTarifaHoraCarga(float tarifaHoraCarga) {
        this.tarifaHoraCarga = tarifaHoraCarga;
    }
    //METODOS CRUD
    public void aplicarTarifaEspecial(){

    }
}
