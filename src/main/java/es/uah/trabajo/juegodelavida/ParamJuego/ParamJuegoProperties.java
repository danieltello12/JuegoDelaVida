package es.uah.trabajo.juegodelavida.ParamJuego;

import javafx.beans.property.*;

public class ParamJuegoProperties {
    protected ParamJuegoModel original;
    private StringProperty filaIndv= new SimpleStringProperty();
    private StringProperty columnaIvd= new SimpleStringProperty();
    private StringProperty nombre= new SimpleStringProperty();
    private StringProperty columnas = new SimpleStringProperty();
    private StringProperty filas= new SimpleStringProperty();
    private StringProperty TurnosDeVida = new SimpleStringProperty();
    private StringProperty Identificador = new SimpleStringProperty();
    private FloatProperty probabilidadclonacion = new SimpleFloatProperty();
   private FloatProperty probabilidadreproduccion= new SimpleFloatProperty();
    private StringProperty filasrec= new SimpleStringProperty();
    private StringProperty columnasrec= new SimpleStringProperty();
    private FloatProperty pv= new  SimpleFloatProperty();
    private FloatProperty pz= new SimpleFloatProperty();
    public ParamJuegoProperties(ParamJuegoModel original) {
        setOriginal(original);
    }

    public void commit() {
        original.setDimension(columnas.get());
        original.setNumeroIndividuosAvanzados(TurnosDeVida.get());
        original.setNumeroIndividuosNormales(Identificador.get());
        original.setPclonacion(probabilidadclonacion.get());
        original.setProbabilidadreproduccion(probabilidadreproduccion.get());
        original.setFilas(filas.get());
        original.setNombre(nombre.get());
        original.setFilaIndv(filaIndv.get());
        original.setColumnaIvd(columnaIvd.get());
        original.setColumnarec(columnasrec.get());
        original.setFilarec(filasrec.get());
        original.setPz(pz.get());
        original.setPv(pv.get());

    }


    public void rollback() {
        columnas.set((original.getDimension()));
        TurnosDeVida.set((original.getNumeroIndividuosAvanzados()));
        Identificador.set((original.getNumeroIndividuosNormales()));
        probabilidadclonacion.set((original.getPclonacion()));
        probabilidadreproduccion.set((original.getProbabilidadreproduccion()));
        filas.set(original.getFilas());
        nombre.set(original.getNombre());
        filaIndv.set(original.getFilaIndv());
        columnaIvd.set(original.getColumnaIvd());
        filasrec.set(original.getFilarec());
        columnasrec.set(original.getColumnarec());
        pv.set(original.getPv());
        pz.set(original.getPz());
    }

    public void setOriginal(ParamJuegoModel original) {
        this.original = original;
        rollback();
    }

    public Property<String> dimensionesProperty() {
        return columnas;
    }



    public Property<String> numeroIndividuosNormalesProperty() {
        return Identificador;
    }

    public Property<String> numeroIndividuosAvanzadosProperty() {
        return TurnosDeVida;
    }

    public StringProperty filaIndvproperty(){
        return filaIndv;
    }
    public FloatProperty probabilidadReproduccionProperty() {
        return probabilidadreproduccion;
    }
public StringProperty getColumnaIvdproperty(){
        return columnaIvd;
}
public StringProperty  filasProperty(){
        return filas;
}
    public FloatProperty probabilidadClonacionProperty()

    {
        return probabilidadclonacion;
    }
    public StringProperty nombre(){
        return nombre;
    }
    public StringProperty filasrecProperty(){
        return filasrec;
    }
    public StringProperty ColumnasrecProperty(){
        return columnasrec;
    }
    public FloatProperty pvProperty(){
        return pv;
    }
    public FloatProperty pzProperty(){
        return pz;
    }
}
