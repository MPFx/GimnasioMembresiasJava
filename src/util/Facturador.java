package util;

import service.Cliente;
import model.Membresia;
import enums.EstadoPago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para generar facturas y gestionar pagos.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class Facturador {
    
    // ==================== ATRIBUTOS ESTÁTICOS ====================
    
    /** Correlativo para numerar facturas */
    private static int correlativoFactura = 1;
    
    
    // ==================== ATRIBUTOS ====================
    
    private int numeroFactura;
    private Cliente cliente;
    private double monto;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String estadoFactura;
    private String metodoPago;
    private int mesesPagados;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de la clase Facturador.
     * 
     * @param cliente        Cliente a facturar
     * @param monto          Monto de la factura
     * @param fechaEmision   Fecha de emisión
     * @param fechaVencimiento Fecha de vencimiento
     * @param metodoPago     Método de pago
     */
    public Facturador(Cliente cliente, double monto, LocalDate fechaEmision,
                      LocalDate fechaVencimiento, String metodoPago) {
        this.numeroFactura = correlativoFactura++;
        this.cliente = cliente;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.metodoPago = metodoPago;
        this.estadoFactura = "PENDIENTE";
        this.mesesPagados = 0;
    }
    
    
    // ==================== MÉTODOS ESTÁTICOS ====================
    
    /**
     * Calcula el pago mensual de una membresía.
     * 
     * @param m Membresía a calcular
     * @return Monto a pagar
     */
    public static double calcularPagoMensual(Membresia m) {
        return m.calcularCostoMensual();
    }
    
    /**
     * Genera una factura para un cliente.
     * 
     * @param c Cliente a facturar
     * @return Facturador generado
     */
    public static Facturador generarFactura(Cliente c) {
        if (c.getMembresia() != null) {
            double monto = c.getMembresia().calcularCostoMensual();
            Facturador factura = new Facturador(c, monto, LocalDate.now(),
                                                LocalDate.now().plusDays(10), "Tarjeta");
            factura.imprimir();
            return factura;
        }
        return null;
    }
    
    /**
     * Obtiene los clientes morosos (con pagos atrasados).
     * 
     * @param clientes Lista de clientes
     * @return Lista de clientes morosos
     */
    public static List<Cliente> getMorosos(List<Cliente> clientes) {
        List<Cliente> morosos = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getMembresia() != null && 
                c.getMembresia().getEstadoPago() == EstadoPago.ATRASADO) {
                morosos.add(c);
            }
        }
        return morosos;
    }
    
    /**
     * Envía un recordatorio de pago a un cliente.
     * 
     * @param c Cliente a recordar
     */
    public static void enviarRecordatorioPago(Cliente c) {
        System.out.println("\n📧 RECORDATORIO DE PAGO");
        System.out.println("Para: " + c.getEmail());
        System.out.println("Asunto: Recordatorio de pago de membresía");
        System.out.println("Estimado " + c.getNombre() + ",");
        System.out.println("Su membresía está por vencer. Realice su pago para continuar disfrutando de nuestros servicios.");
        System.out.println("Monto: $" + (c.getMembresia() != null ? c.getMembresia().calcularCostoMensual() : 0));
    }
    
    
    // ==================== MÉTODOS DE INSTANCIA ====================
    
    /**
     * Registra el pago de la factura.
     */
    public void pagar() {
        this.estadoFactura = "PAGADA";
        this.mesesPagados++;
        if (cliente.getMembresia() != null) {
            cliente.getMembresia().pagarMensualidad();
        }
        System.out.println("Factura #" + getNumeroFacturaFormateado() + " pagada");
    }
    
    /**
     * Anula la factura.
     */
    public void anularFactura() {
        this.estadoFactura = "ANULADA";
        System.out.println("Factura #" + getNumeroFacturaFormateado() + " anulada");
    }
    
    /**
     * Obtiene el número de factura formateado.
     * 
     * @return Número con 8 dígitos
     */
    public String getNumeroFacturaFormateado() {
        return String.format("%08d", numeroFactura);
    }
    
    /**
     * Imprime la factura.
     */
    public void imprimir() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            FACTURA DE MEMBRESÍA");
        System.out.println("=".repeat(50));
        System.out.println("N° Factura: " + getNumeroFacturaFormateado());
        System.out.println("Fecha emisión: " + fechaEmision);
        System.out.println("Fecha vencimiento: " + fechaVencimiento);
        System.out.println("-".repeat(50));
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("RUT: " + cliente.getRut());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("-".repeat(50));
        System.out.printf("Monto: $%,.0f\n", monto);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Estado: " + estadoFactura);
        System.out.println("=".repeat(50));
    }
    
    
    // ==================== GETTERS ====================
    
    public int getNumeroFactura() { return numeroFactura; }
    public Cliente getCliente() { return cliente; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getEstadoFactura() { return estadoFactura; }
    public void setEstadoFactura(String estadoFactura) { this.estadoFactura = estadoFactura; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}
// fin de la clase Facturador