package co.edu.uptcsoft.librosparroquialesjavafx.Control;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Bautismo;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Confirmacion;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.ConfirmacionPersistencia;

import java.util.ArrayList;

public class ControlConfirmacion {
    private ArrayList<Confirmacion> listaConfirmacion;
    private ConfirmacionPersistencia confirmacionPersistencia;

    public ControlConfirmacion(){
        confirmacionPersistencia = new ConfirmacionPersistencia();
        listaConfirmacion = confirmacionPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/confirmacion.json");

    }
    public boolean agregarConfirmacion(Confirmacion confirmacion) {
       if(!existeConfirmacion(confirmacion.getLibro(),confirmacion.getNumero(), confirmacion.getFolio())){
        listaConfirmacion.add(confirmacion);
        guardarEnArchivo();
        return true;
       }
       return false;
    }

    public void cargarListaConfirmacion(ArrayList<Confirmacion> listaConfirmacion) {
        this.listaConfirmacion = listaConfirmacion;
        guardarEnArchivo();
    }

    public ArrayList<Confirmacion> getListaConfirmacion() {
        return listaConfirmacion;
    }

    public void guardarEnArchivo() {
        confirmacionPersistencia.guardarListaEnArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/confirmacion.json", listaConfirmacion);
    }

    public void cargarDesdeArchivo() {
        listaConfirmacion = confirmacionPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/confirmacion.json");
    }

    public void editarConfirmacion(String libro, String numero, Confirmacion nuevaCofirmacion) {
        int index = buscarConfirmacion(libro, numero);
        if (index >= 0 && index < listaConfirmacion.size()) {
            listaConfirmacion.set(index, nuevaCofirmacion);
            guardarEnArchivo();
        }
    }

    public void eliminarConfirmacion(String libro, String numero) {
        int index = buscarConfirmacion(libro, numero);
        if (index >= 0 && index < listaConfirmacion.size()) {
            listaConfirmacion.remove(index);
            guardarEnArchivo();
        }
    }

    public int buscarConfirmacion(String folio, String numero) {
        for (int i = 0; i < listaConfirmacion.size(); i++) {
            if (listaConfirmacion.get(i).getFolio().equals(folio) && listaConfirmacion.get(i).getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }
    public boolean existeConfirmacion(String libro, String numero, String folio) {
        for (Confirmacion confirmacion: listaConfirmacion) {
            if (confirmacion.getLibro().equals(libro)&& confirmacion.getNumero().equals(numero)&&confirmacion.getFolio().equals(folio)){
                return true;
            }
        }
        return false;
    }
    // Método para mostrar los datos de la lista
    public void mostrarListaConfirmacion() {
        for (Confirmacion confirmacion : listaConfirmacion) {
            System.out.println("Libro: " + confirmacion.getLibro() + ", Número: " + confirmacion.getNumero());
        }
    }
}
