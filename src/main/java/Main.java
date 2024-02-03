import java.util.List;


/*
есть список дозировок внутри которых два списка планов.
Нужно разделить этот список по уникальным id из списка планов.
На выходе Map<id, List<Dosing>> result
Будет 4 копии дозинг.
В первой копии будет 1 дозинг -> потому что 1 и 2 есть и там и там
Во второй копии будет 2 дозинг -> потому что 2 и 3 есть и там и там
 */


class Dosing{
    String name;
    List<PlanDosing> planDosingFirst; // 1,2,3
    List<PlanDosing> planDosingSecond; //2,3,4
    String id; // лежит в дозинге. == PlanDosing.id
}

class PlanDosing{
    String id;
}

public class Main {
    public static void main(String[] args) {

    }
}
