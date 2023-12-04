package pe.usat.moviles.rapidisimoapp_cliente.model;

public class Solicitud {

    private int id;
    private String descripcionCarga;
    private String claseCarga;
    private String tipoCarga;
    private String categoriaCarga;
    private double pesoKg;
    private String fechaHoraPartida;
    private String fechaHoraLlegada;
    private String direccionOrigen;
    private String direccionDestino;
    private double montoPagar;
    private double distanciaKm;
    private int TARIFAid;
    private int CLIENTEid;
    private int PAGO_SOLICITUDid;
    private int ESTADO_SOLICITUDid;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDescripcionCarga() {
        return descripcionCarga;
    }

    public void setDescripcionCarga(final String descripcionCarga) {
        this.descripcionCarga = descripcionCarga;
    }

    public String getClaseCarga() {
        return claseCarga;
    }

    public void setClaseCarga(final String claseCarga) {
        this.claseCarga = claseCarga;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(final String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getCategoriaCarga() {
        return categoriaCarga;
    }

    public void setCategoriaCarga(final String categoriaCarga) {
        this.categoriaCarga = categoriaCarga;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(final double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getFechaHoraPartida() {
        return fechaHoraPartida;
    }

    public void setFechaHoraPartida(final String fechaHoraPartida) {
        this.fechaHoraPartida = fechaHoraPartida;
    }

    public String getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(final String fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(final String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(final String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(final double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(final double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public int getTARIFAid() {
        return TARIFAid;
    }

    public void setTARIFAid(final int TARIFAid) {
        this.TARIFAid = TARIFAid;
    }

    public int getCLIENTEid() {
        return CLIENTEid;
    }

    public void setCLIENTEid(final int CLIENTEid) {
        this.CLIENTEid = CLIENTEid;
    }

    public int getPAGO_SOLICITUDid() {
        return PAGO_SOLICITUDid;
    }

    public void setPAGO_SOLICITUDid(final int PAGO_SOLICITUDid) {
        this.PAGO_SOLICITUDid = PAGO_SOLICITUDid;
    }

    public int getESTADO_SOLICITUDid() {
        return ESTADO_SOLICITUDid;
    }

    public void setESTADO_SOLICITUDid(int ESTADO_SOLICITUDid) {
        this.ESTADO_SOLICITUDid = ESTADO_SOLICITUDid;
    }
}
