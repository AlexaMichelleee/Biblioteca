/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Prestamo {
    private int idprestamo;
    private Date fechapres;
    private Date fechadevo;
    private String tipopres;
    private String imagen;
    private String estado;

    public Prestamo() {}

    public Prestamo(int idprestamo, Date fechapres, Date fechadevo, 
                    String tipopres, String imagen, String estado) {
        this.idprestamo = idprestamo;
        this.fechapres = fechapres;
        this.fechadevo = fechadevo;
        this.tipopres = tipopres;
        this.imagen = imagen;
        this.estado = estado;
    }

    public int getIdprestamo() { return idprestamo; }
    public void setIdprestamo(int idprestamo) {
        if (idprestamo <= 0)
            throw new IllegalArgumentException("Identificador de préstamo inválido");
        this.idprestamo = idprestamo;
    }

    public Date getFechapres() { return fechapres; }
    public void setFechapres(Date fechapres) { this.fechapres = fechapres; }

    public Date getFechadevo() { return fechadevo; }
    public void setFechadevo(Date fechadevo) { this.fechadevo = fechadevo; }

    public String getTipopres() { return tipopres; }
    public void setTipopres(String tipopres) { this.tipopres = tipopres; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Préstamo{id=" + idprestamo + ", fechaPrestamo=" + fechapres + 
               ", fechaDevolucion=" + fechadevo + ", tipo=" + tipopres + 
               ", imagen=" + imagen + ", estado=" + estado + '}';
    }
}