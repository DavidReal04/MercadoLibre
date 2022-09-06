package Model;

import Conexion.ConexionBD;
import Entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoBD {

    ConexionBD conex = null;

    public void registrarUsuario(Usuario usuario){
        PreparedStatement stmt = null;
        try {
            conex =new ConexionBD();
            conex.getConnection().setAutoCommit(false);
            String query ="Insert into usuario VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conex.getConnection().prepareStatement(query);
            stmt.setLong(1, usuario.getCedula());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getId_nivel_sub());
            stmt.setString(5, usuario.getCorreo());
            stmt.setString(6, usuario.getContraseña());
            stmt.setString(7, usuario.getCelular());
            stmt.setString(8, usuario.getUsuario());
            stmt.setDouble(9, usuario.getCalificacion());
            stmt.setString(10, usuario.getDireccion());
            stmt.setInt(11, usuario.getMonedero());
            stmt.executeUpdate();
            conex.getConnection().commit();
            System.out.println("Ingreso Correcto");
        } catch (SQLException e) {
            try {
                conex.getConnection().rollback();
                System.out.println("Ingreso incorrecto");
            } catch (SQLException ex) {
                System.out.println("Ingreso incorrecto");
            }
        } finally {
            try {
                if(stmt!=null) stmt.close(); conex.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void eliminarUsuario(long cedula){
        PreparedStatement stmt = null;
        try {
            conex =new ConexionBD();
            conex.getConnection().setAutoCommit(false);
            String query ="delete from usuario where cedula = ?";
            stmt = conex.getConnection().prepareStatement(query);
            stmt.setLong(1, cedula);
            stmt.executeUpdate();
            conex.getConnection().commit();
            System.out.println("Borrado Correcto");
        } catch (SQLException e) {
            try {
                conex.getConnection().rollback();
                System.out.println("Borrado no completado");
            } catch (SQLException ex) {
                System.out.println("Borrado no completado");
            }
        } finally {
            try {
                if(stmt!=null) stmt.close(); conex.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void updateMonedero(long cedula, int monedero){
        PreparedStatement stmt = null;
        try {
            conex =new ConexionBD();
            conex.getConnection().setAutoCommit(false);
            String query ="update usuario set monedero = ? where cedula = ?; ";
            stmt = conex.getConnection().prepareStatement(query);
            stmt.setLong(1, monedero);
            stmt.setLong(2, cedula);
            stmt.executeUpdate();
            conex.getConnection().commit();
            System.out.println("Update Correcto");
        } catch (SQLException e) {
            try {
                conex.getConnection().rollback();
                System.out.println("Update no completado");
            } catch (SQLException ex) {
                System.out.println("Update no completado");
            }
        } finally {
            try {
                if(stmt!=null) stmt.close(); conex.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Usuario verUsuario(long cedula){
        PreparedStatement stmt = null;
        Usuario user = new Usuario();
        try {
            conex =new ConexionBD();
            String query ="SELECT * from usuario where cedula = ?; ";
            stmt = conex.getConnection().prepareStatement(query);
            stmt.setLong(1, cedula);
            stmt.execute();
            ResultSet resul = stmt.getResultSet();
            resul.next();
            user.setNombres(resul.getString("nombres"));
            user.setApellidos(resul.getString("apellidos"));
            user.setId_nivel_sub(resul.getString("id_nivel_sub"));
            user.setCorreo(resul.getString("correo"));
            user.setCelular(resul.getString("celular"));
            user.setUsuario(resul.getString("usuario"));
            user.setCalificacion(resul.getDouble("calificacion"));
            user.setDireccion(resul.getString("direccion"));
            user.setMonedero(resul.getInt("monedero"));
            System.out.println("Consulta Correcto");
        } catch (SQLException e) {
            System.out.println("Consulta no completada");
        } finally {
            try {
                if(stmt!=null) stmt.close(); conex.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }
}
