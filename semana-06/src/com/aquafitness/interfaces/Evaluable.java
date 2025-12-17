package com.aquafitness.interfaces;

/**
 * Interface Evaluable - Define la capacidad de ser evaluado/calificado
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Evaluable {
    void agregarCalificacion(int estrellas, String comentario, String nombreParticipante);
    double obtenerPromedioCalificaciones();
    int obtenerNumeroEvaluaciones();
    boolean tieneCalificacionAlta();
}

