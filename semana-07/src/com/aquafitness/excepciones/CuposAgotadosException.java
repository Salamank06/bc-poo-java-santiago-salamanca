package com.aquafitness.excepciones;

/**
 * Excepción lanzada cuando una actividad no tiene cupos disponibles.
 * 
 * Esta excepción se utiliza cuando:
 * - Se intenta inscribir a un participante en una actividad llena
 * - Se intenta hacer una reserva sin disponibilidad
 * - El número de cupos solicitados excede la disponibilidad
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 07
 */
public class CuposAgotadosException extends Exception {
    
    /**
     * Constructor con mensaje de error
     * @param mensaje Descripción del problema de disponibilidad
     */
    public CuposAgotadosException(String mensaje) {
        super(mensaje);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del problema
     * @param causa Excepción original que causó este error
     */
    public CuposAgotadosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

