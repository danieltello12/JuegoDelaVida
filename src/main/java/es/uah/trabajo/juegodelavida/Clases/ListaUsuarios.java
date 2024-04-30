package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLE;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Usuario;

public class ListaUsuarios {
   static final ListaLE<Usuario> usuarios= new ListaLE();
   public ListaUsuarios(){

   }
   public void añadirusuario(Usuario nuevo){
       usuarios.add(usuarios);
   }
   public ListaLE usuario(){
      return usuarios;
   }
   public boolean esta(String usuario, String cotraseña){
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
}
