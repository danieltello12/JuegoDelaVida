package es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion;

import javafx.beans.property.*;

public class ConfiguracionProperties {
    protected ConfiguracionModel original;
    private StringProperty filaIndv= new SimpleStringProperty();
    private StringProperty columnaIvd= new SimpleStringProperty();
    //private StringProperty TurnosDeVida = new SimpleStringProperty();
    private StringProperty Identificador = new SimpleStringProperty();
    private FloatProperty probabilidadclonacion = new SimpleFloatProperty();
    private FloatProperty probabilidadreproduccion= new SimpleFloatProperty();
    private StringProperty filasrec= new SimpleStringProperty();
    private StringProperty columnasrec= new SimpleStringProperty();
    private FloatProperty pvA= new  SimpleFloatProperty();
    private FloatProperty pvC= new  SimpleFloatProperty();
    private FloatProperty pvM= new  SimpleFloatProperty();
    private FloatProperty pvT= new  SimpleFloatProperty();
    private FloatProperty pvB= new  SimpleFloatProperty();
    private FloatProperty pvP= new  SimpleFloatProperty();
    private FloatProperty pz= new SimpleFloatProperty();
    public ConfiguracionProperties(ConfiguracionModel original) {
        setOriginal(original);
    }

    public void commit() {
        //original.setNumeroIndividuosAvanzados(TurnosDeVida.get());
        original.setNumeroIndividuosNormales(Identificador.get());
        original.setPclonacion(probabilidadclonacion.get());
        original.setProbabilidadreproduccion(probabilidadreproduccion.get());
        original.setFilaIndv(filaIndv.get());
        original.setColumnaIvd(columnaIvd.get());
        original.setColumnarec(columnasrec.get());
        original.setFilarec(filasrec.get());
        original.setPz(pz.get());
        original.setPvA(pvA.get());
        original.setpVC(pvC.get());
        original.setPvM(pvM.get());
        original.setPvT(pvT.get());
        original.setPvB(pvB.get());
        original.setPvP(pvP.get());

    }


    public void rollback() {
        //TurnosDeVida.set((original.getNumeroIndividuosAvanzados()));
        Identificador.set((original.getNumeroIndividuosNormales()));
        probabilidadclonacion.set((original.getPclonacion()));
        probabilidadreproduccion.set((original.getProbabilidadreproduccion()));
        filaIndv.set(original.getFilaIndv());
        columnaIvd.set(original.getColumnaIvd());
        filasrec.set(original.getFilarec());
        columnasrec.set(original.getColumnarec());
        pz.set(original.getPz());
        pvA.set(original.getPvA());
        pvC.set(original.getpVC());
        pvM.set(original.getPvM());
        pvT.set(original.getPvT());
        pvB.set(original.getPvB());
        pvP.set(original.getPvP());
    }

    public void setOriginal(ConfiguracionModel original) {
        this.original = original;
        rollback();
    }




    public Property<String> numeroIndividuosNormalesProperty() {
        return Identificador;
    }

    public Property<String> numeroIndividuosAvanzadosProperty() {
        return Identificador;
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

    public FloatProperty pzProperty(){
        return pz;
    }
    public FloatProperty PvAProperty(){
        return pvA;
    }
    public FloatProperty PvCProperty(){
        return pvC;
    }
    public FloatProperty PvMProperty(){
        return pvM;
    }
    public FloatProperty PvTProperty(){
        return pvT;
    }
    public FloatProperty PvBProperty(){
        return pvB;
    }
    public FloatProperty PvPProperty(){
        return pvP;
    }
}
