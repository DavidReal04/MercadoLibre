package Controller;

import Entity.Usuario;
import Model.ManejoBD;

public class Controller {

    ManejoBD manejo;

    public Controller(){
        manejo = new ManejoBD();
        Usuario user = new Usuario(1193374637,"David", "Real", "1", "real@gmail.com","12345","3057116461", "Dreal", 9.5, "calle c", 0);
        manejo.registrarUsuario(user);
        manejo.eliminarUsuario(user.getCedula());
        manejo.registrarUsuario(user);
    }

}
