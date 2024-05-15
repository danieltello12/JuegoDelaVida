package es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ElementoLEPA;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CambiarProbabilidadesControler implements Initializable {
    @FXML
    private Slider probZ;
    @FXML
    private Slider  probVA;
    @FXML
    private Slider  probC;
    @FXML
    private Slider  probVM;
    @FXML
    private Slider  probVT;
    @FXML
    private Slider  probVB;
    @FXML
    private Slider  probVP;
    Stage stage;
    Partida partida;
    String usuario;
    public void loaduserdata(Partida p, String usuario){
        this.partida=p;
        this.usuario=usuario;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    @FXML
    public void onMybotonGuardar(){
        this.partida.setPz((float) probZ.getValue());
        this.partida.setPvC((float) probC.getValue());
        this.partida.setPvA((float) probVA.getValue());
        this.partida.setPvB((float) probVB.getValue());
        this.partida.setPvM((float) probVM.getValue());
        this.partida.setPvT((float) probVT.getValue());
        this.partida.setPvP((float) probVP.getValue());
        cambiopz();
        cambiopV();
        ListaUsuarios usuarios= new ListaUsuarios();
        ListaLEPA l=usuarios.getusuario(usuario).getPartidas();
        int pos=usuarios.getusuario(usuario).getPartidas().getPosicion(new ElementoLEPA<>(partida));
        l.del(pos);
        l.add(partida);
        usuarios.getusuario(usuario).setPartidas(l);
        ListaELementos l2 = new ListaELementos();
        l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        l2=partida.getIndividuos();
        l2.guardar(l2,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

        ListaRecursos l3 = new ListaRecursos();
        l3 = l3.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
        l3=partida.getRecursos();
        l3.guardar(l3,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

        this.stage.close();

    }
    public void cambiopV(){
        for (int i=0; i<partida.getRecursos().getNumeroElementos();i++){
            String x=partida.getRecursos().getElemento(i).getDatos().getTipo();
            if(Objects.equals(x, "T")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvT());
            }
            if(Objects.equals(x, "A")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvA());
            }
            if(Objects.equals(x, "B")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvB());
            }
            if(Objects.equals(x, "P")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvP());
            }
            if(Objects.equals(x, "C")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvC());
            }
            if(Objects.equals(x, "M")){
                partida.getRecursos().getElemento(i).getDatos().setProbabilida_V(partida.getPvM());
            }
        }
    }
    public void cambiopz(){
        for(int i =0; i<partida.getRecursos().getNumeroElementos();i++){
            partida.getRecursos().getElemento(i).getDatos().setProbabilidad_Z(partida.getPz());
        }
    }
}
