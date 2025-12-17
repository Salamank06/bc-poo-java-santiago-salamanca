/**
 * Clase Pool con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class Pool {
    private static final double MIN_TEMPERATURE = 20.0;
    private static final double MAX_TEMPERATURE = 35.0;
    private static final int MIN_CAPACITY = 1;
    private static final int MAX_CAPACITY = 100;

    private String poolId;
    private String poolName;
    private String poolType;
    private int maxCapacity;
    private double temperature;
    private boolean isAvailable;

    // Constructor completo con validaciones
    public Pool(String poolId, String poolName, String poolType, int maxCapacity, double temperature) {
        setPoolId(poolId);
        setPoolName(poolName);
        setPoolType(poolType);
        setMaxCapacity(maxCapacity);
        setTemperature(temperature);
        this.isAvailable = true;
    }

    // Constructor sobrecargado: temperatura por defecto (27°C)
    public Pool(String poolId, String poolName, String poolType, int maxCapacity) {
        this(poolId, poolName, poolType, maxCapacity, 27.0);
    }

    // Constructor sobrecargado: datos mínimos (capacidad y temperatura por defecto)
    public Pool(String poolId, String poolName, String poolType) {
        this(poolId, poolName, poolType, 30, 27.0);
    }

    // Métodos privados de validación
    private boolean isValidPoolId(String id) {
        return id != null && id.matches("P\\d{3}");
    }

    private boolean isValidPoolName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 3;
    }

    private boolean isValidPoolType(String type) {
        return type != null && !type.trim().isEmpty();
    }

    private boolean isValidCapacity(int capacity) {
        return capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY;
    }

    private boolean isValidTemperature(double temp) {
        return temp >= MIN_TEMPERATURE && temp <= MAX_TEMPERATURE;
    }

    // Métodos públicos
    public void showPoolInfo() {
        System.out.println("=== PISCINA ===");
        System.out.println("ID: " + poolId);
        System.out.println("Nombre: " + poolName);
        System.out.println("Tipo: " + poolType);
        System.out.println("Capacidad máxima: " + maxCapacity + " personas");
        System.out.println("Temperatura: " + temperature + "°C");
        System.out.println("Estado: " + (isAvailable ? "Disponible" : "Ocupada"));
        System.out.println("Temperatura: " + getTemperatureStatus());
    }

    public String getPoolSummary() {
        return poolName + " (" + poolType + ") - Cap: " + maxCapacity;
    }

    public boolean canAccommodate(int numberOfPeople) {
        return numberOfPeople > 0 && numberOfPeople <= maxCapacity && isAvailable;
    }

    public String getTemperatureStatus() {
        if (temperature < 25) {
            return "Fría";
        } else if (temperature <= 28) {
            return "Templada";
        } else {
            return "Cálida";
        }
    }

    public void adjustTemperature(double adjustment) {
        double newTemp = temperature + adjustment;
        if (isValidTemperature(newTemp)) {
            temperature = newTemp;
            System.out.println("✓ Temperatura ajustada a " + temperature + "°C");
        } else {
            System.out.println("✗ No se puede ajustar. Temperatura fuera de rango permitido");
        }
    }

    // Getters
    public String getPoolId() {
        return poolId;
    }

    public String getPoolName() {
        return poolName;
    }

    public String getPoolType() {
        return poolType;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters con validaciones
    public void setPoolId(String poolId) {
        if (!isValidPoolId(poolId)) {
            throw new IllegalArgumentException("ID de piscina inválido. Debe tener formato PXXX");
        }
        this.poolId = poolId;
    }

    public void setPoolName(String poolName) {
        if (!isValidPoolName(poolName)) {
            throw new IllegalArgumentException("Nombre de piscina inválido. Debe tener al menos 3 caracteres");
        }
        this.poolName = poolName.trim();
    }

    public void setPoolType(String poolType) {
        if (!isValidPoolType(poolType)) {
            throw new IllegalArgumentException("Tipo de piscina inválido. No puede estar vacío");
        }
        this.poolType = poolType.trim();
    }

    public void setMaxCapacity(int maxCapacity) {
        if (!isValidCapacity(maxCapacity)) {
            throw new IllegalArgumentException("Capacidad inválida. Debe estar entre " + MIN_CAPACITY + " y " + MAX_CAPACITY);
        }
        this.maxCapacity = maxCapacity;
    }

    public void setTemperature(double temperature) {
        if (!isValidTemperature(temperature)) {
            throw new IllegalArgumentException("Temperatura inválida. Debe estar entre " + MIN_TEMPERATURE + "°C y " + MAX_TEMPERATURE + "°C");
        }
        this.temperature = temperature;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
