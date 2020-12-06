package Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> boxList;

    public Box() {
        boxList = new ArrayList<>();
    }

    public Box(T fruit, int count) {
        //для упрощения тестов
        this();
        for (int i=0; i<count; i++) {
            boxList.add(fruit);
        }
    }

    public float getWeight() {
        // получение веса коробки
        if (boxList.isEmpty()) {
            return 0;
        } else {
            return boxList.size() * boxList.get(0).getWeight();
        }
    }

    public void addFruit(T fruit) {
        // добавление фрукта в коробку
        boxList.add(fruit);
    }

    public boolean compare(Box<? extends Fruit> box) {
        // метод сравнивает 2 коробки с фруктами по их весу
        return Math.abs(getWeight()-box.getWeight())<0.00001;
    }

    public void pour(Box<T> box) {
        // метод высыпает все фрукты из это коробки в ту, которую передали в параметре
        for (T t : boxList) {
            box.addFruit(t);
        }
        boxList.clear();
    }

    public String toString() {
        if (boxList.isEmpty()) {
            return "Коробка пустая";
        } else {
            return String.format("В коробке лежат %s, количество %d, вес коробки %.1f", boxList.get(0).getName(), boxList.size(), getWeight());
        }
    }
}
