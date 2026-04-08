import java.util.*;
import java.util.stream.Collectors;

class PassengerBogie {
    private String type;   // Sleeper, AC Chair, First Class
    private int capacity;  // seat capacity

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Original bogie list (reused from UC7)
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 55),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("Sleeper", 60),
                new PassengerBogie("AC Chair", 90)
        );

        // Filtering using Streams: capacity > 60
        List<PassengerBogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Display results
        System.out.println("Original Bogie List: " + bogies);
        System.out.println("Filtered Bogie List (capacity > 60): " + filteredBogies);
    }
}

