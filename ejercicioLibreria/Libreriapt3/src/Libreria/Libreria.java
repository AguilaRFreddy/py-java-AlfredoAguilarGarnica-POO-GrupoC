
package Libreria;
import Usuarios.*;

import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Libreria() {
       
        // Asistente asistente = new Asistente("Juan", "Rivera", "4433210999", 15000, "RUJU1234123", "juan123", "12345");
        Asistente asistente = new Asistente(null, null, null, null, null, null, null, null, null);
        usuarios.add(asistente);
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                if (usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
                return null;
            }
        }

        return null;
    }

    public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Cliente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena");
        String contrasena = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);
        usuarios.add(cliente);
        System.out.println("\nClient registrado exitosamente\n");
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la Biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }

    private String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);

        boolean telefonoExistente = true;
        String telefono = "";
        do {
            System.out.println("Ingresa el teléfono");
            telefono = scanner.nextLine();

            telefonoExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("El telefono ya se encuentra registrado. Intenta de nuevo.");
            }
        } while(telefonoExistente);

        return telefono;
    }

    private String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);

        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.println("Ingresa el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
            }
        } while(nombreUsuarioExistente);

        return nombreUsuario;
    }
}