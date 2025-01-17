package Usuarios;
import Usuarios.Utils.Rol;
// import Utils.*;
public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String telefono, Rol rol,String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, Rol: %s , usuario %s, contrasena %s ",
                id, nombre, apellido, telefono, rol, nombreUsuario, contrasena);
    }

    public static int getCantidadUsuarios() {
        return CANTIDAD_USUARIOS;
    }

    public static void setCantidadUsuarios(int cantidadUsuarios) {
        CANTIDAD_USUARIOS = cantidadUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public static int getCANTIDAD_USUARIOS() {
        return CANTIDAD_USUARIOS - 1;
    }
    public void setCANTIDAD_USUARIOS() {
        CANTIDAD_USUARIOS--;
    }
    public void setId() {
        this.id = id - 1;
    }
    public static void setCANTIDAD_USUARIOS(int cANTIDAD_USUARIOS) {
        CANTIDAD_USUARIOS = cANTIDAD_USUARIOS;
    }
    
    
}