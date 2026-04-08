import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

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
    void testFilter_CapacityGreaterThanThreshold() {
        List<PassengerBogie> bogies = sampleBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<PassengerBogie> bogies = sampleBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<PassengerBogie> bogies = sampleBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<PassengerBogie> bogies = sampleBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(3, result.size(), "Three bogies should match capacity > 70.");
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("AC Chair", 40),
                new PassengerBogie("Sleeper", 50)
        );
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty(), "No bogies should match capacity > 70.");
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 80),
                new PassengerBogie("AC Chair", 90)
        );
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(bogies.size(), result.size(), "All bogies should match capacity > 70.");
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<PassengerBogie> bogies = new ArrayList<>();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty(), "Empty list should return empty result.");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<PassengerBogie> bogies = sampleBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(5, bogies.size(), "Original list should remain unchanged.");
    }
}

