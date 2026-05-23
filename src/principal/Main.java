package principal;

import model.*;
import service.*;
import util.*;
import enums.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase principal del Gimnasio con Membresías y Rutinas.
 * Demuestra el uso de herencia y polimorfismo con dos jerarquías: Membresia y RutinaEjercicio.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0.0
 */
public class Main {
    
    /**
     * Método principal que ejecuta la demostración del sistema.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("GIMNASIO - SISTEMA DE MEMBRESÍAS Y RUTINAS");
        System.out.println("=".repeat(60));
        
        // ========== JERARQUÍA DE MEMBRESÍAS ==========
        System.out.println("\n1. DEMOSTRACIÓN DE HERENCIA - MEMBRESÍAS");
        System.out.println("-".repeat(60));

        List<Membresia> membresias = new ArrayList<>();

        // Crear membresías usando polimorfismo
        Membresia basica = new MembresiaBasica("M001", "Juan Pérez", "12.345.678-9",
            "juan@mail.com", "+56912345678", LocalDate.now(), LocalDate.now().plusMonths(1),
            35000, 30, 5, true, "06:00-22:00", 5000, 12);

        Membresia premium = new MembresiaPremium("M002", "María López", "98.765.432-1",
            "maria@mail.com", "+56987654321", LocalDate.now(), LocalDate.now().plusMonths(3),
            75000, 40, true, 10, true, "Yoga, Pilates", 15.0, true, 2, 25000, 2);

        Membresia vip = new MembresiaVIP("M003", "Carlos Ruiz", "11.111.111-1",
            "carlos@mail.com", "+56911111111", LocalDate.now(), LocalDate.now().plusMonths(6),
            120000, 50, true, 12, true, 8, "VIP-01", 20.0, true, 4, "24/7", 240000);

        Membresia estudiante = new MembresiaEstudiante("M004", "Ana González", "22.222.222-2",
            "ana@mail.com", "+56922222222", LocalDate.now(), LocalDate.now().plusMonths(2),
            35000, 30, "Universidad de Chile", "2024-001", LocalDate.now().plusMonths(12),
            "Ingeniería", 6.2, true, 15.0);

        Membresia corporativa = new MembresiaCorporativa("M005", "Pedro Soto", "33.333.333-3",
            "pedro@mail.com", "+56933333333", LocalDate.now(), LocalDate.now().plusMonths(6),
            80000, 35, "Empresa ABC", "99.999.999-9", 25, 10.0, "Pedro Soto",
            "+56212345678", "contacto@empresa.cl", "Corporativo", 2000000);

        membresias.add(basica);
        membresias.add(premium);
        membresias.add(vip);
        membresias.add(estudiante);
        membresias.add(corporativa);

        System.out.println("POLIMORFISMO - Membresías:");
        for (Membresia m : membresias) {
            // ✅ CORREGIDO: Manejo seguro de substring
            String primerBeneficio = m.obtenerBeneficios().get(0);
            String beneficioCorto = primerBeneficio.length() > 40 ? 
                                    primerBeneficio.substring(0, 40) + "..." : 
                                    primerBeneficio;

            System.out.printf("  %-12s | Costo: $%,.0f/mes | %s\n",
                m.getTipo(), m.calcularCostoMensual(), beneficioCorto);
        }
        
        // ========== JERARQUÍA DE RUTINAS ==========
        System.out.println("\n2. DEMOSTRACIÓN DE HERENCIA - RUTINAS");
        System.out.println("-".repeat(60));
        
        List<RutinaEjercicio> rutinas = new ArrayList<>();
        
        // Crear rutinas usando polimorfismo
        List<String> ejerciciosCardio = Arrays.asList("Trotar 10 min", "Bicicleta 15 min", "Cuerda 5 min");
        RutinaEjercicio cardio = new RutinaCardio("Cardio Intenso", "Rutina cardiovascular",
            NivelRutina.INTERMEDIO, 45, 450, "Alta", 7, 145, true, true,
            ejerciciosCardio, "Intervalos", 5, 30, 8.5);
        
        List<String> gruposMusculares = Arrays.asList("Pecho", "Espalda", "Piernas");
        RutinaEjercicio fuerza = new RutinaFuerza("Fuerza Total", "Rutina de fuerza completa",
            NivelRutina.AVANZADO, 60, 500, "Alta", 8, 4, 10, 25.0,
            gruposMusculares, "Barra, Mancuernas", 60, true, 2.5, 3);
        
        List<String> materiales = Arrays.asList("Cuerda", "Kettlebell", "Cajón");
        RutinaEjercicio crossfit = new RutinaCrossfit("WOD Murph", "Entrenamiento de resistencia",
            NivelRutina.AVANZADO, 50, 600, "Máxima", 9, "AMRAP", true,
            materiales, 5, 40, true, "Alto", 400, 80.0, "CrossFit");
        
        rutinas.add(cardio);
        rutinas.add(fuerza);
        rutinas.add(crossfit);
        
        System.out.println("POLIMORFISMO - Rutinas:");
        for (RutinaEjercicio r : rutinas) {
            System.out.printf("  %-15s | Nivel: %-12s | Duración: %d min | Calorías: %d\n",
                r.getNombreRutina(), r.getNivel(), r.getDuracionMinutos(), r.getCaloriasEstimadas());
        }
        
        // ========== CREAR CLIENTES Y ASIGNAR MEMBRESÍAS ==========
        System.out.println("\n3. REGISTRANDO CLIENTES Y ASIGNANDO MEMBRESÍAS...");
        
        Cliente cliente1 = new Cliente("Juan Pérez", "C001", "12.345.678-9",
            "juan@mail.com", "+56912345678", 78.5, 1.75, 30,
            "Perder peso y ganar músculo");
        cliente1.setMembresia(basica);
        
        Cliente cliente2 = new Cliente("María López", "C002", "98.765.432-1",
            "maria@mail.com", "+56987654321", 62.0, 1.65, 25,
            "Tonificar y mejorar resistencia");
        cliente2.setMembresia(premium);
        
        // ========== CREAR GIMNASIO ==========
        System.out.println("\n4. CREANDO GIMNASIO...");
        Gimnasio gimnasio = new Gimnasio("FitLife Center", "Av. Deportes 123",
                                        "+56212345678", "Lun-Dom 07:00-23:00", 200, 1500000);
        
        gimnasio.registrarCliente(cliente1);
        gimnasio.registrarCliente(cliente2);
        gimnasio.activarMembresia(basica);
        gimnasio.activarMembresia(premium);
        
        // ========== CREAR ENTRENADOR ==========
        System.out.println("\n5. CONTRATANDO ENTRENADOR...");
        Entrenador entrenador = new Entrenador("Carlos Entrenador", "E001", "Fitness General",
                                             8, "+56912345678", "carlos@gimnasio.cl", 10);
        gimnasio.contratarEntrenador(entrenador);
        entrenador.asignarCliente(cliente1);
        entrenador.asignarCliente(cliente2);
        
        // ========== ASIGNAR RUTINAS ==========
        System.out.println("\n6. ASIGNANDO RUTINAS A CLIENTES...");
        entrenador.crearRutina(cliente1, cardio);
        entrenador.crearRutina(cliente2, fuerza);
        
        // ========== DEMOSTRACIÓN DE RUTINAS ==========
        System.out.println("\n7. EJECUTANDO RUTINAS...");
        for (RutinaEjercicio r : cliente1.getRutinasAsignadas()) {
            r.ejecutar();
            System.out.println("Recomendaciones: " + r.getRecomendaciones());
        }
        
        // ========== REGISTRAR VISITAS ==========
        System.out.println("\n8. REGISTRANDO VISITAS...");
        gimnasio.registrarVisita(cliente1);
        gimnasio.registrarVisita(cliente2);
        
        // ========== FACTURACIÓN ==========
        System.out.println("\n9. GENERANDO FACTURAS...");
        Facturador.generarFactura(cliente1);
        Facturador.generarFactura(cliente2);
        
        // ========== EVALUACIÓN DE PROGRESO ==========
        System.out.println("\n10. EVALUANDO PROGRESO...");
        entrenador.evaluarProgreso(cliente1);
        
        // ========== RESUMEN DEL GIMNASIO ==========
        System.out.println("\n11. RESUMEN DEL GIMNASIO...");
        gimnasio.mostrarResumen();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("DEMOSTRACIÓN DE HERENCIA Y POLIMORFISMO COMPLETADA");
        System.out.println("=".repeat(60));
    }
}
// fin de la clase Main