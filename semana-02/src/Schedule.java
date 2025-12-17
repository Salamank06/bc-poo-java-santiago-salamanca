/**
 * Clase que representa el horario de una clase de natación
 * @author Santiago Salamanca Narváez
 * @version 1.0
 */
public class Schedule {
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private int durationMinutes;

    public Schedule(String dayOfWeek, String startTime, String endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationMinutes = calculateDuration(startTime, endTime);
    }

    private int calculateDuration(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");
        int startMinutes = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
        int endMinutes = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]);
        return endMinutes - startMinutes;
    }

    public void showScheduleInfo() {
        System.out.println("=== HORARIO ===");
        System.out.println("Día: " + dayOfWeek);
        System.out.println("Hora: " + startTime + " - " + endTime);
        System.out.println("Duración: " + durationMinutes + " minutos");
    }

    public String getScheduleSummary() {
        return dayOfWeek + " " + startTime + "-" + endTime;
    }

    public boolean isInMorning() {
        int hour = Integer.parseInt(startTime.split(":")[0]);
        return hour >= 6 && hour < 12;
    }

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

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
        this.durationMinutes = calculateDuration(startTime, this.endTime);
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        this.durationMinutes = calculateDuration(this.startTime, endTime);
    }
}

