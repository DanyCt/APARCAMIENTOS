package ec.edu.uce.dominio;

public class Vehiculo {
    private String numeroMatricula;
    private  String tipoVehiculo;

    public Vehiculo() {
        this.numeroMatricula = "ABC123";
        this.tipoVehiculo = "sin";
    }

    public Vehiculo(String numeroMatricula, String tipoVehiculo) {
        this.numeroMatricula = numeroMatricula;
        this.tipoVehiculo = tipoVehiculo;
    }

    //GETTERS Y SETTERS


    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    //CRUD
    public void estacionar(){

    }
}
