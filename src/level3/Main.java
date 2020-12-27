package level3;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Тестируем класс Testing1");
        MyJUnit.start(Testing1.class);
        System.out.println("--- Тестируем класс Testing2");
        MyJUnit.start(Testing2.class);
    }
}
