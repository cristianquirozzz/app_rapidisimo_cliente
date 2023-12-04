package pe.usat.moviles.rapidisimoapp_cliente.model;

public class Usuario {

    private int id;
    private String usuario;
    private String contraseña;
    private String tipoUsuario;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(final String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(final String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
