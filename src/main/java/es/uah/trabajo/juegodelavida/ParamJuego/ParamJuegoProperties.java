package es.uah.trabajo.juegodelavida.ParamJuego;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ParamJuegoProperties {
    protected ParamJuegoModel original;
    private StringProperty dimensiones = new SimpleStringProperty();
    private StringProperty vidas = new SimpleStringProperty();

    public ParamJuegoProperties(ParamJuegoModel original) {
        setOriginal(original);
    }
    public void commit(){
        original.setDimension(dimensiones.get());
        original.setVidas(vidas.get());
    }


    public void rollback(){
        dimensiones.set((original.getDimension()));
        vidas.set((original.getVidas()));
    }
    public void setOriginal(ParamJuegoModel original){
        this.original=original;
        rollback();
    }
    public Property<String> dimensionesProperty() {
        return dimensiones;
    }
    public Property<String> vidasProperty(){return vidas;}
}
