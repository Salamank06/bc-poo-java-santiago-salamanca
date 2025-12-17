import java.util.ArrayList;

/**
 * Clase AquaAerobics - Clase de aquaeróbicos
 * Implementa Evaluable y Cancelable
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class AquaAerobics extends AquaticActivity implements Evaluable, Cancelable {
    // Atributos específicos de aquaeróbicos
    private String intensityLevel; // Baja, Media, Alta
    private String musicGenre;
    private boolean requiresEquipment;
    private int estimatedCaloriesBurned;
    
    // Atributos para Evaluable
    private ArrayList<Integer> calificaciones;
    private ArrayList<String> comentarios;
    
    // Atributos para Cancelable
    private ArrayList<String> participantesInscritos;
    private ArrayList<String> cancelaciones;
    
    public AquaAerobics(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String intensityLevel, String musicGenre,
                       boolean requiresEquipment) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.intensityLevel = intensityLevel;
        this.musicGenre = musicGenre;
        this.requiresEquipment = requiresEquipment;
        this.estimatedCaloriesBurned = calcularCalorias();
        
        // Inicializar listas para interfaces
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.participantesInscritos = new ArrayList<>();
        this.cancelaciones = new ArrayList<>();
    }
    
    // Método auxiliar para calcular calorías según intensidad
    private int calcularCalorias() {
        switch (intensityLevel) {
            case "Baja": return 250;
            case "Media": return 400;
            case "Alta": return 550;
            default: return 300;
        }
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    // =============================================
    
    @Override
    public double calculateMonthlyPrice() {
        // Precio base: 3 sesiones/semana * 4 semanas
        double basePrice = pricePerSession * 3 * 4;
        
        // Cargo adicional si requiere equipo
        if (requiresEquipment) {
            return basePrice + 20000; // $20,000 por uso de equipo mensual
        }
        return basePrice;
    }
    
    @Override
    public String getActivityType() {
        return "Aquaeróbicos - Intensidad " + intensityLevel;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     AQUAERÓBICOS                       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Intensidad: " + intensityLevel);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Música: " + musicGenre);
        System.out.println("Requiere equipo: " + (requiresEquipment ? "Sí" : "No"));
        System.out.println("Calorías estimadas: " + estimatedCaloriesBurned + " kcal");
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Calificación: " + obtenerPromedioCalificaciones() + " ⭐ (" + 
                         obtenerNumeroEvaluaciones() + " evaluaciones)");
        System.out.println("Política de cancelación: " + obtenerPoliticaCancelacion());
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
    // IMPLEMENTACIÓN DE INTERFACE CANCELABLE
    // =============================================
    
    @Override
    public boolean cancelarInscripcion(String nombreParticipante, String motivo) {
        if (participantesInscritos.contains(nombreParticipante)) {
            participantesInscritos.remove(nombreParticipante);
            cancelaciones.add(nombreParticipante + ": " + motivo);
            withdrawParticipant();
            System.out.println("✓ Inscripción de " + nombreParticipante + " cancelada");
            return true;
        }
        System.out.println("✗ " + nombreParticipante + " no está inscrito");
        return false;
    }
    
    @Override
    public double calcularReembolso(int diasAnticipacion, double montoTotal) {
        if (diasAnticipacion >= 7) {
            return montoTotal; // Reembolso total
        } else if (diasAnticipacion >= 3) {
            return montoTotal * 0.5; // 50% de reembolso
        } else if (diasAnticipacion >= 1) {
            return montoTotal * 0.25; // 25% de reembolso
        } else {
            return 0; // Sin reembolso
        }
    }
    
    @Override
    public boolean esCancelable(int diasAnticipacion) {
        return diasAnticipacion >= 0; // Siempre se puede cancelar, pero varía el reembolso
    }
    
    @Override
    public String obtenerPoliticaCancelacion() {
        return "≥7 días: 100% | 3-6 días: 50% | 1-2 días: 25% | <1 día: 0%";
    }
    
    // =============================================
    // MÉTODOS ESPECÍFICOS
    // =============================================
    
    /**
     * Inscribe un participante con nombre
     * @param nombre Nombre del participante
     */
    public boolean inscribirParticipante(String nombre) {
        if (enrollParticipant()) {
            participantesInscritos.add(nombre);
            return true;
        }
        return false;
    }
    
    /**
     * Método específico para iniciar calentamiento
     */
    public void startWarmUp() {
        System.out.println("🎵 Iniciando calentamiento con música " + musicGenre);
        System.out.println("   Duración: 10 minutos");
        System.out.println("   Objetivo: Preparar músculos y articulaciones");
    }
    
    // =============================================
    // GETTERS ESPECÍFICOS
    // =============================================
    
    public String getIntensityLevel() {
        return intensityLevel;
    }
    
    public String getMusicGenre() {
        return musicGenre;
    }
    
    public boolean requiresEquipment() {
        return requiresEquipment;
    }
    
    public int getCaloriesBurned() {
        return estimatedCaloriesBurned;
    }
    
    public ArrayList<String> getParticipantesInscritos() {
        return new ArrayList<>(participantesInscritos);
    }
}
