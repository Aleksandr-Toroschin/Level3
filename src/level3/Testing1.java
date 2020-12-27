package level3;

public class Testing1 {
    @Test(priority = 1)
    public static void testMethod1() {
        System.out.println("класс 1, метод 1");
    }

    @BeforeSuite
    public static void testMethodBegin() {
        System.out.println("класс 1, Before-метод");
    }

    @Test(priority = 9)
    public static void testMethod2() {
        System.out.println("класс 1, метод 2");
    }

    @AfterSuite
    public static void testMethodEnd() {
        System.out.println("класс 1, After-метод");
    }

    @Test(priority = 3)
    public static void testMethod3() {
        System.out.println("класс 1, метод 3");
    }

    @Test
    public static void testMethod4() {
        System.out.println("класс 1, метод 4");
    }

    @Test
    public static void testMethod5() {
        System.out.println("класс 1, метод 5");
    }

    @Test(priority = 7)
    public static void testMethod6() {
        System.out.println("класс 1, метод 6");
    }

    @Test(priority = 8)
    public static void testMethod7() {
        System.out.println("класс 1, метод 7");
    }
}
