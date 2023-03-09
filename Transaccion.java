import java.time.LocalDate;

public class Transaccion {
    private LocalDate fecha;
    private String descripcion;
    private double ingreso;
    private double egreso;

    public Transaccion(LocalDate fecha, String descripcion, double ingreso, double egreso) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getIngreso() {
        return ingreso;
    }

    public double getEgreso() {
        return egreso;
    }


    @Override
    public String toString() {
        return fecha.toString() + "\t" + descripcion + "\t" + ingreso + "\t" + egreso;
    }
}
