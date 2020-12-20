package level3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cbStart;
    private CountDownLatch cdlStart;
    private CountDownLatch cdlFinish;
    private ArrayBlockingQueue<Integer> abqWin;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cbStart, CountDownLatch cdlStart, CountDownLatch cdlFinish, ArrayBlockingQueue<Integer> abqWin) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cbStart = cbStart;
        this.cdlStart = cdlStart;
        this.cdlFinish = cdlFinish;
        this.abqWin = abqWin;

    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlStart.countDown();
            cbStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (abqWin.poll()!=null) {
            System.out.println(this.name+" - WIN");
        }
//        if (cdlFinish.getCount()==CARS_COUNT-1) {
//            System.out.println(this.name+" - WIN");
//        }
        cdlFinish.countDown();
    }
}
