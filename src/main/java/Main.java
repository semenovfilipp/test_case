import java.util.*;


/*
Описание:
Есть список дозировок Dosing внутри которых списки планов List<PlanDosing>.
Dosing содержит StringId и List<PlanDosing>
PlanDosing содержит StringId

Задача:
1. Нужно разделить Dosing список по уникальным id из списка PlanDosing.
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


class Dosing {
    String id;
    List<PlanDosing> planDosingList = new ArrayList<>();


    public Dosing(String id, List<PlanDosing> planDosingList) {
        this.id = id;
        this.planDosingList = planDosingList;
    }

    public Dosing() {
    }

    @Override
    public String toString() {
        return "Dosing{" +
                "id='" + id + '\'' +
                ", planDosingList=" + planDosingList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PlanDosing> getPlanDosingList() {
        return planDosingList;
    }

    public void addPlanDosing(PlanDosing planDosing) {
        this.planDosingList.add(planDosing);
    }

    public void setPlanDosingList(List<PlanDosing> planDosingList) {
        this.planDosingList = planDosingList;
    }
}

class PlanDosing {
    String id;

    public PlanDosing(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlanDosing{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        // Планы дозировок
        PlanDosing one = new PlanDosing("1");
        PlanDosing two = new PlanDosing("2");
        PlanDosing three = new PlanDosing("3");
        PlanDosing four = new PlanDosing("4");

        // Списки планов
        List<PlanDosing> firstPlan = Arrays.asList(one, two, three); // 1,2,3
        List<PlanDosing> secondPlan = Arrays.asList(two, three, four); // 2,3,4
        List<PlanDosing> thirdPlan = Arrays.asList(three, four, one); // 3,4,1


//        // dosing1 содержит firstPlan(1,2,3) и thirdPlan(3,4,1)
//        // тк 1 есть в firstPlan и thirdPlan
//        Dosing dosing1 = new Dosing();
//        dosing1.setId("1");
//        firstPlan.forEach(dosing1::addPlanDosing);
//        thirdPlan.forEach(dosing1::addPlanDosing);
//
//
//        // dosing2 содержит firstPlan(1,2,3) и secondPlan(2,3,4)
//        // тк 2 есть в firstPlan и secondPlan
//        Dosing dosing2 = new Dosing();
//        dosing2.setId("2");
//        firstPlan.forEach(dosing2::addPlanDosing);
//        secondPlan.forEach(dosing2::addPlanDosing);
//
//
//        // dosing3 содержит firstPlan(1,2,3) secondPlan(2,3,4) и thirdPlan(3,4,1)
//        // тк 3 есть в firstPlan, secondPlan и thirdPlan
//        Dosing dosing3 = new Dosing();
//        dosing3.setId("3");
//        firstPlan.forEach(dosing3::addPlanDosing);
//        secondPlan.forEach(dosing3::addPlanDosing);
//        thirdPlan.forEach(dosing3::addPlanDosing);

        Map<String, Dosing> result = new HashMap<>();
        result.put("1", createDosing("1", firstPlan, thirdPlan));
        result.put("2", createDosing("2", firstPlan, secondPlan));
        result.put("3", createDosing("3", firstPlan, secondPlan, thirdPlan));


        result.forEach((id, dosing) ->
                System.out.println(dosing));

    }

    public static Dosing createDosing(String id, List<PlanDosing>... planLists) {
        Dosing dosing = new Dosing();
        dosing.setId(id);
        Arrays.stream(planLists)
                .flatMap(Collection::stream)
                .forEach(dosing::addPlanDosing);
        return dosing;
    }
}
