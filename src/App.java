import entity.IslandMap;
import simulation.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            service.submit(new Runnable() {

                               public void run() {
                                   IslandMap islandMap = new IslandMap();
                                   System.out.println(islandMap.getCell0());
                                   for (int j = 0; j < 10; j++) {
                                       islandMap.eat("Заяц");
                                   }
                                   System.out.println(islandMap.getCell0());
                               }
                           }
            );
//        MyRunnable myRunnable = new MyRunnable();
//        Thread myThread = new Thread(myRunnable);
//            myThread.start();
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//            myThread.stop();
        }
    }
}