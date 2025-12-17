package com.aquafitness.interfaces;

/**
 * Interface Cancelable - Define la capacidad de cancelar inscripciones
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Cancelable {
    boolean cancelarInscripcion(String nombreParticipante, String motivo);
    double calcularReembolso(int diasAnticipacion, double montoTotal);
    boolean esCancelable(int diasAnticipacion);
    String obtenerPoliticaCancelacion();
}

