package es.uah.trabajo.juegodelavida.Clases;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLEUs;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

import java.util.Objects;

public class ListaUsuarios extends gson {
   public ListaUsuarios() {

   }

   public void añadirusuario(Usuario nuevo) {
      ListaLE<Usuario> l = new ListaLE();
      l=l.cargar();
      l.add(nuevo);
      guardar(l);
   }
   public void eliminar(String usuario){
      ListaLE<Usuario> l = new ListaLE();
      l=l.cargar();
      ElementoLEUs e= new ElementoLEUs(new Usuario(usuario,""));
      int pos=l.getPosicion(e);
      l.del(pos);
      guardar(l);
   }

   public int esta(String usuario, String cotraseña) {
      ListaLE<Usuario> usuarios = new ListaLE<Usuario>();
      usuarios = usuarios.cargar();
      int encontrado = 0;
      ElementoLEUs<Usuario> el = usuarios.getPrimero();
      while (el != null && encontrado == 0) {
         if (Objects.equals((el.getDatos()).nombre, (usuario))) {
            encontrado += 1;
         }
         if (Objects.equals(el.getDatos().contraseña,  cotraseña)) {
            encontrado += 1;

         } else {
            el = ((ElementoLEUs<Usuario>) el).getSiguiente();
         }

      }
      return encontrado;
   }
   public boolean yacreado(String usuario) {
      ListaLE<Usuario> usuarios = new ListaLE<Usuario>();
      usuarios = usuarios.cargar();
      boolean encontrado = false;
      ElementoLEUs<Usuario> el = usuarios.getPrimero();
      while (el != null && encontrado == false) {
         if (Objects.equals((el.getDatos()).nombre, (usuario))) {
            encontrado = true;
         }
         else {
            el = ((ElementoLEUs<Usuario>) el).getSiguiente();
         }
      }
      return encontrado;
   }
   public Usuario getusuario(String nombre){
      ListaLE<Usuario> usuarios = new ListaLE<Usuario>();
      usuarios = usuarios.cargar();
      boolean encontrado = false;
      ElementoLEUs<Usuario> el = usuarios.getPrimero();
      while (el != null && encontrado == false) {
         if (Objects.equals((el.getDatos()).nombre,nombre)) {
            encontrado = true;
         }
         else {
            el = ((ElementoLEUs<Usuario>) el).getSiguiente();
         }
      }
      return el.getDatos();
   }

   public void guardar(ListaLE lista) {
      String rutaArchivo = "Json/usuarios.json";
      //hola
      guardarObjetoEnArchivo(rutaArchivo, lista);
   }
}

