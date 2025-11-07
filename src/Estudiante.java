public class Estudiante {
    
    // ATRIBUTOS
    private int idEstudiante;        
    private String nombreCompleto;   
    private String telefonoContacto; 
    private String nivelAsignado;    
    
    // CONSTRUCTOR
    public Estudiante(int idEstudiante, String nombreCompleto, String telefonoContacto, String nivelAsignado) {
        this.idEstudiante = idEstudiante;
        this.nombreCompleto = nombreCompleto;
        this.telefonoContacto = telefonoContacto;
        this.nivelAsignado = nivelAsignado;
    }
    
    // MÉTODOS 
    
    public void mostrarPerfil() {
        System.out.println("\n-- Perfil de Estudiante --");
        System.out.println(" ID: " + idEstudiante);
        System.out.println(" Nombre: " + nombreCompleto);
        System.out.println(" Nivel: " + nivelAsignado);
    }
    
    public boolean realizarPago(double monto) {
        if (monto >= 50000) { 
            System.out.printf("-> Pago de $%.2f realizado por %s. Gracias.%n", monto, nombreCompleto);
            return true;
        } else {
            System.out.println("-> Pago insuficiente. Mínimo $50.000.");
            return false;
        }
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
