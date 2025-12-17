package com.aquafitness.interfaces;

/**
 * Interface Reservable - Define la capacidad de reservar cupos
 * @author Santiago Salamanca Narváez
 * @version 1.0 - Semana 06
 */
public interface Reservable {
    boolean verificarDisponibilidad(String fecha);
    String realizarReserva(String nombreCliente, String fecha, int numeroCupos);
    boolean cancelarReserva(String codigoReserva);
    int obtenerNumeroReservas();
}

