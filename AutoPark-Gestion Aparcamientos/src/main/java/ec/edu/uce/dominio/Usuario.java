package ec.edu.uce.dominio;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;


    public Usuario() {
        this.idUsuario=0;
        this.nombre= "Pepe";
        this.correo="Pepe@gmail.com";
        this.contrasenia ="Pepe123";
    }


    public Usuario(int idUsuario , String nombre ,String correo, String contrasenia ) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia= contrasenia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //METODOS CRUD
    public void gestionarCuenta(){

    }

public void gestionarAcceso(){

    }
    public void gestionarCobro(){

    }
public void gestionarEspacioAparcamiento(){

}
public void registrarEntrada(){

}

public void registrarSalida(){

}
}
