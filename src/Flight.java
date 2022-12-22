import java.time.DayOfWeek;
import java.time.LocalTime;

public record Flight(DayOfWeek dayOfWeek, LocalTime departureTime, LocalTime arrivalTime, int departureDelay,
                     int arrivalDelay, int duration, int distance, boolean cancelled, boolean diverted) {

    @Override
    public String toString() {
        return "Flight{" + "dayOfWeek=" + dayOfWeek + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", departureDelay=" + departureDelay + ", arrivalDelay=" + arrivalDelay + ", duration=" + duration + ", distance=" + distance + ", cancelled=" + cancelled + ", diverted=" + diverted + '}';
    }

}