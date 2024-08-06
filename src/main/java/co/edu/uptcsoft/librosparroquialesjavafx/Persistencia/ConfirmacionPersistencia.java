package co.edu.uptcsoft.librosparroquialesjavafx.Persistencia;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Bautismo;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Confirmacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConfirmacionPersistencia {

    public void guardarListaEnArchivo(String filename, ArrayList<Confirmacion> listaConfirmacion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(listaConfirmacion, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Confirmacion> cargarDesdeArchivo(String filename) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Confirmacion>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, devolvemos una lista vacía
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("El archivo JSON no tiene el formato esperado.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}