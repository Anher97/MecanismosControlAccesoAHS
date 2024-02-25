import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Autenticacion {
    // Base de datos simulada para usuarios y contraseñas
    private Map<String, String> usuarios = new HashMap<>();

    public Autenticacion() {
        // Inicialización de usuarios y contraseñas
        usuarios.put("usuario1", "contraseña1");
        usuarios.put("usuario2", "contraseña2");
    }

    // Método para autenticar usuarios
    public boolean auntentUsuario(String nombre, String contraseña) {
        // Verificar si el usuario existe y la contraseña es correcta
        return usuarios.containsKey(nombre) && usuarios.get(nombre).equals(contraseña);
    }

    public static void main(String[] args) {
        Autenticacion authSystem = new Autenticacion();
        Scanner scanner = new Scanner(System.in);
        // Crear las variables del sistema de autenticación
        boolean sesionIniciada = false;
        int contador = 0;
        // Inicializar el sistema de autenticación
        System.out.println("Bienvenido al sistema de autenticación.");

        // Bucle principal del sistema de autenticación
        // Si el numero de intentos llega a 3, cerrar el sistema
        while (!sesionIniciada && contador < 3) {
            // Solicitar credenciales al usuario

            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            // Autenticar al usuario
            if (authSystem.auntentUsuario(nombre, contraseña)) {
                System.out.println("¡Inicio de sesión exitoso!");
                sesionIniciada = true;
                // Aquí se modifica el valor de sesión iniciada para romper el bucle
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
                contador++;
                // Si el usuario es incorrecto, incrementar el contador de intentos y notificar al usuario
            }
        }
        // Notificación de cierre de sistema
        if (contador == 3) {
            System.out.println("Demasiados intentos fallidos. Cerrando el sistema");
        }

        scanner.close();
    }
}
