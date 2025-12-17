import java.util.ArrayList;

/**
 * Clase SwimmingLesson - Lección de natación
 * Implementa Reservable y Evaluable
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class SwimmingLesson extends AquaticActivity implements Reservable, Evaluable {
    // Atributos específicos de lección de natación
    private String level; // Bebés, Niños, Adultos, Avanzado
    private String techniquesFocus; // Técnicas específicas a enseñar
    private boolean includesCertification;
    
    // Atributos para Reservable
    private ArrayList<String> reservas;
    private int contadorReservas;
    
    // Atributos para Evaluable
    private ArrayList<Integer> calificaciones;
    private ArrayList<String> comentarios;
    
    public SwimmingLesson(String activityCode, String activityName, String instructorName,
                         String schedule, int durationMinutes, double pricePerSession,
                         int maxParticipants, String level, String techniquesFocus,
                         boolean includesCertification) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.level = level;
        this.techniquesFocus = techniquesFocus;
        this.includesCertification = includesCertification;
        
        // Inicializar listas para interfaces
        this.reservas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.contadorReservas = 1000;
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    // =============================================
    
    @Override
    public double calculateMonthlyPrice() {
        // Precio base: 3 sesiones/semana * 4 semanas
        double basePrice = pricePerSession * 3 * 4;
        
        // Ajustar según nivel
        if (level.equals("Bebés")) {
            return basePrice * 1.2; // 20% más por cuidado especial
        } else if (level.equals("Adultos")) {
            return basePrice * 0.9; // 10% descuento
        }
        return basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Clase de Natación - " + level;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     CLASE DE NATACIÓN                  ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Nivel: " + level);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Técnicas: " + techniquesFocus);
        System.out.println("Certificación: " + (includesCertification ? "Sí" : "No"));
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Reservas activas: " + obtenerNumeroReservas());
        System.out.println("Calificación: " + obtenerPromedioCalificaciones() + " ⭐ (" + 
                         obtenerNumeroEvaluaciones() + " evaluaciones)");
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE INTERFACE RESERVABLE
    // =============================================
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        int cuposDisponibles = getAvailableSpots();
        System.out.println("→ Verificando disponibilidad para " + fecha + ": " + 
                         cuposDisponibles + " cupos");
        return cuposDisponibles > 0;
    }
    
    @Override
    public String realizarReserva(String nombreCliente, String fecha, int numeroCupos) {
        if (numeroCupos <= 0 || numeroCupos > getAvailableSpots()) {
            System.out.println("✗ No se puede reservar " + numeroCupos + " cupo(s)");
            return null;
        }
        
        String codigoReserva = activityCode + "-R" + (contadorReservas++);
        String reserva = codigoReserva + "|" + nombreCliente + "|" + fecha + "|" + numeroCupos;
        reservas.add(reserva);
        
        // Reducir cupos disponibles
        for (int i = 0; i < numeroCupos; i++) {
            enrollParticipant();
        }
        
        System.out.println("✓ Reserva exitosa: " + codigoReserva + " para " + nombreCliente);
        return codigoReserva;
    }
    
    @Override
    public boolean cancelarReserva(String codigoReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).startsWith(codigoReserva)) {
                String reserva = reservas.remove(i);
                String[] partes = reserva.split("\\|");
                int cupos = Integer.parseInt(partes[3]);
                
                // Liberar cupos
                for (int j = 0; j < cupos; j++) {
                    withdrawParticipant();
                }
                
                System.out.println("✓ Reserva " + codigoReserva + " cancelada");
                return true;
            }
        }
        System.out.println("✗ Reserva " + codigoReserva + " no encontrada");
        return false;
    }
    
    @Override
    public int obtenerNumeroReservas() {
        return reservas.size();
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE INTERFACE EVALUABLE
    // =============================================
    
    @Override
    public void agregarCalificacion(int estrellas, String comentario, String nombreParticipante) {
        if (estrellas < 1 || estrellas > 5) {
            System.out.println("✗ Calificación inválida. Debe ser entre 1 y 5 estrellas");
            return;
        }
        
        calificaciones.add(estrellas);
        comentarios.add(nombreParticipante + ": " + comentario);
        System.out.println("✓ Calificación agregada: " + estrellas + " ⭐ por " + nombreParticipante);
    }
    
    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        
        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.size();
    }
    
    @Override
    public int obtenerNumeroEvaluaciones() {
        return calificaciones.size();
    }
    
    @Override
    public boolean tieneCalificacionAlta() {
        return obtenerPromedioCalificaciones() >= 4.0;
    }
    
    // =============================================
    // GETTERS ESPECÍFICOS
    // =============================================
    
    public String getLevel() {
        return level;
    }
    
    public String getTechniquesFocus() {
        return techniquesFocus;
    }
    
    public boolean includesCertification() {
        return includesCertification;
    }
    
    public ArrayList<String> getComentarios() {
        return new ArrayList<>(comentarios);
    }
}
