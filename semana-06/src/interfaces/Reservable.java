/**
 * Interface Reservable - Define la capacidad de reservar cupos
 * Cualquier actividad que permita reservas debe implementar esta interface
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Reservable {
    /**
     * Verifica si hay disponibilidad para una fecha específica
     * @param fecha Fecha en formato "YYYY-MM-DD"
     * @return true si hay cupos disponibles, false en caso contrario
     */
    boolean verificarDisponibilidad(String fecha);
    
    /**
     * Realiza una reserva para un cliente en una fecha específica
     * @param nombreCliente Nombre completo del cliente
     * @param fecha Fecha de la reserva
     * @param numeroCupos Número de cupos a reservar
     * @return Código de reserva generado
     */
    String realizarReserva(String nombreCliente, String fecha, int numeroCupos);
    
    /**
     * Cancela una reserva existente
     * @param codigoReserva Código único de la reserva
     * @return true si la cancelación fue exitosa, false en caso contrario
     */
    boolean cancelarReserva(String codigoReserva);
    
    /**
     * Obtiene el número de reservas activas
     * @return Cantidad de reservas confirmadas
     */
    int obtenerNumeroReservas();
}
