/**
 * Clase Schedule con encapsulación completa y validaciones
 * @author Santiago Salamanca Narváez
 * @version 2.0 - Semana 03
 */
public class Schedule {
    private static final String[] VALID_DAYS = {
        "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo",
        "Lunes y Miércoles", "Martes y Jueves", "Lunes a Viernes"
    };

    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private int durationMinutes;

    // Constructor completo con validaciones
    public Schedule(String dayOfWeek, String startTime, String endTime) {
        setDayOfWeek(dayOfWeek);
        setStartTime(startTime);
        setEndTime(endTime);
        this.durationMinutes = calculateDuration(startTime, endTime);
    }

    // Constructor sobrecargado: horario de 1 hora por defecto
    public Schedule(String dayOfWeek, String startTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = calculateEndTime(startTime, 60);
        this.durationMinutes = 60;
    }

    // Constructor sobrecargado: con duración específica
    public Schedule(String dayOfWeek, String startTime, int durationMinutes) {
        setDayOfWeek(dayOfWeek);
        setStartTime(startTime);
        this.durationMinutes = durationMinutes;
        this.endTime = calculateEndTime(startTime, durationMinutes);
    }

    // Métodos privados de validación
    private boolean isValidDay(String day) {
        if (day == null || day.trim().isEmpty()) {
            return false;
        }
        for (String validDay : VALID_DAYS) {
            if (validDay.equalsIgnoreCase(day.trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidTime(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            return false;
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }

    private boolean isValidDuration(int duration) {
        return duration > 0 && duration <= 240; // máximo 4 horas
    }

    // Métodos privados auxiliares
    private int calculateDuration(String start, String end) {
        if (!isValidTime(start) || !isValidTime(end)) {
            throw new IllegalArgumentException("Formato de hora inválido");
        }
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");
        int startMinutes = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
        int endMinutes = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]);
        
        int duration = endMinutes - startMinutes;
        if (duration <= 0) {
            throw new IllegalArgumentException("La hora de fin debe ser posterior a la hora de inicio");
        }
        return duration;
    }

    private String calculateEndTime(String start, int durationMinutes) {
        String[] parts = start.split(":");
        int startHour = Integer.parseInt(parts[0]);
        int startMinute = Integer.parseInt(parts[1]);
        
        int totalMinutes = startHour * 60 + startMinute + durationMinutes;
        int endHour = (totalMinutes / 60) % 24;
        int endMinute = totalMinutes % 60;
        
        return String.format("%02d:%02d", endHour, endMinute);
    }

    // Métodos públicos
    public void showScheduleInfo() {
        System.out.println("=== HORARIO ===");
        System.out.println("Día: " + dayOfWeek);
        System.out.println("Hora: " + startTime + " - " + endTime);
        System.out.println("Duración: " + durationMinutes + " minutos (" + getFormattedDuration() + ")");
        System.out.println("Turno: " + getShift());
    }

    public String getScheduleSummary() {
        return dayOfWeek + " " + startTime + "-" + endTime;
    }

    public boolean isInMorning() {
        int hour = Integer.parseInt(startTime.split(":")[0]);
        return hour >= 6 && hour < 12;
    }

    public String getShift() {
        int hour = Integer.parseInt(startTime.split(":")[0]);
        if (hour >= 6 && hour < 12) {
            return "Mañana";
        } else if (hour >= 12 && hour < 18) {
            return "Tarde";
        } else {
            return "Noche";
        }
    }

    public String getFormattedDuration() {
        int hours = durationMinutes / 60;
        int minutes = durationMinutes % 60;
        if (hours > 0 && minutes > 0) {
            return hours + "h " + minutes + "min";
        } else if (hours > 0) {
            return hours + "h";
        } else {
            return minutes + "min";
        }
    }

    // Getters
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Setters con validaciones
    public void setDayOfWeek(String dayOfWeek) {
        if (!isValidDay(dayOfWeek)) {
            throw new IllegalArgumentException("Día inválido. Debe ser un día de la semana válido");
        }
        this.dayOfWeek = dayOfWeek.trim();
    }

    public void setStartTime(String startTime) {
        if (!isValidTime(startTime)) {
            throw new IllegalArgumentException("Hora de inicio inválida. Debe tener formato HH:MM");
        }
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        if (!isValidTime(endTime)) {
            throw new IllegalArgumentException("Hora de fin inválida. Debe tener formato HH:MM");
        }
        this.endTime = endTime;
        this.durationMinutes = calculateDuration(this.startTime, endTime);
    }
}
