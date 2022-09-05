package Entity;

public class Usuario {

    long cedula;
    String nombres;
    String apellidos;
    String id_nivel_sub;
    String correo;
    String contraseña;
    String celular;
    String usuario;
    double calificacion;
    String direccion;
    int monedero;

    public Usuario(long cedula, String nombres, String apellidos, String id_nivel_sub, String correo, String contraseña, String celular, String usuario, double calificacion, String direccion, int monedero) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id_nivel_sub = id_nivel_sub;
        this.correo = correo;
        this.contraseña = contraseña;
        this.celular = celular;
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.direccion = direccion;
        this.monedero = monedero;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId_nivel_sub() {
        return id_nivel_sub;
    }

    public void setId_nivel_sub(String id_nivel_sub) {
        this.id_nivel_sub = id_nivel_sub;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMonedero() {
        return monedero;
    }

    public void setMonedero(int monedero) {
        this.monedero = monedero;
    }
}
