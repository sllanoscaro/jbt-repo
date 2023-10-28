public class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean inicioSesion(String nombre, String contraseña) {
        if (this.nombre.equals(nombre) && this.contraseña.equals(contraseña)){
            return true;
        }
        return false;
    }

}

