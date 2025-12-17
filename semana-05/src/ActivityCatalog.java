import java.util.ArrayList;

/**
 * Catálogo de actividades con sobrecarga de métodos y métodos polimórficos
 * Demuestra sobrecarga (overloading) y polimorfismo
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 05
 */
public class ActivityCatalog {
    private String catalogName;
    private ArrayList<AquaticActivity> activities; // ArrayList polimórfico

    public ActivityCatalog(String catalogName) {
        this.catalogName = catalogName;
        this.activities = new ArrayList<>();
    }

    // Método polimórfico: acepta cualquier AquaticActivity
    public void addActivity(AquaticActivity activity) {
        if (activity != null) {
            activities.add(activity);
            System.out.println("✓ Actividad agregada: " + activity.getActivityCode() + 
                             " - " + activity.getActivityType());
        }
    }

    // ===========================================
    // SOBRECARGA DE MÉTODOS (OVERLOADING)
    // ===========================================

    // Sobrecarga 1: Buscar por código (String)
    public AquaticActivity searchActivity(String activityCode) {
        System.out.println("→ Búsqueda por código: " + activityCode);
        for (AquaticActivity activity : activities) {
            if (activity.getActivityCode().equals(activityCode)) {
                return activity;
            }
        }
        return null;
    }

    // Sobrecarga 2: Buscar por instructor (String, String)
    public ArrayList<AquaticActivity> searchActivity(String field, String instructorName) {
        System.out.println("→ Búsqueda por instructor: " + instructorName);
        ArrayList<AquaticActivity> results = new ArrayList<>();
        for (AquaticActivity activity : activities) {
            if (activity.getInstructorName().equalsIgnoreCase(instructorName)) {
                results.add(activity);
            }
        }
        return results;
    }

    // Sobrecarga 3: Buscar por rango de precio (double, double)
    public ArrayList<AquaticActivity> searchActivity(double minPrice, double maxPrice) {
        System.out.println("→ Búsqueda por rango de precio: $" + minPrice + " - $" + maxPrice);
        ArrayList<AquaticActivity> results = new ArrayList<>();
        for (AquaticActivity activity : activities) {
            double price = activity.getPricePerSession();
            if (price >= minPrice && price <= maxPrice) {
                results.add(activity);
            }
        }
        return results;
    }

    // Sobrecarga 4: Buscar por duración (int)
    public ArrayList<AquaticActivity> searchActivity(int durationMinutes) {
        System.out.println("→ Búsqueda por duración: " + durationMinutes + " minutos");
        ArrayList<AquaticActivity> results = new ArrayList<>();
        for (AquaticActivity activity : activities) {
            if (activity.getDurationMinutes() == durationMinutes) {
                results.add(activity);
            }
        }
        return results;
    }

    // ===========================================
    // MÉTODOS POLIMÓRFICOS
    // ===========================================

    // Método polimórfico: procesa cualquier actividad
    public void processActivity(AquaticActivity activity) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     PROCESANDO ACTIVIDAD               ║");
        System.out.println("╚════════════════════════════════════════╝");
        activity.showInfo(); // Polimorfismo: llama al método de la subclase
        System.out.println("Tipo específico: " + activity.getActivityType());
        System.out.println("Precio mensual: $" + activity.calculateMonthlyPrice());
    }

    // Método polimórfico: procesa todas las actividades
    public void processAllActivities() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     PROCESANDO TODAS LAS ACTIVIDADES                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        for (AquaticActivity activity : activities) {
            System.out.println("\n→ " + activity.getActivityCode() + " (" + activity.getActivityType() + ")");
            System.out.println("  Precio mensual: $" + activity.calculateMonthlyPrice()); // Dynamic binding
            System.out.println("  Cupos disponibles: " + activity.getAvailableSpots());
        }
    }

    // Método polimórfico: calcula ingresos totales
    public double calculateTotalRevenue() {
        double total = 0;
        for (AquaticActivity activity : activities) {
            // Polimorfismo: cada subclase calcula su precio de forma diferente
            total += activity.calculateMonthlyPrice() * activity.getCurrentParticipants();
        }
        return total;
    }

    // Método polimórfico: genera reporte detallado
    public void generateReport() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          REPORTE DETALLADO DEL CATÁLOGO                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("Catálogo: " + catalogName);
        System.out.println("Total de actividades: " + activities.size());
        System.out.println("──────────────────────────────────────────────────────────");

        int swimmingCount = 0;
        int aerobicsCount = 0;
        int therapyCount = 0;
        int totalParticipants = 0;
        double totalRevenue = 0;

        for (AquaticActivity activity : activities) {
            // Usar instanceof para identificar tipo específico
            if (activity instanceof SwimmingLesson) {
                swimmingCount++;
            } else if (activity instanceof AquaAerobics) {
                aerobicsCount++;
            } else if (activity instanceof HydroTherapy) {
                therapyCount++;
            }

            totalParticipants += activity.getCurrentParticipants();
            totalRevenue += activity.calculateMonthlyPrice() * activity.getCurrentParticipants();
        }

        System.out.println("Clases de Natación: " + swimmingCount);
        System.out.println("Aquaeróbicos: " + aerobicsCount);
        System.out.println("Hidroterapia: " + therapyCount);
        System.out.println("Participantes totales: " + totalParticipants);
        System.out.println("Ingresos mensuales estimados: $" + totalRevenue);
    }

    // Método polimórfico: muestra actividades con cupos disponibles
    public void showAvailableActivities() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          ACTIVIDADES CON CUPOS DISPONIBLES               ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        for (AquaticActivity activity : activities) {
            if (activity.getAvailableSpots() > 0) {
                System.out.println("\n→ " + activity.getActivityName());
                System.out.println("  Código: " + activity.getActivityCode());
                System.out.println("  Tipo: " + activity.getActivityType()); // Polimorfismo
                System.out.println("  Cupos disponibles: " + activity.getAvailableSpots());
                System.out.println("  Precio/sesión: $" + activity.getPricePerSession());
            }
        }
    }

    // Método polimórfico: aplica descuento a todas las actividades
    public void applyDiscount(double percentage) {
        System.out.println("\n→ Aplicando descuento del " + percentage + "% a todas las actividades");
        for (AquaticActivity activity : activities) {
            double originalPrice = activity.getPricePerSession();
            double newPrice = originalPrice * (1 - percentage / 100);
            System.out.println("  " + activity.getActivityCode() + ": $" + originalPrice + 
                             " → $" + newPrice);
        }
    }

    // Getters
    public String getCatalogName() {
        return catalogName;
    }

    public ArrayList<AquaticActivity> getActivities() {
        return activities;
    }

    public int getActivityCount() {
        return activities.size();
    }
}
