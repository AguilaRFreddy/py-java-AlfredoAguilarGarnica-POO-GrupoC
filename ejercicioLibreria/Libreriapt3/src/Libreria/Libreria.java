
package Libreria;
// import Usuarios.*;

import java.util.ArrayList;
import java.util.Scanner;

import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;
import Utils.UsuarioEnSesion;

public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public Libreria() {
       
        // Asistente asistente = new Asistente("Juan", "Rivera", "4433210999", 15000, "RUJU1234123", "juan123", "12345");
        Asistente asistente = new Asistente(null, null, null, null, null, null, null, null)
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

    
    // - Registrar asistentes (gerente)
    public void registrarGerente() {
       

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Gerente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena");
        String contrasena = scanner.nextLine();

        System.out.println("Ingresa INE");
        String ine = scanner.nextLine();

        System.out.println("Ingresa RFC");
        String rfc = scanner.nextLine();

        System.out.println("Ingresa sueldo");
        Double sueldo = scanner.nextDouble();

        Gerente gerente = new Gerente(nombre, apellido, telefono, rfc, ine, sueldo, nombreUsuario, contrasena)
        usuarios.add(gerente);
        System.out.println("\nGerente registrado exitosamente\n");
    }

    public void registrarAsistente() {
       

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Asistente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena");
        String contrasena = scanner.nextLine();

        System.out.println("Ingresa INE");
        String ine = scanner.nextLine();

        System.out.println("Ingresa RFC");
        String rfc = scanner.nextLine();

        System.out.println("Ingresa sueldo");
        double sueldo = scanner.nextDouble();

        Asistente asistente = new Asistente(nombre, apellido, telefono,sueldo , rfc, ine, nombreUsuario, contrasena);
        usuarios.add(asistente);
        System.out.println("\nAsistente registrado exitosamente\n");
    }

  // registrar libro

  public void registrarLibro(){
    Scanner scanner = new Scanner(System.in);
System.out.println("");
String titulo = scanner.nextLine();
System.out.println("");
double precio = scanner.nextDouble();
System.out.println("");
String autor = scanner.nextLine();
Libro libro = new Libro(titulo,precio, autor);
libros.add(libro);
  }
  
  public void consultarLlibros(){
    for (Libro i : libros) {
        i.obtenerLibro();
    }
  }


  public void eliminarUsuario (Rol rol) {
    Scanner scanner = new Scanner(System.in);
    boolean band = false;
    System.out.println("\n---- Eliminar usuario ----\n");
    System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
    String nombreUsuario = scanner.nextLine();
    for (Usuario i : usuarios) {
        if (i.getNombreUsuario().equals(nombreUsuario)) {
            band = true;
            if (i.getRol() == Rol.CLIENTE && rol == Rol.CLIENTE) {
                int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
                int y = i.getId();
                i.setCANTIDAD_USUARIOS();
                usuarios.remove(i);
                for(int c = 0; c < x; c++) {
                    usuarios.get(y - 1).setId();;
                    y++;
                }
            }
            else if (i.getRol() == Rol.ASISTENTE && rol == Rol.ASISTENTE) {
                int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
                int y = i.getId();
                i.setCANTIDAD_USUARIOS();
                usuarios.remove(i);
                for(int c = 0; c < x; c++) {
                    usuarios.get(y - 1).setId();;
                    y++;
                }                    
            }   
            else {
                if (!UsuarioEnSesion.getNombreUsuario().equals(nombreUsuario)) {
                    int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
                    int y = i.getId();
                    i.setCANTIDAD_USUARIOS();
                    usuarios.remove(i);
                    for(int c = 0; c < x; c++) {
                        usuarios.get(y - 1).setId();
                        y++;
                    }
                }
                else {
                    System.out.println("\nNo puedes eliminarte a ti mismo");
                    break;
                }
            }
            System.out.println("\nUsuario eliminado");
            break;
        }
    }
    if(band == false) {
        System.out.println("\nEste nombre no pertenece a ningún usuario");
    }
}

   
    // - Listado de asisntentes y gerentes

    public void mostrarAsitentes() {
        System.out.println("\nAsistentes en la Biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }
    public void mostrarGerente() {
        System.out.println("\nAsistentes en la Biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.GERENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }
    
    


}