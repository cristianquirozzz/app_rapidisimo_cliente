package pe.usat.moviles.rapidisimoapp_cliente.model;

public class Cliente {

    private int id;
    private String tipoDoc;
    private String numeroDoc;
    private String nombres;
    private String razonSocial;
    private double direccion;
    private String email;
    private String telefono;
    private String estado;
    private int USUARIOid;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(final String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(final String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public double getDireccion() {
        return direccion;
    }

    public void setDireccion(final double direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public int getUSUARIOid() {
        return USUARIOid;
    }

    public void setUSUARIOid(final int USUARIOid) {
        this.USUARIOid = USUARIOid;
    }
}
