/**
 * Subclase: Clase de Natación
 * Hereda de AquaticActivity
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 04
 */
public class SwimmingLesson extends AquaticActivity {
    // Atributos específicos de SwimmingLesson
    private String level; // Bebés, Niños, Adolescentes, Adultos
    private String techniquesFocus; // Crol, Espalda, Pecho, Mariposa
    private boolean includesCertification;

    // Constructor que llama al constructor del padre con super()
    public SwimmingLesson(String activityCode, String activityName, String instructorName,
                         String schedule, int durationMinutes, double pricePerSession, 
                         int maxParticipants, String level, String techniquesFocus, 
                         boolean includesCertification) {
        // Llamar al constructor del padre
        super(activityCode, activityName, instructorName, schedule, durationMinutes, 
              pricePerSession, maxParticipants);
        
        // Inicializar atributos propios
        this.level = level;
        this.techniquesFocus = techniquesFocus;
        this.includesCertification = includesCertification;
    }

    // Sobrescritura de métodos del padre con @Override
    @Override
    public void showInfo() {
        super.showInfo(); // Llamar método del padre
        System.out.println("Nivel: " + level);
        System.out.println("Enfoque técnico: " + techniquesFocus);
        System.out.println("Incluye certificación: " + (includesCertification ? "Sí" : "No"));
    }

    @Override
    public double calculateMonthlyPrice() {
        double basePrice = super.calculateMonthlyPrice(); // Llamar método del padre
        
        // Aplicar descuento según nivel
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

    // Método específico de SwimmingLesson
    public void evaluateProgress() {
        System.out.println("Evaluando progreso de natación para nivel " + level);
        System.out.println("Técnicas evaluadas: " + techniquesFocus);
    }

    public String getSkillLevel() {
        if (currentParticipants < maxParticipants * 0.5) {
            return "Clase con cupos disponibles - Ideal para iniciar";
        } else if (currentParticipants < maxParticipants * 0.8) {
            return "Clase en progreso - Buenos cupos";
        } else {
            return "Clase casi llena - Últimos cupos";
        }
    }

    // Getters específicos
    public String getLevel() {
        return level;
    }

    public String getTechniquesFocus() {
        return techniquesFocus;
    }

    public boolean includesCertification() {
        return includesCertification;
    }
}
