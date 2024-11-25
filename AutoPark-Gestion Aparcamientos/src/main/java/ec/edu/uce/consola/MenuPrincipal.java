package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;

import java.util.Scanner;

public class MenuPrincipal {
    private final MenuCasosUso menuCasosUso;
    private final Scanner scanner = new Scanner(System.in);

    // Variables estáticas para almacenar los datos del usuario registrado
    private static String nombreUsuario;
    private static String correoRegistrado;
    private static String contraseniaRegistrada;

    public MenuPrincipal(MenuCasosUso menuCasosUso) {
        this.menuCasosUso = menuCasosUso;
    }

    public void mostrarMenuPrincipal() {
        System.out.println("==================================================");
        System.out.println("                    MENU PRINCIPAL                ");
        System.out.println("==================================================");
        System.out.println("1. Registrarse");
        System.out.println("2. Ingresar al Sistema");
        System.out.println("3. Salir");
        System.out.println("==================================================");
        System.out.print("Seleccione una opción (1-3): ");
    }

    private void seleccionarMenu() {
        int opcion = -1;
        do {
            mostrarMenuPrincipal();
            while (!scanner.hasNextInt()) {
                System.out.println("Opción no válida. Ingrese un número entero positivo.");
                scanner.next(); // Limpia el buffer
                mostrarMenuPrincipal();
            }
            opcion = scanner.nextInt();
            if (opcion <= 0 || opcion > 3) {
                System.out.println("Opción no válida. Seleccione entre 1 y 3.");
                continue;
            }
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    registrarse();
                    break;
                case 2:
                    ingresar();
                    break;
                case 3:
                    System.out.println("Gracias por usar AutoPark.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void registrarse() {
        System.out.println("== REGISTRO DE USUARIO ==");

        // Validar nombre de usuario
        nombreUsuario = solicitarInput("Ingrese su nombre de usuario: ", Validacion::validarNombreUsuario);

        // Validar correo
        correoRegistrado = solicitarInput("Ingrese su correo electrónico: ", Validacion::validarCorreo);

        // Validar contraseña
        contraseniaRegistrada = solicitarInput("Ingrese su contraseña: ", Validacion::validarContrasenia);

        System.out.println("Usuario registrado exitosamente.");
    }

    private void ingresar() {
        System.out.println("== INICIO DE SESIÓN ==");
        String correo;
        String contrasenia;

        do {
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contrasenia = scanner.nextLine();

            // Verificar si el correo y la contraseña coinciden con los registrados
            if (correo.equals(correoRegistrado) && contrasenia.equals(contraseniaRegistrada)) {
                System.out.println("Inicio de sesión exitoso.");
                menuCasosUso.mostrarMenuCasosUso();
                return;
            } else {
                System.out.println("Correo o contraseña no válidos. Inténtelo nuevamente.");
            }
        } while (true);
    }

    private String solicitarInput(String mensaje, ValidacionInterface validacion) {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine();
            if (!validacion.validar(input)) {
                System.out.println("Por favor, intente nuevamente.");
            }
        } while (!validacion.validar(input));
        return input;
    }

    @FunctionalInterface
    interface ValidacionInterface {
        boolean validar(String input);
    }

    public static void main(String[] args) {
        MenuCasosUso menuCasosUso = new MenuCasosUso();
        new MenuPrincipal(menuCasosUso).seleccionarMenu();
    }
}
