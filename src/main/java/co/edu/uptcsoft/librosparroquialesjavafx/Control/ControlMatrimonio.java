package co.edu.uptcsoft.librosparroquialesjavafx.Control;



import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Matrimonio;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.MatrimonioPersistencia;

import java.util.ArrayList;

public class ControlMatrimonio {
    private ArrayList<Matrimonio> listaMatrimonio;
    private MatrimonioPersistencia matrimonioPersistencia;

    public ControlMatrimonio() {
        matrimonioPersistencia = new MatrimonioPersistencia();
        listaMatrimonio = matrimonioPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/matrimonioData.json");
    }

    public void agregarMatrimonio(Matrimonio matrimonio) {
        listaMatrimonio.add(matrimonio);
        guardarEnArchivo();
    }

    public void cargarListaMatrimonio(ArrayList<Matrimonio> listaMatrimonio) {
        this.listaMatrimonio = listaMatrimonio;
        guardarEnArchivo();
    }

    public ArrayList<Matrimonio> getListaMatrimonio() {
        return listaMatrimonio;
    }

    public void guardarEnArchivo() {
        matrimonioPersistencia.guardarListaEnArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/matrimonioData.json", listaMatrimonio);
    }

    public void cargarDesdeArchivo() {
        listaMatrimonio = matrimonioPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/matrimonioData.json");
    }

    public void editarMatrimonio(String numero, Matrimonio nuevoMatrimonio) {
        int index = buscarMatrimonio(numero);
        if (index >= 0 && index < listaMatrimonio.size()) {
            listaMatrimonio.set(index, nuevoMatrimonio);
            guardarEnArchivo();
        }
    }

    public void eliminarMatrimonio(String numero) {
        int index = buscarMatrimonio(numero);
        if (index >= 0 && index < listaMatrimonio.size()) {
            listaMatrimonio.remove(index);
            guardarEnArchivo();
        }
    }

    public int buscarMatrimonio( String numero) {
        for (int i = 0; i < listaMatrimonio.size(); i++) {
            if (listaMatrimonio.get(i).getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    // Método para mostrar los datos de la lista
    public void mostrarListaMatrimonio() {
        for (Matrimonio matrimonio : listaMatrimonio) {
            System.out.println("Libro: " + matrimonio.getLibro() + ", Número: " + matrimonio.getNumero());
        }
    }

    public Matrimonio getMatrimonioByNumero(String numero) {
        for (Matrimonio matrimonio : listaMatrimonio) {
            if (matrimonio.getNumero().equals(numero)) {
                return matrimonio;
            }
        }
        return null;
    }

    public Matrimonio obtenerMatrimonio(String numero) {
        for (Matrimonio matrimonio : listaMatrimonio) {
            if (matrimonio.getNumero().equals(numero)) {
                return matrimonio;
            }
        }
        return null;
    }
}

