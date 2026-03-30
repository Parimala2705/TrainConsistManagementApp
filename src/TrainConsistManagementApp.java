// File: TrainConsistManagementAppUC2.java

import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Initialize passenger bogies list
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("Passenger bogies added: " + passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + passengerBogies);

        // Check if Sleeper exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper bogie exist? " + hasSleeper);

        // Final list state
        System.out.println("Final passenger bogie list: " + passengerBogies);

        System.out.println("System ready for further operations...");
    }
}