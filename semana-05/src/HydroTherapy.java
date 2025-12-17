/**
 * Subclase: Hidroterapia
 * Hereda de AquaticActivity
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 04
 */
public class HydroTherapy extends AquaticActivity {
    // Atributos específicos de HydroTherapy
    private String medicalCondition; // Rehabilitación, Lesiones, Estrés, Post-operatorio
    private String therapistName;
    private boolean requiresMedicalApproval;
    private int sessionsRecommended;

    // Constructor que llama al constructor del padre con super()
    public HydroTherapy(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String medicalCondition, String therapistName,
                       boolean requiresMedicalApproval, int sessionsRecommended) {
        // Llamar al constructor del padre
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        
        // Inicializar atributos propios
        this.medicalCondition = medicalCondition;
        this.therapistName = therapistName;
        this.requiresMedicalApproval = requiresMedicalApproval;
        this.sessionsRecommended = sessionsRecommended;
    }

    // Sobrescritura de métodos del padre con @Override
    @Override
    public void showInfo() {
        super.showInfo(); // Llamar método del padre
        System.out.println("Condición tratada: " + medicalCondition);
        System.out.println("Terapeuta: " + therapistName);
        System.out.println("Requiere aprobación médica: " + (requiresMedicalApproval ? "Sí" : "No"));
        System.out.println("Sesiones recomendadas: " + sessionsRecommended);
    }

    @Override
    public double calculateMonthlyPrice() {
        double basePrice = super.calculateMonthlyPrice(); // Llamar método del padre
        
        // Hidroterapia es más costosa por ser especializada
        return basePrice * 1.5; // 50% más que actividades regulares
    }

    @Override
    public String getActivityType() {
        return "Hidroterapia - " + medicalCondition;
    }

    @Override
    public boolean enrollParticipant() {
        if (requiresMedicalApproval) {
            System.out.println("⚠️ Inscripción requiere aprobación médica previa");
        }
        return super.enrollParticipant();
    }

    // Métodos específicos de HydroTherapy
    public void assessPatient() {
        System.out.println("📋 Evaluación inicial del paciente");
        System.out.println("Condición: " + medicalCondition);
        System.out.println("Terapeuta asignado: " + therapistName);
    }

    public void generateTherapyPlan() {
        System.out.println("📝 Plan de terapia generado");
        System.out.println("Duración recomendada: " + sessionsRecommended + " sesiones");
        System.out.println("Frecuencia: 2-3 veces por semana");
    }

    public double calculateTreatmentCost() {
        return pricePerSession * sessionsRecommended;
    }

    public String getTherapyGoals() {
        switch (medicalCondition) {
            case "Rehabilitación":
                return "Recuperar movilidad y fuerza muscular";
            case "Lesiones":
                return "Reducir inflamación y dolor, restaurar función";
            case "Estrés":
                return "Relajación muscular y reducción de tensión";
            case "Post-operatorio":
                return "Recuperación funcional progresiva";
            default:
                return "Mejorar condición general del paciente";
        }
    }

    // Getters específicos
    public String getMedicalCondition() {
        return medicalCondition;
    }

    public String getTherapistName() {
        return therapistName;
    }

    public boolean requiresMedicalApproval() {
        return requiresMedicalApproval;
    }

    public int getSessionsRecommended() {
        return sessionsRecommended;
    }
}

