package es.uah.trabajo.juegodelavida.InicioSesionCP;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionPropertiesCP {
    protected InicioSesionModelCP original;
    private StringProperty nombre = new SimpleStringProperty();
    private StringProperty contraseña= new SimpleStringProperty();

    public InicioSesionPropertiesCP(InicioSesionModelCP original) {
        setOriginal(original);
    }
    public void commit(){
        original.setUsuario(nombre.get());
        original.setContraseña(contraseña.get());
    }


    public void rollback(){
        nombre.set((original.getUsuario()));
        contraseña.set((original.getContraseña()));
    }
    public void setOriginal(InicioSesionModelCP original){
        this.original=original;
        rollback();
    }
    public Property<String> nombreProperty() {
        return nombre;
    }
    public Property<String> contraseñaProperty(){return contraseña;}
}
