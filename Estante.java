/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;

public class Estante {
    private int idestante;
    private String ubicacion;
    private int capacidad;
    private String imagen;
    private String estado;

    public Estante() {}
    public Estante(int idestante, String ubicacion, int capacidad, String imagen, String estado) {
        this.idestante = idestante; this.ubicacion = ubicacion; this.capacidad = capacidad;
        this.imagen = imagen; this.estado = estado;
    }
    public int getIdestante() { return idestante; }
    public void setIdestante(int idestante) {
        if (idestante <= 0) throw new IllegalArgumentException("Identificador de estante inválido");
        this.idestante = idestante;
    }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) {
        // CORRECCIÓN: Agregada validación para evitar capacidades negativas o cero
        if (capacidad <= 0) throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        this.capacidad = capacidad; 
    }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Estante{idestante=" + idestante + ", ubicacion=" + ubicacion + ", capacidad=" + capacidad + ", imagen=" + imagen + ", estado=" + estado + '}';
    }
}