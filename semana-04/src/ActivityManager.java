/**
 * Clase auxiliar para gestionar actividades
 * Demuestra el uso de arrays polimórficos
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 04
 */
public class ActivityManager {
    private String centerName;
    private AquaticActivity[] activities; // Array polimórfico
    private int activityCount;

    public ActivityManager(String centerName, int maxActivities) {
        this.centerName = centerName;
        this.activities = new AquaticActivity[maxActivities];
        this.activityCount = 0;
    }

    public void addActivity(AquaticActivity activity) {
        if (activityCount < activities.length) {
            activities[activityCount] = activity;
            activityCount++;
            System.out.println("✓ Actividad agregada: " + activity.getActivityCode());
        } else {
            System.out.println("✗ No hay espacio para más actividades");
        }
    }

    public void showAllActivities() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║         ACTIVIDADES DE " + centerName.toUpperCase() + "         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        for (int i = 0; i < activityCount; i++) {
            System.out.println("──────────────────────────────────────────────────────────");
            activities[i].showInfo(); // Polimorfismo: llama al método de la subclase
            System.out.println("Tipo: " + activities[i].getActivityType());
            System.out.println("Precio mensual: $" + activities[i].calculateMonthlyPrice());
            System.out.println();
        }
    }

    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ESTADÍSTICAS DEL CENTRO                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        int swimmingCount = 0;
        int aerobicsCount = 0;
        int therapyCount = 0;
        double totalRevenue = 0;
        int totalParticipants = 0;

        for (int i = 0; i < activityCount; i++) {
            AquaticActivity activity = activities[i];
            
            // Identificar tipo de actividad
            if (activity instanceof SwimmingLesson) {
                swimmingCount++;
            } else if (activity instanceof AquaAerobics) {
                aerobicsCount++;
            } else if (activity instanceof HydroTherapy) {
                therapyCount++;
            }

            totalRevenue += activity.calculateMonthlyPrice() * activity.getCurrentParticipants();
            totalParticipants += activity.getCurrentParticipants();
        }

        System.out.println("Total actividades: " + activityCount);
        System.out.println("  - Clases de natación: " + swimmingCount);
        System.out.println("  - Aquaeróbicos: " + aerobicsCount);
        System.out.println("  - Hidroterapia: " + therapyCount);
        System.out.println("Participantes totales: " + totalParticipants);
        System.out.println("Ingresos mensuales estimados: $" + totalRevenue);
    }

    public AquaticActivity findActivityByCode(String code) {
        for (int i = 0; i < activityCount; i++) {
            if (activities[i].getActivityCode().equals(code)) {
                return activities[i];
            }
        }
        return null;
    }

    public String getCenterName() {
        return centerName;
    }

    public int getActivityCount() {
        return activityCount;
    }
}
