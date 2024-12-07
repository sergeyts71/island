import entity.*;
import herbivore.*;
import plant.*;
import predator.*;
import simulation.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        {

            // Creating a ScheduledThreadPoolExecutor object
            ScheduledThreadPoolExecutor threadPool
                    = new ScheduledThreadPoolExecutor(2);

            // Creating two Runnable objects
            Runnable task1 = new Command("task1");
            Runnable task2 = new Command("task2");
            threadPool.schedule(task1, 1, TimeUnit.SECONDS);
            threadPool.schedule(task2, 1, TimeUnit.SECONDS);
            threadPool.shutdown();
        }
    }
}