/**
 * Clase que representa una piscina del centro acuático
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class Pool {
    private String poolId;
    private String poolName;
    private String poolType;
    private int maxCapacity;
    private double temperature;
    private boolean isAvailable;

    public Pool(String poolId, String poolName, String poolType, int maxCapacity, double temperature) {
        this.poolId = poolId;
        this.poolName = poolName;
        this.poolType = poolType;
        this.maxCapacity = maxCapacity;
        this.temperature = temperature;
        this.isAvailable = true;
    }

    public void showPoolInfo() {
        System.out.println("=== PISCINA ===");
        System.out.println("ID: " + poolId);
        System.out.println("Nombre: " + poolName);
        System.out.println("Tipo: " + poolType);
        System.out.println("Capacidad máxima: " + maxCapacity + " personas");
        System.out.println("Temperatura: " + temperature + "°C");
        System.out.println("Estado: " + (isAvailable ? "Disponible" : "Ocupada"));
    }

    public String getPoolSummary() {
        return poolName + " (" + poolType + ") - Cap: " + maxCapacity;
    }

    public boolean canAccommodate(int numberOfPeople) {
        return numberOfPeople <= maxCapacity && isAvailable;
    }

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

    public void setTemperature(double temperature) {
        if (temperature >= 20 && temperature <= 35) {
            this.temperature = temperature;
        }
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

