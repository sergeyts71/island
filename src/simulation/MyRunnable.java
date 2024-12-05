package simulation;

import entity.IslandMap;

public class MyRunnable implements Runnable {
    public void run() {
        while ( true ) {
            IslandMap islandMap = new IslandMap();
            Report report = new Report();

            System.out.println(islandMap.getCell0());
            islandMap.eat("Заяц");
            System.out.println(islandMap.getCell0());
        }
    }
}