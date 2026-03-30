// File: TrainConsistManagementAppUC9.java

import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private String type;   // Passenger or Goods
    private int capacity;

    public Bogie(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + type + ", Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp{

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies (Passenger + Goods)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("AC Chair", "Passenger", 56));
        bogies.add(new Bogie("First Class", "Passenger", 40));
        bogies.add(new Bogie("Rectangular Cargo", "Goods", 1000));
        bogies.add(new Bogie("Cylindrical Cargo", "Goods", 800));
        bogies.add(new Bogie("Sleeper", "Passenger", 72)); // duplicate type for grouping demo

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // Group bogies by type using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " Bogies:");
            entry.getValue().forEach(System.out::println);
        }

        System.out.println("\nSystem ready for further operations...");
    }
}