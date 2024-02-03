import java.util.*;
import java.util.stream.Collectors;


/*
Описание:
Есть список дозировок List<Dosing> внутри которых списки планов List<PlanDosing>.
PlanDosing содержит StringId
Dosing содержит StringId и List<PlanDosing>

Задача:
0. Создать список List<Dosing> и на полнить его
1. Нужно разделить Dosing список по уникальным id  PlanDosing.
2. На выходе Map<id, List<Dosing>> result

Пример:
 List<PlanDosing> firstPlan = new ArrayList<>(); // 1,2,3
 List<PlanDosing> secondPlan = new ArrayList<>(); // 2,3,4
 List<PlanDosing> thirdPlan = new ArrayList<>(); // 3,4,1
 -------
 Будет:
 Map <1, List<Dosing>> -> List<Dosing> будет содержать внутри PlanDosing
 -> fistPlan/thirdPlan, тк id 1 есть в  fistPlan и thirdPlan
 ///
 Map <2, List<Dosing>> -> List<Dosing> будет содержать внутри PlanDosing
 ->  firstPlan/secondPlan, тк id 2 есть в  firstPlan и secondPlan
 ///
 Map <3, List<Dosing>> -> List<Dosing> будет содержать внутри PlanDosing
 -> firstPlan/secondPlan/thirdPlan, тк id 3 есть в  firstPlan и secondPlan и thirdPlan
 ---------
 */


class PlanDosing {
    private String id;

    public PlanDosing(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlanDosing{" +
                "Id=" + id +
                '}';
    }
}

class Dosing {
    private String id;
    private List<PlanDosing> planDosingList;

    public Dosing(String id, List<PlanDosing> planDosingList) {
        this.id = id;
        this.planDosingList = planDosingList;
    }

    public String getId() {
        return id;
    }

    public List<PlanDosing> getPlanDosingList() {
        return planDosingList;
    }

    @Override
    public String toString() {
        return
                "planDosingList=" + planDosingList +
                        '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Dosing> dosings = new ArrayList<>();
        List<PlanDosing> firstPlan = Arrays.asList(new PlanDosing("1"), new PlanDosing("2"), new PlanDosing("3"));
        List<PlanDosing> secondPlan = Arrays.asList(new PlanDosing("2"), new PlanDosing("3"), new PlanDosing("4"));
        List<PlanDosing> thirdPlan = Arrays.asList(new PlanDosing("3"), new PlanDosing("4"), new PlanDosing("1"));
        dosings.add(new Dosing("1", firstPlan));
        dosings.add(new Dosing("2", secondPlan));
        dosings.add(new Dosing("3", thirdPlan));

        Map<String, List<Dosing>> resultMap = dosings.stream()
                .flatMap(dosing -> dosing.getPlanDosingList().stream()
                        .map(planDosing -> new AbstractMap.SimpleEntry<>(planDosing.getId(), dosing)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        resultMap.forEach((id, dosingList) ->
                System.out.println("Map <" + id + ", List<Dosing>> -> " + dosingList));
    }
}

