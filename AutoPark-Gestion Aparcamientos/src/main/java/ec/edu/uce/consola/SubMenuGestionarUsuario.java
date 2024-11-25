package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class SubMenuGestionarUsuario {

    // Estructura para almacenar las cuentas con todos sus datos
    private static Map<String, Cuenta> cuentas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarCuenta() {
        int opcion;

        do {
            System.out.println("\n============= Gestiónar Usuario ===============");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Editar Cuenta");
            System.out.println("3. Consultar Cuenta");
            System.out.println("4. Eliminar Cuenta");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("==================================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    editarCuenta();
                    break;
                case 3:
                    consultarCuenta();
                    break;
                case 4:
                    eliminarCuenta();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCuenta() {
        System.out.println("\n================== CREAR CUENTA ====================");

        // Validar nombre de usuario
        String nombreUsuario = solicitarInput("Ingrese su nombre de usuario: ", Validacion::validarNombreUsuario);

        // Validar correo
        String correo = solicitarInput("Ingrese su correo electrónico: ", Validacion::validarCorreo);

        // Validar cédula
        String cedula = solicitarInput("Ingrese su número de cédula: ", Validacion::validarCedula);

        // Validar contraseña
        String contrasenia = solicitarInput("Ingrese su contraseña: ", Validacion::validarContrasenia);

        if (cuentas.containsKey(cedula)) {
            System.out.println("La cuenta con esta cédula ya existe. Intente nuevamente.");
        } else {
            cuentas.put(cedula, new Cuenta(nombreUsuario, correo, cedula, contrasenia));
            System.out.println("Cuenta creada exitosamente.\n");
        }
    }

    private static void editarCuenta() {
        System.out.println("\n================== EDITAR CUENTA ====================");

        String cedula = solicitarInput("Ingrese la cédula de la cuenta a editar: ", Validacion::validarCedula);

        if (cuentas.containsKey(cedula)) {
            Cuenta cuenta = cuentas.get(cedula);

            System.out.println("\nEsta Editando la Cuenta");

            // Nuevos datos
            String nuevoNombreUsuario = solicitarInput("Nuevo nombre de usuario (actual: " + cuenta.getNombreUsuario() + "): ", Validacion::validarNombreUsuario);
            String nuevoCorreo = solicitarInput("Nuevo correo (actual: " + cuenta.getCorreo() + "): ", Validacion::validarCorreo);
            String nuevaContrasenia = solicitarInput("Nueva contraseña: ", Validacion::validarContrasenia);

            cuenta.setNombreUsuario(nuevoNombreUsuario);
            cuenta.setCorreo(nuevoCorreo);
            cuenta.setContrasenia(nuevaContrasenia);

            System.out.println("Cuenta actualizada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con la cédula proporcionada.");
        }
    }

    private static void consultarCuenta() {
        System.out.println("\n================== CONSULTAR CUENTA ====================");

        String cedula = solicitarInput("Ingrese la cédula para consultar: ", Validacion::validarCedula);

        if (cuentas.containsKey(cedula)) {
            Cuenta cuenta = cuentas.get(cedula);
            System.out.println("\nInformación de la cuenta:");
            System.out.println(cuenta);
        } else {
            System.out.println("No se encontró una cuenta con la cédula proporcionada.");
        }
    }

    private static void eliminarCuenta() {
        System.out.println("\n================== ELIMINAR CUENTA ====================");

        String cedula = solicitarInput("Ingrese la cédula de la cuenta a eliminar: ", Validacion::validarCedula);

        if (cuentas.containsKey(cedula)) {
            cuentas.remove(cedula);
            System.out.println("Cuenta eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con la cédula proporcionada.");
        }
    }

    private static String solicitarInput(String mensaje, Predicate<String> validador) {
        String input;

        while (true) {
            System.out.print(mensaje);
            input = scanner.nextLine();

            if (validador.test(input)) {
                break;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
        return input;
    }



    // Clase interna para almacenar los datos de una cuenta
    public static class Cuenta {
        private String nombreUsuario;
        private String correo;
        private String cedula;
        private String contrasenia;

        public Cuenta(String nombreUsuario, String correo, String cedula, String contrasenia) {
            this.nombreUsuario = nombreUsuario;
            this.correo = correo;
            this.cedula = cedula;
            this.contrasenia = contrasenia;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nuevoNombreUsuario) {
            this.nombreUsuario = nuevoNombreUsuario;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String nuevoCorreo) {
            this.correo = nuevoCorreo;
        }

        public String getCedula() {
            return cedula;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String nuevaContrasenia) {
            this.contrasenia = nuevaContrasenia;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombreUsuario + ", Correo: " + correo + ", Cédula: " + cedula;
        }
    }

    public static Cuenta obtenerCuenta(String cedula) {
        return cuentas.get(cedula); // Retorna la cuenta asociada a la cédula o null si no existe
    }
}
