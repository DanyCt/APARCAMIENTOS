package ec.edu.uce.dominio;

public class AutoPark {
    private  Usuario [] usuarios;
    private int capacidadTotal;


    public AutoPark (){
        this.usuarios = new Usuario[0];
        this.capacidadTotal=0;
    }

    public AutoPark(Usuario[] usuarios , int capacidadTotal) {
        this.usuarios = usuarios;
        this.capacidadTotal = capacidadTotal;
    }

   //METODOS GETTERS Y SETTERS


    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    //METODOS CRUD
    public void crearUsuario(){

    }
    public void  modificarUsuario(){

    }
    public void consultarUsuario(){

    }
    public void eliminarUsuario(){

    }
}
