import ec.edu.uce.consola.SubMenuGestionarUsuario;
import ec.edu.uce.consola.SubMenuGestionarUsuario.Cuenta;

public class TestAutoPark {
        public static void main(String[] args) {

                // Crear un mapa de cuentas simulado
                SubMenuGestionarUsuario subMenuGestionarUsuario = new SubMenuGestionarUsuario();

                // Crear cuentas de prueba
                Cuenta cuenta1 = new Cuenta("Alice", "alice@example.com", "1234567890", "Pass123@");
                Cuenta cuenta2 = new Cuenta("Bob", "bob@example.com", "0987654321", "Secure456$");

                // Registrar cuentas en el sistema
                SubMenuGestionarUsuario.obtenerCuenta("1234567890");
                SubMenuGestionarUsuario.obtenerCuenta("0987654321");


                // Pruebas de CRUD
                System.out.println("\n===== Prueba de Métodos CRUD =====");

                // Crear cuenta nueva
                System.out.println("\nEjecutando método crearCuenta...");
                subMenuGestionarUsuario.gestionarCuenta();

                // Editar una cuenta existente
                System.out.println("\nEjecutando método editarCuenta...");
                subMenuGestionarUsuario.gestionarCuenta();

                // Consultar una cuenta existente
                System.out.println("\nEjecutando método consultarCuenta...");
                subMenuGestionarUsuario.gestionarCuenta();

                // Eliminar una cuenta
                System.out.println("\nEjecutando método eliminarCuenta...");
                subMenuGestionarUsuario.gestionarCuenta();


        }
}
