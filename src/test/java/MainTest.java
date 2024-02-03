import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.*;

public class MainTest {

    @Test
    void groupDosingsByPlanDosingIdTest(){
        Main main = new Main();

        List<PlanDosing> firstPlan = Arrays.asList(new PlanDosing("1"), new PlanDosing("2"), new PlanDosing("3"));
        List<PlanDosing> secondPlan = Arrays.asList(new PlanDosing("2"), new PlanDosing("3"), new PlanDosing("4"));
        List<PlanDosing> thirdPlan = Arrays.asList(new PlanDosing("3"), new PlanDosing("4"), new PlanDosing("1"));

        List<Dosing> dosings = new ArrayList<>();
        dosings.add(new Dosing("1", firstPlan));
        dosings.add(new Dosing("2", secondPlan));
        dosings.add(new Dosing("3", thirdPlan));

        Set<String> uniqueDosingId = dosings.stream()
                .map(Dosing::getId)
                .collect(Collectors.toSet());
        assertEquals(3, dosings.size());

        Map<String,List<Dosing>> result = main.groupDosingsByPlanDosingId(dosings);

        assertNotNull(result);
        assertEquals(4, result.size());

        assertTrue(result.containsKey("1"));
        assertTrue(result.containsKey("2"));
        assertTrue(result.containsKey("3"));
        assertTrue(result.containsKey("4"));

        assertEquals(2, result.get("1").size());
        assertEquals(2, result.get("2").size());
        assertEquals(3, result.get("3").size());
        assertEquals(2, result.get("4").size());
    }
}
