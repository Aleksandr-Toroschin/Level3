package level3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJUnit {
    public static void start(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        Method before = null;
        Method after = null;
        List<Method> testMethods = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (before == null) {
                    before = m;
                } else {
                    throw new RuntimeException("Недопустимое количество аннотаций BeforeSuite");
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (after == null) {
                    after = m;
                } else {
                    throw new RuntimeException("Недопустимое количество аннотаций AfterSuite");
                }
            }
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            }
        }
        testMethods.sort((o1, o2) -> ((Integer) o1.getAnnotation(Test.class).priority()).compareTo(o2.getAnnotation(Test.class).priority()));

        try {
            if (before != null) {
                before.invoke(null);
            }
            for (Method m : testMethods) {
//                System.out.println("выполняем метод " + m.getName() + " priority= " + m.getAnnotation(Test.class).priority());
                m.invoke(null);
            }
            if (after != null) {
                after.invoke(null);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
