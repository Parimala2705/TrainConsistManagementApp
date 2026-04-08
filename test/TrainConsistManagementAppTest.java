import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private List<PassengerBogie> sampleBogies() {
        return Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 55),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("Sleeper", 60),
                new PassengerBogie("AC Chair", 90)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<PassengerBogie> bogies = sampleBogies();
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(357, totalSeats, "Total seating capacity should equal sum of all bogie capacities.");
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<PassengerBogie> bogies = sampleBogies();
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        assertTrue(totalSeats > 0, "Multiple bogies should contribute to a positive total.");
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<PassengerBogie> bogies = Collections.singletonList(
                new PassengerBogie("Sleeper", 72)
        );
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, totalSeats, "Single bogie capacity should equal total.");
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<PassengerBogie> bogies = new ArrayList<>();
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats, "Empty list should return 0 total capacity.");
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<PassengerBogie> bogies = sampleBogies();
        List<Integer> capacities = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .toList();

        assertEquals(Arrays.asList(72, 55, 80, 60, 90), capacities,
                "map() should correctly extract bogie capacities.");
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<PassengerBogie> bogies = sampleBogies();
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (PassengerBogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, totalSeats, "All bogies should be included in aggregation.");
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<PassengerBogie> bogies = sampleBogies();
        bogies.stream()
                .map(PassengerBogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(5, bogies.size(), "Original list should remain unchanged after reduce operation.");
    }
}

