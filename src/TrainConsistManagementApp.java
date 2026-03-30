// File: TrainConsistManagementAppUC7.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create list of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 40));

        System.out.println("Before Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Sort bogies by capacity using Comparator
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nAfter Sorting by Capacity (High → Low):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nSystem ready for further operations...");
    }
}