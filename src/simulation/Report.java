package simulation;

import entity.*;
import java.util.HashMap;

public class Report implements Runnable {
    public void run() {
        IslandMap islandMap = new IslandMap();
        System.out.println(" статистика после еды " + islandMap.getCell());
    }

}
