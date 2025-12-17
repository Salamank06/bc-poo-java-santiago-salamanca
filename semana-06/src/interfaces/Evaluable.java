/**
 * Interface Evaluable - Define la capacidad de ser evaluado/calificado
 * Permite que actividades reciban retroalimentación de los participantes
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Evaluable {
    /**
     * Agrega una calificación de un participante
     * @param estrellas Calificación de 1 a 5 estrellas
     * @param comentario Comentario opcional del participante
     * @param nombreParticipante Nombre de quien califica
     */
    void agregarCalificacion(int estrellas, String comentario, String nombreParticipante);
    
    /**
     * Obtiene el promedio de todas las calificaciones
     * @return Promedio de calificaciones (0.0 a 5.0)
     */
    double obtenerPromedioCalificaciones();
    
    /**
     * Obtiene el número total de evaluaciones recibidas
     * @return Cantidad de calificaciones
     */
    int obtenerNumeroEvaluaciones();
    
    /**
     * Determina si la actividad tiene calificación alta (>= 4.0)
     * @return true si el promedio es mayor o igual a 4.0, false en caso contrario
     */
    boolean tieneCalificacionAlta();
}

