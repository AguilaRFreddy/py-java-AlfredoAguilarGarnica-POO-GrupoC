package Utils;

import Usuarios.Usuario;


/*
Proceso 1:
    Iniciar sesión
        Validamos sus datos
            1. Si todo sale correcto
                Mandar a llamar a UsuarioEnSesion
                UsuarioEnSesion.setUsuarioActua(usuario)
            2. Sino, devolvemos un error

    Editar datos
        usuario = UsuarioEnSesion.obtenerInstancia()

    Login
 */



public class UsuarioEnSesion {
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;

    private UsuarioEnSesion() {}

    public static UsuarioEnSesion obtenerInstancia() {
        if (instancia == null) {
            instancia = new UsuarioEnSesion();
        }

        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }
    
    public void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }

    public static UsuarioEnSesion getInstancia() {
        return instancia;
    }

    public static void setInstancia(UsuarioEnSesion instancia) {
        UsuarioEnSesion.instancia = instancia;
    }


}