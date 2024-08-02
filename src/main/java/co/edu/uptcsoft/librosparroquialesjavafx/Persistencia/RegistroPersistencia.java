package co.edu.uptcsoft.librosparroquialesjavafx.Persistencia;


import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RegistroPersistencia {
    private List<Usuario> usuarios;
    private static final String FILE_PATH = "src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/usuarios.json";
    private Gson gson= new GsonBuilder().setPrettyPrinting().create();

    private void createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write("[]");
            }
        }
    }

    public RegistroPersistencia() {
        usuarios = cargarUsuarios();
    }

    public void agregarUsuario(Usuario usuario) {
        if (obtenerUsuario(usuario.getNombreUsuario()) == null) {
            usuarios.add(usuario);
            guardarUsuarios();
        }
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    private void guardarUsuarios() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(usuarios, writer);
            System.out.println("Usuarios guardados: " + usuarios);
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private List<Usuario> cargarUsuarios() {
        try  {
            createFileIfNotExists(FILE_PATH);
            try(FileReader reader = new FileReader(FILE_PATH)) {
                List<Usuario> usuariosCargados = gson.fromJson(reader, new TypeToken<List<Usuario>>(){}.getType());
                return usuariosCargados != null ? usuariosCargados: new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}