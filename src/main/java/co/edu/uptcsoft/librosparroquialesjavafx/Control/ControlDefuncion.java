package co.edu.uptcsoft.librosparroquialesjavafx.Control;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Defuncion;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Matrimonio;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.DefuncionPersistencia;

import java.util.ArrayList;

public class ControlDefuncion {

    private ArrayList<Defuncion> listaDefuncion;
    private DefuncionPersistencia defuncionPersistencia;

    public ControlDefuncion() {
        defuncionPersistencia = new DefuncionPersistencia();
        listaDefuncion = defuncionPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Defuncion.json");
    }

    public boolean agregarDefuncion(Defuncion defuncion) {
        if (!existeDefuncion(defuncion.getLibro(), defuncion.getNumero(), defuncion.getFolio())) {
            listaDefuncion.add(defuncion);
            guardarEnArchivo();
            return true; // Indica que la defuncion se agregó exitosamente
        }
        return false; // Indica que ya existe una defuncion con los mismos datos
    }

    public void cargarListaDefuncion(ArrayList<Defuncion> listaDefuncion) {
        this.listaDefuncion = listaDefuncion;
        guardarEnArchivo();
    }

    public ArrayList<Defuncion> getListaDefuncion() {
        return listaDefuncion;
    }

    public void guardarEnArchivo() {
        defuncionPersistencia.guardarListaEnArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Defuncion.json", listaDefuncion);
    }

    public void cargarDesdeArchivo() {
        listaDefuncion = defuncionPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Defuncion.json");
    }

    public void editarDefuncion(String folio, String numero, Defuncion nuevoDefuncion) {
        int index = buscarDefuncion(folio, numero);
        if (index >= 0 && index < listaDefuncion.size()) {
            listaDefuncion.set(index, nuevoDefuncion);
            guardarEnArchivo();
        }
    }

    public void eliminarDefuncion(String folio, String numero) {
        int index = buscarDefuncion(folio, numero);
        if (index >= 0 && index < listaDefuncion.size()) {
            listaDefuncion.remove(index);
            guardarEnArchivo();
        }
    }

    public int buscarDefuncion(String folio, String numero) {
        for (int i = 0; i < listaDefuncion.size(); i++) {
            if (listaDefuncion.get(i).getFolio().equals(folio) && listaDefuncion.get(i).getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public boolean existeDefuncion(String libro, String numero, String folio) {
        for (Defuncion defuncion : listaDefuncion) {
            if (defuncion.getLibro().equals(libro) && defuncion.getNumero().equals(numero) && defuncion.getFolio().equals(folio)) {
                return true;
            }
        }
        return false;
    }

    public Defuncion getDefuncionByNumero(String numero) {
        for (Defuncion defuncion : listaDefuncion) {
            if (defuncion.getNumero().equals(numero)) {
                return defuncion;
            }
        }
        return null;
    }

    // Método para mostrar los datos de la lista
    public void mostrarListaDefuncion() {
        for (Defuncion defuncion : listaDefuncion) {
            System.out.println("Libro: " + defuncion.getLibro() + ", Número: " + defuncion.getNumero() + ", Folio: " + defuncion.getFolio());
        }
    }
}
