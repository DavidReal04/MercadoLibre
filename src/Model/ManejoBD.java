package Model;

import Conexion.ConexionBD;
import Entity.Usuario;

import java.sql.PreparedStatement;
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
        } catch (SQLException e) {
            try {
                conex.getConnection().rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                e.printStackTrace();
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
        } catch (SQLException e) {
            try {
                conex.getConnection().rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            try {
                if(stmt!=null) stmt.close(); conex.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
