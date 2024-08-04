package co.edu.uptcsoft.librosparroquialesjavafx.Modelo;

public abstract class Partida {
    private String libro;
    private String folio;
    private String numero;
    private String ministro;
    private String daFe;
    private String notaMarginal;

    public Partida() {
    }

    public String getDaFe() {
        return daFe;
    }

    public void setDaFe(String daFe) {
        this.daFe = daFe;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getMinistro() {
        return ministro;
    }

    public void setMinistro(String ministro) {
        this.ministro = ministro;
    }


    public String getNotaMarginal() {
        return notaMarginal;
    }

    public void setNotaMarginal(String notaMarginal) {
        this.notaMarginal = notaMarginal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
