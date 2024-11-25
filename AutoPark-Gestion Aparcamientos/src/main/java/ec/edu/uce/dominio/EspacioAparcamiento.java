package ec.edu.uce.dominio;

public class EspacioAparcamiento {
    private String numeroEspacio;
    private String ubicacion;
    private  Boolean estado;

    public EspacioAparcamiento() {
        this.numeroEspacio = "A1";
        this.ubicacion = "Seccion A";
        this.estado = false;
    }

    public EspacioAparcamiento(String numeroEspacio ,String ubicacion , Boolean estado ) {
        this.numeroEspacio = numeroEspacio;
         this.ubicacion = ubicacion;
         this.estado= estado;
    }

    //METODOS GETTERS Y STETERS


    public String getNumeroEspacio() {
        return numeroEspacio;
    }

    public void setNumeroEspacio(String numeroEspacio) {
        this.numeroEspacio = numeroEspacio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    //METODOS
    public void asignarEspacio(){

    }
    public void liberarEspacio(){

    }
    public void verificarDisponibilidad(){

    }
}
