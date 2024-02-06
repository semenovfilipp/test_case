**Тестовое задание: Разделение списка дозировок**

**Описание:**
У нас есть список дозировок `List<Dosing>`, в котором каждая дозировка содержит идентификатор типа `StringId` и список планов `List<PlanDosing>`. Каждый элемент `PlanDosing` также содержит идентификатор `StringId`.

**Задача:**
1. Создать и заполнить список `List<Dosing>`.
2. Разделить список `Dosing` на подсписки по уникальным идентификаторам из `PlanDosing`.
3. Получить результат в виде `Map<id, List<Dosing>>`, где `id` - уникальный идентификатор из `PlanDosing`.

**Пример:**
```
List<PlanDosing> firstPlan = new ArrayList<>(); // 1,2,3
List<PlanDosing> secondPlan = new ArrayList<>(); // 2,3,4
List<PlanDosing> thirdPlan = new ArrayList<>(); // 3,4,1
```

**Ожидаемый результат:**
```
Map <1, List<Dosing>> -> Список, содержащий дозировки с планами, где присутствует PlanDosing с id=1
Map <2, List<Dosing>> -> Список, содержащий дозировки с планами, где присутствует PlanDosing с id=2
Map <3, List<Dosing>> -> Список, содержащий дозировки с планами, где присутствует PlanDosing с id=3
Map <4, List<Dosing>> -> Список, содержащий дозировки с планами, где присутствует PlanDosing с id=4
```