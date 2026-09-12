/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Administrador extends Empleado {
    private int nivelAcceso;
    private String permisos;

    public Administrador() {}

    public Administrador(int nivelAcceso, String permisos, double salario, int idunico, 
                         String puesto, String curp, String nombre, String apellido, 
                         String ide, Date ingreso, String imagen, String estado) {
        super(salario, idunico, puesto, curp, nombre, apellido, ide, ingreso, imagen, estado);
        this.nivelAcceso = nivelAcceso;
        this.permisos = permisos;
    }

    public int getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(int nivelAcceso) {
        if (nivelAcceso < 1)
            throw new IllegalArgumentException("El nivel de acceso debe ser mayor a 0.");
        this.nivelAcceso = nivelAcceso;
    }

    public String getPermisos() { return permisos; }
    public void setPermisos(String permisos) { this.permisos = permisos; }

    @Override
    public String toString() {
        return super.toString() + " | Administrador{nivelAcceso=" + nivelAcceso + 
               ", permisos=" + permisos + '}';
    }
}