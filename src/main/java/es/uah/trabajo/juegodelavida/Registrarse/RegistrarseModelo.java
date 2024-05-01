package es.uah.trabajo.juegodelavida.Registrarse;

public class RegistrarseModelo {
    private String Usuario=" ";
    private String Contraseña=" ";

    public RegistrarseModelo( String nombre, String contra) {
        this.Contraseña=contra;
        this.Usuario=nombre;
    }
    public RegistrarseModelo(){

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
