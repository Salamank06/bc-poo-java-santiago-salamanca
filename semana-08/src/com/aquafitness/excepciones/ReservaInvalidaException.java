package com.aquafitness.excepciones;

/**
 * Excepción lanzada cuando una reserva contiene datos inválidos
 * o no cumple con los requisitos del sistema.
 * 
 * Casos de uso:
 * - Código de reserva con formato incorrecto
 * - Número de cupos inválido (negativo o cero)
 * - Fecha de reserva en el pasado
 * - Cliente con datos incompletos
 * 
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 07
 */
public class ReservaInvalidaException extends Exception {
    
    /**
     * Constructor con mensaje de error
     * @param mensaje Descripción del error
     */
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param mensaje Descripción del error
     * @param causa Excepción original que causó este error
     */
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}


