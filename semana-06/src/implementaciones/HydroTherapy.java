import java.util.ArrayList;

/**
 * Clase HydroTherapy - Hidroterapia especializada
 * Implementa Reservable, Evaluable y Cancelable (múltiple implementación completa)
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 06
 */
public class HydroTherapy extends AquaticActivity implements Reservable, Evaluable, Cancelable {
    // Atributos específicos de hidroterapia
    private String medicalCondition; // Condición que trata
    private String therapistName;
    private boolean requiresMedicalApproval;
    private int sessionsRecommended;
    
    // Atributos para Reservable
    private ArrayList<String> reservas;
    private int contadorReservas;
    
    // Atributos para Evaluable
    private ArrayList<Integer> calificaciones;
    private ArrayList<String> comentarios;
    
    // Atributos para Cancelable
    private ArrayList<String> pacientes;
    private ArrayList<String> cancelaciones;
    
    public HydroTherapy(String activityCode, String activityName, String instructorName,
                       String schedule, int durationMinutes, double pricePerSession,
                       int maxParticipants, String medicalCondition, String therapistName,
                       boolean requiresMedicalApproval, int sessionsRecommended) {
        super(activityCode, activityName, instructorName, schedule, durationMinutes,
              pricePerSession, maxParticipants);
        this.medicalCondition = medicalCondition;
        this.therapistName = therapistName;
        this.requiresMedicalApproval = requiresMedicalApproval;
        this.sessionsRecommended = sessionsRecommended;
        
        // Inicializar listas para las 3 interfaces
        this.reservas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.cancelaciones = new ArrayList<>();
        this.contadorReservas = 5000;
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    // =============================================
    
    @Override
    public double calculateMonthlyPrice() {
        // Precio base: sesiones recomendadas por mes
        double basePrice = pricePerSession * sessionsRecommended;
        
        // Hidroterapia es servicio médico especializado: +50%
        return basePrice * 1.5;
    }
    
    @Override
    public String getActivityType() {
        return "Hidroterapia - " + medicalCondition;
    }
    
    @Override
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     HIDROTERAPIA                       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código: " + activityCode);
        System.out.println("Nombre: " + activityName);
        System.out.println("Condición tratada: " + medicalCondition);
        System.out.println("Terapeuta: " + therapistName);
        System.out.println("Horario: " + schedule);
        System.out.println("Duración: " + durationMinutes + " minutos");
        System.out.println("Sesiones recomendadas: " + sessionsRecommended + "/mes");
        System.out.println("Requiere aprobación médica: " + (requiresMedicalApproval ? "Sí" : "No"));
        System.out.println("Precio/sesión: $" + pricePerSession);
        System.out.println("Precio mensual: $" + calculateMonthlyPrice());
        System.out.println("Cupos: " + currentParticipants + "/" + maxParticipants);
        System.out.println("Reservas activas: " + obtenerNumeroReservas());
        System.out.println("Calificación: " + obtenerPromedioCalificaciones() + " ⭐ (" + 
                         obtenerNumeroEvaluaciones() + " evaluaciones)");
        System.out.println("Política de cancelación: " + obtenerPoliticaCancelacion());
    }
    
    @Override
    public boolean enrollParticipant() {
        if (requiresMedicalApproval) {
            System.out.println("⚠️ Inscripción requiere aprobación médica previa");
        }
        return super.enrollParticipant();
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE INTERFACE RESERVABLE
    // =============================================
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        int cuposDisponibles = getAvailableSpots();
        System.out.println("→ Verificando disponibilidad de hidroterapia para " + fecha + 
                         ": " + cuposDisponibles + " cupos");
        
        if (requiresMedicalApproval) {
            System.out.println("  ⚕️ Nota: Requiere presentar orden médica");
        }
        
        return cuposDisponibles > 0;
    }
    
    @Override
    public String realizarReserva(String nombreCliente, String fecha, int numeroCupos) {
        if (numeroCupos <= 0 || numeroCupos > getAvailableSpots()) {
            System.out.println("✗ No se puede reservar " + numeroCupos + " cupo(s) para hidroterapia");
            return null;
        }
        
        String codigoReserva = activityCode + "-H" + (contadorReservas++);
        String reserva = codigoReserva + "|" + nombreCliente + "|" + fecha + "|" + numeroCupos;
        reservas.add(reserva);
        pacientes.add(nombreCliente);
        
        // Reducir cupos disponibles
        for (int i = 0; i < numeroCupos; i++) {
            enrollParticipant();
        }
        
        System.out.println("✓ Reserva de hidroterapia exitosa: " + codigoReserva);
        if (requiresMedicalApproval) {
            System.out.println("  📋 Recordatorio: Traer orden médica el día de la sesión");
        }
        
        return codigoReserva;
    }
    
    @Override
    public boolean cancelarReserva(String codigoReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).startsWith(codigoReserva)) {
                String reserva = reservas.remove(i);
                String[] partes = reserva.split("\\|");
                String nombrePaciente = partes[1];
                int cupos = Integer.parseInt(partes[3]);
                
                // Liberar cupos
                for (int j = 0; j < cupos; j++) {
                    withdrawParticipant();
                }
                
                pacientes.remove(nombrePaciente);
                cancelaciones.add(nombrePaciente + ": Reserva cancelada");
                
                System.out.println("✓ Reserva de hidroterapia " + codigoReserva + " cancelada");
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
        System.out.println("✓ Evaluación de hidroterapia agregada: " + estrellas + " ⭐ por " + 
                         nombreParticipante);
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
        return obtenerPromedioCalificaciones() >= 4.5; // Estándar más alto para terapia
    }
    
    // =============================================
    // IMPLEMENTACIÓN DE INTERFACE CANCELABLE
    // =============================================
    
    @Override
    public boolean cancelarInscripcion(String nombreParticipante, String motivo) {
        if (pacientes.contains(nombreParticipante)) {
            pacientes.remove(nombreParticipante);
            cancelaciones.add(nombreParticipante + ": " + motivo);
            withdrawParticipant();
            System.out.println("✓ Tratamiento de " + nombreParticipante + " cancelado");
            System.out.println("  Motivo: " + motivo);
            return true;
        }
        System.out.println("✗ " + nombreParticipante + " no está inscrito en hidroterapia");
        return false;
    }
    
    @Override
    public double calcularReembolso(int diasAnticipacion, double montoTotal) {
        // Política más estricta por ser servicio médico
        if (diasAnticipacion >= 14) {
            return montoTotal; // Reembolso total con 2 semanas de anticipación
        } else if (diasAnticipacion >= 7) {
            return montoTotal * 0.70; // 70% con 1 semana
        } else if (diasAnticipacion >= 3) {
            return montoTotal * 0.40; // 40% con 3 días
        } else {
            return 0; // Sin reembolso con menos de 3 días
        }
    }
    
    @Override
    public boolean esCancelable(int diasAnticipacion) {
        // Siempre se puede cancelar, pero varía el reembolso
        return true;
    }
    
    @Override
    public String obtenerPoliticaCancelacion() {
        return "≥14 días: 100% | 7-13 días: 70% | 3-6 días: 40% | <3 días: 0% (servicio médico)";
    }
    
    // =============================================
    // MÉTODOS ESPECÍFICOS DE HIDROTERAPIA
    // =============================================
    
    /**
     * Genera un plan de tratamiento personalizado
     * @param nombrePaciente Nombre del paciente
     * @return Plan de tratamiento en texto
     */
    public String generateTherapyPlan(String nombrePaciente) {
        StringBuilder plan = new StringBuilder();
        plan.append("╔══════════════════════════════════════════════╗\n");
        plan.append("║     PLAN DE HIDROTERAPIA                     ║\n");
        plan.append("╚══════════════════════════════════════════════╝\n");
        plan.append("Paciente: ").append(nombrePaciente).append("\n");
        plan.append("Condición: ").append(medicalCondition).append("\n");
        plan.append("Terapeuta: ").append(therapistName).append("\n");
        plan.append("Sesiones recomendadas: ").append(sessionsRecommended).append("/mes\n");
        plan.append("Duración por sesión: ").append(durationMinutes).append(" minutos\n");
        plan.append("──────────────────────────────────────────────\n");
        plan.append("Objetivos:\n");
        plan.append("- Reducir dolor e inflamación\n");
        plan.append("- Mejorar movilidad articular\n");
        plan.append("- Fortalecer musculatura\n");
        plan.append("- Rehabilitar función motora\n");
        plan.append("══════════════════════════════════════════════\n");
        
        return plan.toString();
    }
    
    /**
     * Verifica si el paciente tiene orden médica
     * @param nombrePaciente Nombre del paciente
     * @return Simulación de verificación
     */
    public boolean verificarOrdenMedica(String nombrePaciente) {
        if (requiresMedicalApproval) {
            System.out.println("⚕️ Verificando orden médica para " + nombrePaciente + "...");
            System.out.println("✓ Orden médica válida y vigente");
            return true;
        }
        return true; // No require orden
    }
    
    // =============================================
    // GETTERS ESPECÍFICOS
    // =============================================
    
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
    
    public ArrayList<String> getPacientes() {
        return new ArrayList<>(pacientes);
    }
    
    public ArrayList<String> getComentarios() {
        return new ArrayList<>(comentarios);
    }
}
