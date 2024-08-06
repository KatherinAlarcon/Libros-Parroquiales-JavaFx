package co.edu.uptcsoft.librosparroquialesjavafx.Modelo;

public class Defuncion extends Partida{

    private String fechaDefuncion;
    private String causaMuerte;
    private String estadoCivil;
    private String edad;
    private String conyuge;
    private String lugarMuerte;

    private Persona persona;

    public Defuncion() {
        super();
        this.persona = new Persona();
    }

    // Getters y setters para los nuevos campos

    public String getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(String fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getCausaMuerte() {
        return causaMuerte;
    }

    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public String getLugarMuerte() {
        return lugarMuerte;
    }

    public void setLugarMuerte(String lugarMuerte) {
        this.lugarMuerte = lugarMuerte;
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

    // Método para llenar los datos desde un array de String
    public void llenarDesdeArray(String[] datos) {
        if (datos.length >= 18) {
            this.setLibro(datos[0]);
            this.setFolio(datos[1]);
            this.setNumero(datos[2]);
            this.setNombres(datos[3]);
            this.setApellidos(datos[4]);
            this.setPadre(datos[5]);
            this.setFechaNacimiento(datos[6]);
            this.setLugarNacimiento(datos[7]);
            this.setGenero(datos[8]);
            this.setMadre(datos[9]);
            this.setCausaMuerte(datos[10]);
            this.setEstadoCivil(datos[11]);
            this.setEdad(datos[12]);
            this.setConyuge(datos[13]);
            this.setLugarMuerte(datos[14]);
            this.setMinistro(datos[15]);
            this.setDaFe(datos[16]);
            this.setNotaMarginal(datos[17]);
        }
    }
}
