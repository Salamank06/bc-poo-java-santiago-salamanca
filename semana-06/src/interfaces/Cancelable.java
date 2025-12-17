/**
 * Interface Cancelable - Define la capacidad de cancelar inscripciones
 * Permite gestionar la cancelación de participantes con políticas específicas
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Cancelable {
    /**
     * Cancela la inscripción de un participante
     * @param nombreParticipante Nombre del participante a dar de baja
     * @param motivo Razón de la cancelación
     * @return true si la cancelación fue exitosa, false en caso contrario
     */
    boolean cancelarInscripcion(String nombreParticipante, String motivo);
    
    /**
     * Calcula el reembolso según la política de cancelación
     * @param diasAnticipacion Días de anticipación con que se cancela
     * @param montoTotal Monto total pagado
     * @return Monto a reembolsar
     */
    double calcularReembolso(int diasAnticipacion, double montoTotal);
    
    /**
     * Verifica si se puede cancelar según las políticas
     * @param diasAnticipacion Días de anticipación
     * @return true si es posible cancelar, false en caso contrario
     */
    boolean esCancelable(int diasAnticipacion);
    
    /**
     * Obtiene la política de cancelación en texto
     * @return Descripción de la política de cancelación
     */
    String obtenerPoliticaCancelacion();
}
