/**
 * Subclase: Aquaeróbicos
 * Hereda de AquaticActivity
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 04
 */
public class AquaAerobics extends AquaticActivity {
    // Atributos específicos de AquaAerobics
    private String intensityLevel; // Baja, Media, Alta
    private String musicGenre; // Pop, Electrónica, Latina
    private boolean requiresEquipment;
    private int caloriesBurned;

    // Constructor que llama al constructor del padre con super()
    public AquaAerobics(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String intensityLevel, String musicGenre,
                       boolean requiresEquipment) {
        // Llamar al constructor del padre
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        
        // Inicializar atributos propios
        this.intensityLevel = intensityLevel;
        this.musicGenre = musicGenre;
        this.requiresEquipment = requiresEquipment;
        this.caloriesBurned = calculateCalories();
    }

    // Método privado para calcular calorías
    private int calculateCalories() {
        int baseCalories = durationMinutes * 5; // 5 calorías por minuto base
        
        if (intensityLevel.equals("Alta")) {
            return (int)(baseCalories * 1.5);
        } else if (intensityLevel.equals("Media")) {
            return (int)(baseCalories * 1.2);
        }
        return baseCalories;
    }

    // Sobrescritura de métodos del padre con @Override
    @Override
    public void showInfo() {
        super.showInfo(); // Llamar método del padre
        System.out.println("Intensidad: " + intensityLevel);
        System.out.println("Género musical: " + musicGenre);
        System.out.println("Requiere equipo: " + (requiresEquipment ? "Sí (flotadores, pesas)" : "No"));
        System.out.println("Calorías quemadas estimadas: " + caloriesBurned + " kcal");
    }

    @Override
    public double calculateMonthlyPrice() {
        double basePrice = super.calculateMonthlyPrice(); // Llamar método del padre
        
        // Cargo adicional si requiere equipo
        if (requiresEquipment) {
            return basePrice + 20000; // $20,000 por uso de equipo
        }
        return basePrice;
    }

    @Override
    public String getActivityType() {
        return "Aquaeróbicos - Intensidad " + intensityLevel;
    }

    // Métodos específicos de AquaAerobics
    public void warmUp() {
        System.out.println("🎵 Iniciando calentamiento con música " + musicGenre);
        System.out.println("Duración: 10 minutos");
    }

    public void coolDown() {
        System.out.println("🧘 Enfriamiento y estiramientos");
        System.out.println("Reduciendo intensidad gradualmente");
    }

    public String getHealthBenefits() {
        return "Bajo impacto articular, mejora cardio, tonifica músculos, quema " + caloriesBurned + " kcal";
    }

    // Getters específicos
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
        return caloriesBurned;
    }
}

