import java.util.ArrayList;

/**
 * Clase abstracta AquaticActivity - Representa una actividad acuática genérica
 * Define el comportamiento común y abstracto para todas las actividades del centro
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06 (Refactorizada con interfaces)
 */
public abstract class AquaticActivity {
    // Atributos protegidos (compartidos con subclases)
    protected String activityCode;
    protected String activityName;
    protected String instructorName;
    protected String schedule;
    protected int durationMinutes;
    protected double pricePerSession;
    protected int maxParticipants;
    protected int currentParticipants;
    protected boolean isActive;
    
    /**
     * Constructor de la clase abstracta
     * Inicializa los atributos comunes a todas las actividades
     */
    public AquaticActivity(String activityCode, String activityName, String instructorName,
                          String schedule, int durationMinutes, double pricePerSession,
                          int maxParticipants) {
        this.activityCode = activityCode;
        this.activityName = activityName;
        this.instructorName = instructorName;
        this.schedule = schedule;
        this.durationMinutes = durationMinutes;
        this.pricePerSession = pricePerSession;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
        this.isActive = true;
    }
    
    // =============================================
    // MÉTODOS ABSTRACTOS (deben ser implementados)
    // =============================================
    
    /**
     * Calcula el precio mensual de la actividad
     * Cada subclase implementa su propia lógica de cálculo
     * @return Precio mensual en pesos
     */
    public abstract double calculateMonthlyPrice();
    
    /**
     * Obtiene el tipo específico de actividad
     * Cada subclase define su propio tipo
     * @return Descripción del tipo de actividad
     */
    public abstract String getActivityType();
    
    /**
     * Muestra información detallada de la actividad
     * Cada subclase puede extender con información específica
     */
    public abstract void showInfo();
    
    // =============================================
    // MÉTODOS CONCRETOS (implementación común)
    // =============================================
    
    /**
     * Inscribe un participante en la actividad
     * @return true si la inscripción fue exitosa, false si no hay cupos
     */
    public boolean enrollParticipant() {
        if (currentParticipants < maxParticipants) {
            currentParticipants++;
            System.out.println("✓ Participante inscrito en " + activityCode);
            return true;
        } else {
            System.out.println("✗ Sin cupos disponibles en " + activityCode);
            return false;
        }
    }
    
    /**
     * Da de baja a un participante de la actividad
     * @return true si la baja fue exitosa, false si no hay participantes
     */
    public boolean withdrawParticipant() {
        if (currentParticipants > 0) {
            currentParticipants--;
            System.out.println("✓ Participante dado de baja de " + activityCode);
            return true;
        } else {
            System.out.println("✗ No hay participantes inscritos en " + activityCode);
            return false;
        }
    }
    
    /**
     * Obtiene el número de cupos disponibles
     * @return Cupos disponibles
     */
    public int getAvailableSpots() {
        return maxParticipants - currentParticipants;
    }
    
    /**
     * Verifica si la actividad está llena
     * @return true si no hay cupos disponibles
     */
    public boolean isFull() {
        return currentParticipants >= maxParticipants;
    }
    
    /**
     * Activa o desactiva la actividad
     * @param active Estado deseado
     */
    public void setActive(boolean active) {
        this.isActive = active;
        System.out.println(activityCode + " " + (active ? "activada" : "desactivada"));
    }
    
    // =============================================
    // GETTERS Y SETTERS
    // =============================================
    
    public String getActivityCode() {
        return activityCode;
    }
    
    public String getActivityName() {
        return activityName;
    }
    
    public String getInstructorName() {
        return instructorName;
    }
    
    public String getSchedule() {
        return schedule;
    }
    
    public int getDurationMinutes() {
        return durationMinutes;
    }
    
    public double getPricePerSession() {
        return pricePerSession;
    }
    
    public int getMaxParticipants() {
        return maxParticipants;
    }
    
    public int getCurrentParticipants() {
        return currentParticipants;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    public void setPricePerSession(double pricePerSession) {
        if (pricePerSession > 0) {
            this.pricePerSession = pricePerSession;
        }
    }
}
