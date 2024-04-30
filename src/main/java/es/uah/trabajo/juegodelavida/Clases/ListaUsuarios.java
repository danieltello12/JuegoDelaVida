package es.uah.trabajo.juegodelavida.Clases;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLE;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class ListaUsuarios extends gson{
public ListaUsuarios(){

}
   public void añadirusuario(Usuario nuevo){
      ListaLE l= cargar();
       l.add(nuevo);
       guardar(l);
   }
   public boolean esta(String usuario, String cotraseña){
      ListaLE usuarios= cargar();
      boolean encontrado= false;
      Usuario u= new Usuario(usuario,cotraseña);
      ElementoLE<Usuario> el2= new ElementoLE(u);
      ElementoLE<Usuario> el =usuarios.getPrimero();
      while (el != null && encontrado == false) {
         if (el.getDatos().nombre == el2.getDatos().nombre&& el.getDatos().contraseña==el2.getDatos().contraseña) {
            encontrado=false;
         } else {
            el = ((ElementoLE<Usuario>) el).getSiguiente();
         }

      }
      return encontrado;
   }
   public void guardar(ListaLE lista) {
      String rutaArchivo = "usuarios.json";
      //hola
      guardarObjetoEnArchivo(rutaArchivo, lista);
   }
   public ListaLE cargar(){
      ListaLE cargado= cargarObjetoDesdeArchivo("usuarios.json", ListaLE.class);
      return cargado;

   }
}
