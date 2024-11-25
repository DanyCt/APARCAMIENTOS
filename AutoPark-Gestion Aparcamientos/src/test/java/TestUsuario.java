import ec.edu.uce.dominio.Usuario;


class TestUsuario {


    void testConstructorPorDefecto() {
        Usuario usuario = new Usuario();
        System.out.println(0 + usuario.getIdUsuario());
        System.out.println("Pepe"+ usuario.getNombre());
        System.out.println("Pepe@gmail.com"+ usuario.getCorreo());
        System.out.println("Pepe123"+ usuario.getContrasenia());
    }


    void testConstructorConParametros() {
        Usuario usuario = new Usuario(1, "Juan", "juan@gmail.com", "Juan123");
        System.out.println(1 +  usuario.getIdUsuario());
        System.out.println("Juan"+ usuario.getNombre());
        System.out.println("juan@gmail.com"+ usuario.getCorreo());
        System.out.println("Juan123"+ usuario.getContrasenia());
    }

    void testSettersAndGetters() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNombre("Maria");
        usuario.setCorreo("maria@gmail.com");
        usuario.setContrasenia("Maria123");

        System.out.println(2+ usuario.getIdUsuario());
        System.out.println("Maria"+ usuario.getNombre());
        System.out.println("maria@gmail.com"+ usuario.getCorreo());
        System.out.println("Maria123"+ usuario.getContrasenia());
    }
}



