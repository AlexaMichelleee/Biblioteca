/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;
import java.util.Objects;

public abstract class Persona {
    private String curp;
    private String nombre;
    private String apellido;
    private String ide;
    private Date ingreso;
    private String imagen;
    private String estado;

    public Persona() {}

    public Persona(String curp, String nombre, String apellido, String ide, 
                   Date ingreso, String imagen, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ide = ide;
        this.ingreso = ingreso;
        this.imagen = imagen;
        this.estado = estado;
    }

    public String getCurp() { return curp; }
    public void setCurp(String curp) {
        if (curp == null || curp.trim().isEmpty())
            throw new IllegalArgumentException("El curp es obligatorio.");
        this.curp = curp;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio.");
        this.nombre = nombre;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty())
            throw new IllegalArgumentException("El apellido es obligatorio.");
        this.apellido = apellido;
    }

    public String getIde() { return ide; }
    public void setIde(String ide) {
        if (ide == null || ide.trim().isEmpty())
            throw new IllegalArgumentException("La identificación es obligatoria.");
        this.ide = ide;
    }

    public Date getIngreso() { return ingreso; }
    public void setIngreso(Date ingreso) { this.ingreso = ingreso; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Persona{curp=" + curp + ", nombre=" + nombre + ", apellido=" + apellido +
               ", ide=" + ide + ", ingreso=" + ingreso + ", imagen=" + imagen + 
               ", estado=" + estado + '}';
    }
}