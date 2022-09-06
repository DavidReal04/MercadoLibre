package Controller;

import Entity.Usuario;
import Model.ManejoBD;

import javax.swing.*;
import java.awt.*;

public class Controller {

    ManejoBD manejo;

    public Controller(){
        manejo = new ManejoBD();
        menu();
    }

    public void menu (){
        String menu = "Management MercadoLibre\n" +
                "1. Crear usuario\n" +
                "2. Borrar Usuario\n" +
                "3. Actualizar monedero de usuario\n" +
                "4. Ver Info Usuario\n" +
                "5. Aumentar en 100 el monedero de un usuario\n" +
                "6. Salir";
        try {
            long cedula;
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            switch (seleccion){
                case 1:
                    Usuario user = registrarUsuario();
                    if(user!=null)
                        manejo.registrarUsuario(user);
                    break;
                case 2:
                    cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cédula del usuario a borrar"));
                    manejo.eliminarUsuario(cedula);
                    break;
                case 3:
                    cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cédula del usuario"));
                    int monedero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo valor del monedero"));
                    manejo.updateMonedero(cedula, monedero);
                    break;
                case 4:
                    cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cédula del usuario"));
                    Usuario usuario = manejo.verUsuario(cedula);
                    String datos = "";
                    datos += usuario.getNombres();
                    datos += " || " + usuario.getApellidos();
                    datos += " || " + usuario.getId_nivel_sub();
                    datos += " || " + usuario.getCorreo();
                    datos += " || " + usuario.getCelular();
                    datos += " || " + usuario.getUsuario();
                    datos += " || " + usuario.getCalificacion();
                    datos += " || " + usuario.getDireccion();
                    datos += " || " + usuario.getMonedero();
                    JOptionPane.showMessageDialog(null, datos);
                    break;
                case 5:
                    cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cédula del usuario"));
                    manejo.cambiarPuntos(cedula);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta Luego");
                    break;
                default:
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese correctamente el dato");
            menu();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una opción correcta");
            menu();
        }

    }

    public Usuario registrarUsuario(){
        try {
            long cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese Cédula"));
            String nombres = JOptionPane.showInputDialog("Ingrese Nombres");
            String apellidos = JOptionPane.showInputDialog("Ingrese Apellidos");
            String id_nivel_sub = "1";
            String correo = JOptionPane.showInputDialog("Ingrese Correo");
            String contraseña = JOptionPane.showInputDialog("Ingrese Contraseña");
            String celular = JOptionPane.showInputDialog("Ingrese Celular");
            String usuario = JOptionPane.showInputDialog("Ingrese Nombre de Usuario");
            double calificacion = 0;
            String direccion = JOptionPane.showInputDialog("Ingrese Dirección");
            int monedero = 0;
            return new Usuario(cedula, nombres, apellidos, id_nivel_sub, correo, contraseña, celular, usuario, calificacion, direccion, monedero);
        } catch (Exception e) {
            return null;
        }
    }
}
