package co.edu.uptcsoft.librosparroquialesjavafx.Modelo;

public class Bautismo extends Partida{

    private String fechaBautismo;
    private String abueloPaterno;
    private String abuelaPaterna;
    private String abueloMaterno;
    private String abuelaMaterna;
    private String madrina;

    private Persona persona;

    public Bautismo() {
        super();
        this.persona = new Persona();
    }

    // Getters y setters para los nuevos campos

    public String getFechaBautismo() {
        return fechaBautismo;
    }

    public void setFechaBautismo(String fechaBautismo) {
        this.fechaBautismo = fechaBautismo;
    }

    public String getAbueloPaterno() {
        return abueloPaterno;
    }

    public void setAbueloPaterno(String abueloPaterno) {
        this.abueloPaterno = abueloPaterno;
    }

    public String getAbuelaPaterna() {
        return abuelaPaterna;
    }

    public void setAbuelaPaterna(String abuelaPaterna) {
        this.abuelaPaterna = abuelaPaterna;
    }

    public String getAbueloMaterno() {
        return abueloMaterno;
    }

    public void setAbueloMaterno(String abueloMaterno) {
        this.abueloMaterno = abueloMaterno;
    }

    public String getAbuelaMaterna() {
        return abuelaMaterna;
    }

    public void setAbuelaMaterna(String abuelaMaterna) {
        this.abuelaMaterna = abuelaMaterna;
    }

    public String getMadrina() {
        return madrina;
    }

    public void setMadrina(String madrina) {
        this.madrina = madrina;
    }

    // Getters y setters para los campos de Persona

    public String getNombres() {
        return persona.getNombres();
    }

    public void setNombres(String nombres) {
        persona.setNombres(nombres);
    }

    public String getFechaNacimiento() {
        return persona.getFechaNacimiento();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        persona.setFechaNacimiento(fechaNacimiento);
    }

    public String getApellidos() {
        return persona.getApellidos();
    }

    public void setApellidos(String apellidos) {
        persona.setApellidos(apellidos);
    }

    public String getLugarNacimiento() {
        return persona.getLugarNacimiento();
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        persona.setLugarNacimiento(lugarNacimiento);
    }

    public String getGenero() {
        return persona.getGenero();
    }

    public void setGenero(String genero) {
        persona.setGenero(genero);
    }

    public String getPadre() {
        return persona.getPadre();
    }

    public void setPadre(String padre) {
        persona.setPadre(padre);
    }

    public String getMadre() {
        return persona.getMadre();
    }

    public void setMadre(String madre) {
        persona.setMadre(madre);
    }

    public String getPadrinos() {
        return persona.getPadrinos();
    }

    public void setPadrinos(String padrinos) {
        persona.setPadrinos(padrinos);
    }
}
