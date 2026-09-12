/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;

public class Editorial {
    private String idnombre;
    private long numerotel; // CORRECCIÓN: Cambiado de int a long para soportar teléfonos largos
    private String direccion;
    private String imagen;
    private String estado;

    public Editorial() {}
    public Editorial(String idnombre, long numerotel, String direccion, String imagen, String estado) {
        this.idnombre = idnombre; this.numerotel = numerotel; this.direccion = direccion;
        this.imagen = imagen; this.estado = estado;
    }
    public String getIdnombre() { return idnombre; }
    public void setIdnombre(String idnombre) {
        if (idnombre == null || idnombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre es obligatorio.");
        this.idnombre = idnombre;
    }
    public long getNumerotel() { return numerotel; }
    public void setNumerotel(long numerotel) {
        if (numerotel <= 0) throw new IllegalArgumentException("Número de teléfono inválido");
        this.numerotel = numerotel;
    }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) throw new IllegalArgumentException("La dirección es obligatoria.");
        this.direccion = direccion;
    }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Editorial{idnombre=" + idnombre + ", numerotel=" + numerotel + ", direccion=" + direccion + ", imagen=" + imagen + ", estado=" + estado + '}';
    }
}