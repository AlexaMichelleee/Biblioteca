/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Libro {
    private String titulo;
    private String isbn;
    private Date fechapubl;
    private String imagen;
    private String estado;

    public Libro() {}

    public Libro(String titulo, String isbn, Date fechapubl, String imagen, String estado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechapubl = fechapubl;
        this.imagen = imagen;
        this.estado = estado;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("El título es obligatorio.");
        this.titulo = titulo;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty())
            throw new IllegalArgumentException("El ISBN es obligatorio.");
        this.isbn = isbn;
    }

    public Date getFechapubl() { return fechapubl; }
    public void setFechapubl(Date fechapubl) { this.fechapubl = fechapubl; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Libro{titulo=" + titulo + ", isbn=" + isbn + 
               ", fechapubl=" + fechapubl + ", imagen=" + imagen + 
               ", estado=" + estado + '}';
    }
}