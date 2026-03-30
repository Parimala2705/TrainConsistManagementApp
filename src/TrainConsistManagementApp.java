// File: TrainConsistManagementAppUC3.java

import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Initialize a HashSet for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display final set of bogie IDs
        System.out.println("Unique Bogie IDs in Train Consist: " + bogieIds);

        System.out.println("System ready for further operations...");
    }
}