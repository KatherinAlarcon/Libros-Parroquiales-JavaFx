package co.edu.uptcsoft.librosparroquialesjavafx.Control;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Bautismo;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.BautismoPersistencia;

import java.util.ArrayList;

public class ControlBautismo {

    private ArrayList<Bautismo> listaBautismo;
    private BautismoPersistencia bautismoPersistencia;

    public ControlBautismo() {
        bautismoPersistencia = new BautismoPersistencia();
        listaBautismo = bautismoPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Bautismo.json");
    }

    public boolean agregarBautismo(Bautismo bautismo) {
        if (!existeBautismo(bautismo.getLibro(), bautismo.getNumero(), bautismo.getFolio())) {
            listaBautismo.add(bautismo);
            guardarEnArchivo();
            return true; // Indica que el bautismo se agregó exitosamente
        }
        return false; // Indica que ya existe un bautismo con los mismos datos
    }

    public void cargarListaBautismo(ArrayList<Bautismo> listaBautismo) {
        this.listaBautismo = listaBautismo;
        guardarEnArchivo();
    }

    public ArrayList<Bautismo> getListaBautismo() {
        return listaBautismo;
    }

    public void guardarEnArchivo() {
        bautismoPersistencia.guardarListaEnArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Bautismo.json", listaBautismo);
    }

    public void cargarDesdeArchivo() {
        listaBautismo = bautismoPersistencia.cargarDesdeArchivo("src/main/java/co/edu/uptcsoft/librosparroquialesjavafx/Persistencia/Bautismo.json");
    }

    public void editarBautismo(String folio, String numero, Bautismo nuevoBautismo) {
        int index = buscarBautismo(folio, numero);
        if (index >= 0 && index < listaBautismo.size()) {
            listaBautismo.set(index, nuevoBautismo);
            guardarEnArchivo();
        }
    }

    public void eliminarBautismo(String folio, String numero) {
        int index = buscarBautismo(folio, numero);
        if (index >= 0 && index < listaBautismo.size()) {
            listaBautismo.remove(index);
            guardarEnArchivo();
        }
    }

    public int buscarBautismo(String folio, String numero) {
        for (int i = 0; i < listaBautismo.size(); i++) {
            if (listaBautismo.get(i).getFolio().equals(folio) && listaBautismo.get(i).getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public boolean existeBautismo(String libro, String numero, String folio) {
        for (Bautismo bautismo : listaBautismo) {
            if (bautismo.getLibro().equals(libro) && bautismo.getNumero().equals(numero) && bautismo.getFolio().equals(folio)) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar los datos de la lista
    public void mostrarListaBautismo() {
        for (Bautismo bautismo : listaBautismo) {
            System.out.println("Libro: " + bautismo.getLibro() + ", Número: " + bautismo.getNumero() + ", Folio: " + bautismo.getFolio());
        }
    }
}
