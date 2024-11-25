package ec.edu.uce.util;
import ec.edu.uce.dominio.Usuario;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private static final String USUARIO_REGEX = "^[A-Z][a-zA-Z0-9._-]{2,}$";
    private static final String CONTRASENA_REGEX = "^[A-Z][A-Za-z0-9$._\\-!]{7,}$"; // Corrige el patrón de contraseña
    private static final String CORREO_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String CEDULA_REGEX = "^\\d{10}$";
    private static final int ESPACIO_MINIMO = 1;
    private static final int ESPACIO_MAXIMO = 50;




    public static boolean validarNombreUsuario(String usuario) {
        Pattern pattern = Pattern.compile(USUARIO_REGEX);
        Matcher matcher = pattern.matcher(usuario);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("""
                    El nombre de usuario no es válido.
                    - Debe iniciar con una letra mayúscula.
                    - Puede contener letras minúsculas, dígitos y caracteres especiales como . _ -.
                    - Debe tener más de 2 caracteres.
                    """);
            return false;
        }
    }

    public static boolean validarContrasenia(String contrasenia) {
        Pattern pattern = Pattern.compile(CONTRASENA_REGEX);
        Matcher matcher = pattern.matcher(contrasenia);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("""
                  La contraseña ingresada no es válida.
                  - Debe tener al menos 8 caracteres.
                  - Debe iniciar con una letra mayúscula.
                  - Puede contener caracteres especiales como $ . _ - !.
                  """);
            return false;
        }
    }

    public static boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile(CORREO_REGEX);
        Matcher matcher = pattern.matcher(correo);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("""
                 El correo electrónico no es válido.
                 - Debe tener un formato (ejemplo@dominio.com).
                 """);
        }
        return false;
    }


    public static boolean validarCedula(String cedula) {
        Pattern pattern = Pattern.compile(CEDULA_REGEX);
        Matcher matcher = pattern.matcher(cedula);

        if (matcher.matches()) {
            // Verificación adicional según la lógica de cédulas ecuatorianas
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) {
                System.out.println("""
                La cédula no es válida.
                - Los dos primeros dígitos deben corresponder a una provincia (01-24).
                """);
                return false;
            }

            int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
            int suma = 0;

            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i + 1));
                if (i % 2 == 0) { // Posiciones pares (0-indexed) multiplican por 2
                    digito *= 2;
                    if (digito > 9) {
                        digito -= 9;
                    }
                }
                suma += digito;
            }

            int modulo10 = suma % 10;
            int resultado = modulo10 == 0 ? 0 : 10 - modulo10;

            if (resultado == digitoVerificador) {
                return true; // La cédula es válida
            } else {
                System.out.println("""
                La cédula no es válida.
                - El dígito verificador no coincide.
                """);
                return false;
            }
        } else {
            System.out.println("""
            La cédula no es válida.
            - Debe contener exactamente 10 dígitos numéricos.
            """);
        }
        return false;
    }




    public static boolean validarCredenciales(String correo, String contrasena) {
        return "Ejemplo-usuario".equals(correo) && "Ejemplo-contrasena".equals(contrasena);
    }



    public boolean validarEspacio(int espacio) {
        return espacio >= ESPACIO_MINIMO && espacio <= ESPACIO_MAXIMO;
    }


    public String validarEstado(int opcion) {
        switch (opcion) {
            case 1:
                return "Disponible";
            case 2:
                return "No disponible";
            default:
                return null;
        }
    }




    public static boolean validarelUsuario(Usuario[] usuarios, int numUsuarios, String contrasenia, String correo) {
        if (usuarios == null || numUsuarios == 0) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return false;
        }

        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getContrasenia().equals(contrasenia) && usuarios[i].getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarPlaca( String placa){
        if (placa == null || placa.isEmpty()){
            return false;
        }
        String regex ="^[A-Z\0-9]";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

    public static boolean validarMarca(String marca){
        if( marca ==null || marca.isEmpty()){
            return false;
        }
        String regex= "^[A-Za-z\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(marca);
        return matcher.matches();
    }

    public static boolean validarTipoVehiculo(String tipoVehiculo){
        if( tipoVehiculo ==null || tipoVehiculo.isEmpty()){
            return false;
        }
        String regex= "^[A-Za-z\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(tipoVehiculo);
        return matcher.matches();
    }

    public static boolean validarId(int id) {
        if (id <= 0) {
            System.out.println("Error , el id no puede ser un numero negativo");
            return false;
        }
        return true;
    }


    public static boolean validarNumeroEspacio(int numeroEspacio) {
        if (numeroEspacio <= 0) {
            System.out.println("El número de espacio debe ser mayor a cero.");
            return false;
        }
        return true;
    }

    public static boolean validarUbicacion(String ubicacion) {
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            System.out.println("La ubicación no puede estar vacía.");
            return false;
        }
        String regex = "^[A-Za-z0-9\\s\\-,]+$"; // Acepta letras, números, espacios, guiones y comas
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ubicacion);
        if (!matcher.matches()) {
            System.out.println("La ubicación contiene caracteres no válidos.");
            return false;
        }
        return true;
    }

    public static boolean validarEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            System.out.println("El estado no puede estar vacío.");
            return false;
        }
        // Validar que el estado esté dentro de un conjunto permitido
        String[] estadosValidos = {"ocupado", "disponible", "reservado", "mantenimiento"};
        for (String estadoValido : estadosValidos) {
            if (estadoValido.equalsIgnoreCase(estado)) {
                return true;
            }
        }
        System.out.println("El estado ingresado no es válido. Estados válidos: ocupado, disponible, reservado, mantenimiento.");
        return false;
    }

    public static boolean validarFecha(Date fecha) {
        if (fecha == null) {
            System.out.println("La fecha no puede ser nula.");
            return false;
        }
        Date fechaActual = new Date();
        if (fecha.after(fechaActual)) {
            System.out.println("La fecha no puede ser una fecha futura.");
            return false;
        }
        return true;
    }

    public static boolean validarIdTicket(int idTicket) {
        if (idTicket <= 0) {
            System.out.println("El ID del ticket debe ser un número positivo.");
            return false;
        }
        return true;
    }

    public static boolean validarMontoTotal(int montoTotal) {
        if (montoTotal < 0) {
            System.out.println("El monto total no puede ser negativo.");
            return false;
        }
        return true;
    }

    public static boolean validarTarifaHora(int tarifaHora) {
        if (tarifaHora <= 0) {
            System.out.println("La tarifa por hora debe ser un valor mayor a cero.");
            return false;
        }
        return true;
    }
}


