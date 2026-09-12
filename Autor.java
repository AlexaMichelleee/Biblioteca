/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Autor {
    private String idAutor;
    private String nombre;
    private String nacionalidad;
    private Date fechaNac;
    private String imagen;
    private String estado;

    public Autor() {}

    public Autor(String idAutor, String nombre, String nacionalidad, Date fechaNac, 
                 String imagen, String estado) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.estado = estado;
    }

    public String getIdAutor() { return idAutor; }
    public void setIdAutor(String idAutor) {
        if (idAutor == null || idAutor.trim().isEmpty())
            throw new IllegalArgumentException("El identificador del autor es obligatorio.");
        this.idAutor = idAutor;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public Date getFechaNac() { return fechaNac; }
    public void setFechaNac(Date fechaNac) { this.fechaNac = fechaNac; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Autor{idAutor=" + idAutor + ", nombre=" + nombre + 
               ", nacionalidad=" + nacionalidad + ", fechaNac=" + fechaNac + 
               ", imagen=" + imagen + ", estado=" + estado + '}';
    }
}