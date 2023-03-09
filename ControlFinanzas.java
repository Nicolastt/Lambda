import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControlFinanzas {
    private final List<Transaccion> transacciones;

    public ControlFinanzas() {
            transacciones = new ArrayList<>();
            LocalDate fecha1 = LocalDate.parse("2023-03-05");
            transacciones.add(new Transaccion(fecha1, "Compra de chicles", 0, 6));
            LocalDate fecha2 = LocalDate.parse("2023-03-20");
            transacciones.add(new Transaccion(fecha2, "Compra de útiles", 0, 10));
            LocalDate fecha3 = LocalDate.parse("2023-03-10");
            transacciones.add(new Transaccion(fecha3, "Venta de gorras", 12, 0));
            LocalDate fecha4 = LocalDate.parse("2023-03-30");
            transacciones.add(new Transaccion(fecha4, "Venta de marcadores", 39, 0));

    }

    public void agregarTransaccion(LocalDate fecha, String descripcion, double ingreso, double egreso)
            throws FechaInvalidaException, ValorNegativoException {
        if (fecha.getDayOfMonth() > 31) {
            throw new FechaInvalidaException("El mes " + fecha.getMonthValue() + " no tiene " + fecha.getDayOfMonth() + " días.");
        }
        if (ingreso < 0 || egreso < 0) {
            throw new ValorNegativoException("El ingreso o egreso no puede ser negativo.");
        }
        transacciones.add(new Transaccion(fecha, descripcion, ingreso, egreso));
    }

    public void mostrarReporte() {
        System.out.println("Reporte de ingresos y egresos:");
        System.out.println("Fecha       Descripción         Ingreso    Egreso");
        System.out.println("-------------------------------------------------");
        // -- Ordenar Fechas --

        // FORMA 1
        transacciones.sort(Comparator.comparing(Transaccion::getFecha));

        //FORMA 2
        //transacciones.sort(new Comparator<Transaccion>() {
        //    @Override
        //    public int compare(Transaccion t1, Transaccion t2) {
        //        return t1.getFecha().compareTo(t2.getFecha());
        //    }
        //});

        // FORMA 3
        //transacciones.sort(new ComparatorFecha());

        double totalIngresos = 0;
        double totalEgresos = 0;
        for (Transaccion t : transacciones) {
            System.out.printf("%s  %-18s  $%8.2f  $%8.2f%n", t.getFecha(), t.getDescripcion(), t.getIngreso(), t.getEgreso());
            totalIngresos += t.getIngreso();
            totalEgresos += t.getEgreso();
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Total ingresos: $%8.2f%n", totalIngresos);
        System.out.printf("Total egresos:  $%8.2f%n", totalEgresos);
        System.out.printf("Ganancia:       $%8.2f%n", totalIngresos - totalEgresos);
    }
}
