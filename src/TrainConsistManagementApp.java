// File: TrainConsistManagementAppUC5.java

import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Initialize LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to attach a duplicate bogie
        trainFormation.add("Sleeper"); // duplicate ignored automatically

        // Display final formation
        System.out.println("Final Train Formation (Insertion Order Preserved): " + trainFormation);

        System.out.println("System ready for further operations...");
    }
}