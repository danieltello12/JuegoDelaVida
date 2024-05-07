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

    private StringProperty numeroRecursosAgua=new SimpleStringProperty();
    private StringProperty numeroRecursosMontana=new SimpleStringProperty();
    private StringProperty numeroRecursosComida=new SimpleStringProperty();
    private StringProperty numeroRecursosTesoro=new SimpleStringProperty();
    private StringProperty numeroRecursosBiblioteca=new SimpleStringProperty();
    private StringProperty numeroRecursosPozo=new SimpleStringProperty();

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
        original.setNumeroRecursosAgua(numeroRecursosAgua.get());
        original.setNumeroRecursosTesoro(numeroRecursosTesoro.get());
        original.setNumeroRecursosComida(numeroRecursosComida.get());
        original.setNumeroRecursosBiblioteca(numeroRecursosBiblioteca.get());
        original.setNumeroRecursosPozo(numeroRecursosPozo.get());
        original.setNumeroRecursosMontana(numeroRecursosMontana.get());

    }


    public void rollback() {
        dimensiones.set((original.getDimension()));
        vidas.set((original.getVidas()));
        numeroIAvanzados.set((original.getNumeroIndividuosAvanzados()));
        numeroIndividuosNormales.set((original.getNumeroIndividuosNormales()));
        numeroIBasicos.set((original.getNumeroIndividuosBasicos()));
        probabilidadclonacion.set((original.getPclonacion()));
        probabilidadreproduccion.set((original.getProbabilidadreproduccion()));
        numeroRecursosBiblioteca.set((original.getNumeroRecursosBiblioteca()));
        numeroRecursosAgua.set((original.getNumeroRecursosAgua()));
        numeroRecursosComida.set((original.getNumeroRecursosComida()));
        numeroRecursosPozo.set((original.getNumeroRecursosPozo()));
        numeroRecursosTesoro.set((original.getNumeroRecursosTesoro()));
        numeroRecursosMontana.set((original.getNumeroRecursosMontana()));
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
    public Property<String> numeroRecursosAguaProperty() {
        return numeroRecursosAgua;
    }
    public Property<String> numeroRecursosPozoProperty() {
        return numeroRecursosPozo;
    }
    public Property<String> numeroRecursosMontanaProperty() {
        return numeroRecursosMontana;
    }
    public Property<String> numeroRecursosTesoroProperty() {
        return numeroRecursosTesoro;
    }
    public Property<String> numeroRecursosComidaProperty() {
        return numeroRecursosComida;
    }
    public Property<String> numeroRecursosBibliotecaProperty() {
        return numeroRecursosBiblioteca;
    }
}
