package es.uah.trabajo.juegodelavida.ParamJuego;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ParamJuegoProperties {
    protected ParamJuegoModel original;
    private StringProperty dimensiones = new SimpleStringProperty();
    private StringProperty vidas = new SimpleStringProperty();
    private StringProperty numeroIBasicos = new SimpleStringProperty();
    private StringProperty numeroIAvanzados = new SimpleStringProperty();
    private StringProperty numeroIndividuosNormales = new SimpleStringProperty();
    private StringProperty probabilidadclonacion = new SimpleStringProperty();
    private StringProperty probabilidadreproduccion = new SimpleStringProperty();

    public ParamJuegoProperties(ParamJuegoModel original) {
        setOriginal(original);
    }

    public void commit() {
        original.setDimension(dimensiones.get());
        original.setVidas(vidas.get());
        original.setNumeroIndividuosAvanzados(numeroIAvanzados.get());
        original.setNumeroIndividuosNormales(numeroIndividuosNormales.get());
        original.setNumeroIndividuosBasicos(numeroIBasicos.get());
        original.setPclonacion(probabilidadclonacion.get());
        original.setProbabilidadreproduccion(probabilidadreproduccion.get());
    }


    public void rollback() {
        dimensiones.set((original.getDimension()));
        vidas.set((original.getVidas()));
        numeroIAvanzados.set((original.getNumeroIndividuosAvanzados()));
        numeroIndividuosNormales.set((original.getNumeroIndividuosNormales()));
        numeroIBasicos.set((original.getNumeroIndividuosBasicos()));
        probabilidadclonacion.set((original.getPclonacion()));
        probabilidadreproduccion.set((original.getProbabilidadreproduccion()));
    }

    public void setOriginal(ParamJuegoModel original) {
        this.original = original;
        rollback();
    }

    public Property<String> dimensionesProperty() {
        return dimensiones;
    }

    public Property<String> vidasProperty() {
        return vidas;
    }

    public Property<String> numeroIndividuosNormalesProperty() {
        return numeroIndividuosNormales;
    }

    public Property<String> numeroIndividuosAvanzadosProperty() {
        return numeroIAvanzados;
    }

    public Property<String> numeroIndividuosBasicosProperty() {
        return numeroIBasicos;
    }

    public StringProperty probabilidadReproduccionProperty() {
        return probabilidadreproduccion;
    }


    public StringProperty probabilidadClonacionProperty()

    {
        return probabilidadclonacion;
    }
}
