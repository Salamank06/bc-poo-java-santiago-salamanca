/**
 * Clase padre: Actividad Acuática
 * Representa cualquier actividad que se realiza en el centro de natación
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 04
 */
public class AquaticActivity {
    // Atributos protected (compartidos con subclases)
    protected String activityCode;
    protected String activityName;
    protected String instructorName;
    protected String schedule;
    protected int durationMinutes;
    protected double pricePerSession;
    protected int maxParticipants;
    protected int currentParticipants;

    // Constructor completo
    public AquaticActivity(String activityCode, String activityName, String instructorName,
                          String schedule, int durationMinutes, double pricePerSession, int maxParticipants) {
        this.activityCode = activityCode;
        this.activityName = activityName;
        this.instructorName = instructorName;
        this.schedule = schedule;
        this.durationMinutes = durationMinutes;
        this.pricePerSession = pricePerSession;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
    }

    // Métodos heredables
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        ACTIVIDAD ACUÁTICA              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Actividad: " + activityName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Precio por sesión: $" + pricePerSession);
        System.out.println("Participantes: " + currentParticipants + "/" + maxParticipants);
    }

    public double calculateMonthlyPrice() {
        final int SESSIONS_PER_WEEK = 3;
        final int WEEKS_PER_MONTH = 4;
        return pricePerSession * SESSIONS_PER_WEEK * WEEKS_PER_MONTH;
    }

    public boolean enrollParticipant() {
        if (currentParticipants < maxParticipants) {
            currentParticipants++;
            System.out.println("✓ Participante inscrito en " + activityCode);
            return true;
        }
        System.out.println("✗ Actividad llena");
        return false;
    }

    public int getAvailableSpots() {
        return maxParticipants - currentParticipants;
    }

    public String getActivityType() {
        return "Actividad Acuática Genérica";
    }

    // Getters
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
}
