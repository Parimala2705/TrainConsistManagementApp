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
        // Prepare dataset
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 55),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("Sleeper", 60),
                new PassengerBogie("AC Chair", 90)
        );

        // Stream aggregation: map capacity → reduce sum
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        // Display results
        System.out.println("Passenger Bogies: " + bogies);
        System.out.println("Total seating capacity of train: " + totalSeats);
    }
}

