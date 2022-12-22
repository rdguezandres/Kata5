import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        FlightStore store = new SqliteFlightStore(new File("flights.db"));
        Histogram<String> histogram = new Histogram<>();
        for (Flight flight : store.flights()) {
            histogram.increment(flight.dayOfWeek().toString());
        }
        HistogramDisplay histo = new HistogramDisplay(histogram);
        histo.execute();
    }

}
