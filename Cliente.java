/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Cliente extends Persona {
    private String correo;
    private String telefono;
    private String tipoCliente;

    public Cliente() {}

    public Cliente(String correo, String telefono, String tipoCliente, String curp, 
                   String nombre, String apellido, String ide, Date ingreso, 
                   String imagen, String estado) {
        super(curp, nombre, apellido, ide, ingreso, imagen, estado);
        this.correo = correo;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty())
            throw new IllegalArgumentException("El correo es obligatorio.");
        this.correo = correo;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty())
            throw new IllegalArgumentException("El teléfono es obligatorio.");
        this.telefono = telefono;
    }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente == null || tipoCliente.trim().isEmpty())
            throw new IllegalArgumentException("El tipo de cliente es obligatorio.");
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cliente{correo=" + correo + 
               ", telefono=" + telefono + ", tipoCliente=" + tipoCliente + '}';
    }
}