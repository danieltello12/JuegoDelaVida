package es.uah.trabajo.juegodelavida.InicioSesionNP;

public class IniciosesionModelNP {
    private String Usuario="";
    private String Contraseña="";


    public IniciosesionModelNP() {

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
