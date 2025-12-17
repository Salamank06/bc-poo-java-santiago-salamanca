package com.aquafitness.excepciones;

/**
 * Excepción lanzada cuando se intenta realizar una operación
 * sobre una actividad que ha sido desactivada o cancelada.
 * 
 * Casos de uso:
 * - Intento de inscripción en actividad cancelada
 * - Reserva en actividad temporalmente suspendida
 * - Modificación de actividad deshabilitada
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 07
 */
public class ActividadInactivaException extends Exception {
    
    /**
     * Constructor con mensaje de error
     * @param mensaje Descripción del estado de la actividad
     */
    public ActividadInactivaException(String mensaje) {
        super(mensaje);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del estado
     * @param causa Excepción original que causó este error
     */
    public ActividadInactivaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

