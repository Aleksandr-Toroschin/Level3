package level3;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier cbStart = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cdlStart = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);
        ArrayBlockingQueue<Integer> abqWin = new ArrayBlockingQueue<>(1);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cbStart, cdlStart, cdlFinish, abqWin);
        }
        try {
            abqWin.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cdlStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            cdlFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
