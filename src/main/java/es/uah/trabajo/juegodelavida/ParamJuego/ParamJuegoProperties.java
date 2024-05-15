package es.uah.trabajo.juegodelavida.ParamJuego;

import javafx.beans.property.*;

public class ParamJuegoProperties {
    protected ParamJuegoModel original;
    private StringProperty filaIndv= new SimpleStringProperty();
    private StringProperty columnaIvd= new SimpleStringProperty();
    private StringProperty TurnosDeVida = new SimpleStringProperty();
    private StringProperty Identificador = new SimpleStringProperty();
    private FloatProperty probabilidadclonacion = new SimpleFloatProperty();
   private FloatProperty probabilidadreproduccion= new SimpleFloatProperty();
    private StringProperty filasrec= new SimpleStringProperty();
    private StringProperty columnasrec= new SimpleStringProperty();
    public ParamJuegoProperties(ParamJuegoModel original) {
        setOriginal(original);
    }

    public void commit() {
        original.setNumeroIndividuosAvanzados(TurnosDeVida.get());
        original.setNumeroIndividuosNormales(Identificador.get());
        original.setPclonacion(probabilidadclonacion.get());
        original.setProbabilidadreproduccion(probabilidadreproduccion.get());
        original.setFilaIndv(filaIndv.get());
        original.setColumnaIvd(columnaIvd.get());
        original.setColumnarec(columnasrec.get());
        original.setFilarec(filasrec.get());

    }


    public void rollback() {
        TurnosDeVida.set((original.getNumeroIndividuosAvanzados()));
        Identificador.set((original.getNumeroIndividuosNormales()));
        probabilidadclonacion.set((original.getPclonacion()));
        probabilidadreproduccion.set((original.getProbabilidadreproduccion()));
        filaIndv.set(original.getFilaIndv());
        columnaIvd.set(original.getColumnaIvd());
        filasrec.set(original.getFilarec());
        columnasrec.set(original.getColumnarec());
    }

    public void setOriginal(ParamJuegoModel original) {
        this.original = original;
        rollback();
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

    public FloatProperty probabilidadClonacionProperty()

    {
        return probabilidadclonacion;
    }

    public StringProperty filasrecProperty(){
        return filasrec;
    }
    public StringProperty ColumnasrecProperty(){
        return columnasrec;
    }

}
