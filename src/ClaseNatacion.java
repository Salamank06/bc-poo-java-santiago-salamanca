public class ClaseNatacion {
    
    // ATRIBUTOS
    private String codigoClase;       
    private String nivel;             
    private String instructor;        
    private int cuposDisponibles;     
    private double precioMensual;     
    private boolean esActiva;         
    
    // CONSTRUCTOR
    public ClaseNatacion(String codigoClase, String nivel, String instructor, int cuposDisponibles, double precioMensual) {
        this.codigoClase = codigoClase;
        this.nivel = nivel;
        this.instructor = instructor;
        this.cuposDisponibles = cuposDisponibles;
        this.precioMensual = precioMensual;
        this.esActiva = true; 
    }
    
    // MÉTODOS
    
    public void mostrarDetalles() {
        System.out.println("\n*** DETALLE DE CLASE ***");
        System.out.println(" Código: " + codigoClase + " (" + nivel + ")");
        System.out.println(" Instructor: " + instructor);
        System.out.println(" Cupos Restantes: " + cuposDisponibles);
        System.out.printf(" Precio/Mes: $%.2f%n", precioMensual);
        System.out.println(" Estado: " + (esActiva ? "ACTIVA" : "INACTIVA"));
    }
    
    public double calcularIngresoMaximo() {
        int cuposMaximos = 12; 
        int cuposOcupados = cuposMaximos - cuposDisponibles;
        return cuposOcupados * precioMensual;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public void setEsActiva(boolean activa) {
        this.esActiva = activa;
        System.out.println("-> La clase " + codigoClase + " ha sido marcada como " + (activa ? "ACTIVA" : "INACTIVA") + ".");
    }

    public boolean inscribirEstudiante() {
        if (esActiva && cuposDisponibles > 0) {
            cuposDisponibles--;
            System.out.println("-> Estudiante inscrito. Cupos restantes: " + cuposDisponibles);
            return true;
        } else {
            System.out.println("-> INSCRIPCIÓN FALLIDA: La clase no está activa o no tiene cupos.");
            return false;
        }
    }
}
