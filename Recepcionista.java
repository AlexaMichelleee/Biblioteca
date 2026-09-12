/*
Gonzalez Alvarado Alexa Michelle
Leon Gamez Fernando
Camacho Guerra Jacobo
*/
package Back_end;
import java.util.Date;

public class Recepcionista extends Empleado {
    private String area;
    private String turno;

    public Recepcionista() {}

    public Recepcionista(String area, String turno, double salario, int idunico, 
                         String puesto, String curp, String nombre, String apellido, 
                         String ide, Date ingreso, String imagen, String estado) {
        super(salario, idunico, puesto, curp, nombre, apellido, ide, ingreso, imagen, estado);
        this.area = area;
        this.turno = turno;
    }

    public String getArea() { return area; }
    public void setArea(String area) {
        if (area == null || area.trim().isEmpty())
            throw new IllegalArgumentException("El área es obligatoria.");
        this.area = area;
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) {
        if (turno == null || turno.trim().isEmpty())
            throw new IllegalArgumentException("El turno es obligatorio.");
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + " | Recepcionista{area=" + area + ", turno=" + turno + '}';
    }
}