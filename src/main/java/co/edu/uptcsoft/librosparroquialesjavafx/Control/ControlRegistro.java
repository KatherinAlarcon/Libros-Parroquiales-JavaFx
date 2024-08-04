package co.edu.uptcsoft.librosparroquialesjavafx.Control;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Usuario;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.RegistroPersistencia;

public class ControlRegistro {

    private RegistroPersistencia registroPersistencia;

    public ControlRegistro() {
        registroPersistencia = new RegistroPersistencia();
    }

    public boolean registrarUsuario (String nombreUsuario, String contraseñaUsuario, String confirmaraContraseña) {
        if (!contraseñaUsuario.equals(confirmaraContraseña)) {
            return false;
        }

        Usuario usuarioExistente = registroPersistencia.obtenerUsuario(nombreUsuario);
        if (usuarioExistente != null) {
            return false;
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseñaUsuario);
        registroPersistencia.agregarUsuario(nuevoUsuario);
        return true;

    }


    public Usuario obtenerUsuario(String nombreUsuario) {
        return registroPersistencia.obtenerUsuario(nombreUsuario);
    }
}
