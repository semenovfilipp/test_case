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

        Map<String,List<Dosing>> result = main.groupDosingsByPlanDosingId(dosings);

        assertNotNull(result);
        assertEquals(4, result.size());

        for (Map.Entry<String, List<Dosing>> entry : result.entrySet()) {
            String id = entry.getKey();
            List<Dosing> dosingList = entry.getValue();

            for (Dosing dosing : dosingList) {
                assertTrue(dosing.getPlanDosingList().stream().anyMatch(planDosing -> planDosing.getId().equals(id)));
            }
        }


    }

}
