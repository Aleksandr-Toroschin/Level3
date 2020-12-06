package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson1 {
    public static void main(String[] args) {
        // 1 задание
        String[] arr = {"one","two","three","four","five"};
        changePlace(arr, 3,1);
        System.out.println("Задание 1, массив 1. " + Arrays.toString(arr));

        Cat[] cats = {new Cat("Борис"), new Cat("Тимофей"), new Cat("Васька")};
        changePlace(cats, 0, 2);
        System.out.println("Задание 1, массив 2. " + Arrays.toString(cats));

        // 2 задание
        System.out.println("Задание 2, массив 1. " + convert(arr));
        System.out.println("Задание 2, массив 2. " + convert(cats));

        // 3 задание
        System.out.println("Задание 3.");
        Box<Apple> appleBox = new Box<Apple>(new Apple(), 11);
        Box<Orange> orangeBox = new Box<Orange>(new Orange(), 8);

        System.out.println(appleBox.toString());
        System.out.println(orangeBox.toString());
        // Сравнение коробок
        System.out.printf("Сравнение коробок по весу дает %b", appleBox.compare(orangeBox));
        System.out.println();

        Box<Apple> appleBox2 = new Box<Apple>(new Apple(), 3);
        appleBox.pour(appleBox2); // пересыпать все из appleBox в appleBox2

        System.out.println(appleBox.toString());
        System.out.println(appleBox2.toString());

    }

    public static <T> void changePlace(T[] arr, int ind1, int ind2) {
        // задание 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        T el1 = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = el1;
    }

    public static <T> ArrayList<T> convert(T[] arr) {
        // задание 2. Написать метод, который преобразует массив в ArrayList
        return new ArrayList<>(Arrays.asList(arr));
    }


}
