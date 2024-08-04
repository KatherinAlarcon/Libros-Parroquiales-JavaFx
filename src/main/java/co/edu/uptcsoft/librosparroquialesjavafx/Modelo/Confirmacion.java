package co.edu.uptcsoft.librosparroquialesjavafx.Modelo;

public class Confirmacion extends Partida{
    private String fechaConfirmación;
    private String madrina;
    private String lugarBautismo;
    private String parroquiaBautismo;
    private String fechaConfirmacion;
    private Persona persona;

    public Confirmacion(){
        super();
        this.persona = new Persona();
    }

    public String getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(String fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public String getFechaConfirmación() {
        return fechaConfirmación;
    }

    public void setFechaConfirmación(String fechaConfirmación) {
        this.fechaConfirmación = fechaConfirmación;
    }

    public String getLugarBautismo() {
        return lugarBautismo;
    }

    public void setLugarBautismo(String lugarBautismo) {
        this.lugarBautismo = lugarBautismo;
    }

    public String getMadrina() {
        return madrina;
    }

    public void setMadrina(String madrina) {
        this.madrina = madrina;
    }

    public String getParroquiaBautismo() {
        return parroquiaBautismo;
    }

    public void setParroquiaBautismo(String parroquiaBautismo) {
        this.parroquiaBautismo = parroquiaBautismo;
    }

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
