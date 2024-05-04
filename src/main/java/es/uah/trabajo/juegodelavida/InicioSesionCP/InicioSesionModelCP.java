package es.uah.trabajo.juegodelavida.InicioSesionCP;

public class InicioSesionModelCP {
    private String Usuario="";
    private String Contraseña="";

    public InicioSesionModelCP( String nombre, String contra) {
        this.Contraseña=contra;
        this.Usuario=nombre;
    }
    public InicioSesionModelCP(){

    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
}
