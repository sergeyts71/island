package entity;

public class Command implements Runnable{
    String taskName;
    public Command(String taskName)
    {
        this.taskName = taskName;
    }
    public void run()
    {
        System.out.println(taskName + ", ");
        IslandMap islandMap = new IslandMap();
        while (islandMap.getCountLiveAnimal("Заяц")>0) {
            System.out.println(" статистика до еды    " + islandMap.getCell0());
//          while (islandMap.getCountLiveAnimal("Заяц")>0)
            if (islandMap.probabilityOfBeingEaten(60)) {
                islandMap.eat("Заяц");
                System.out.println(" статистика после еды " + islandMap.getCell0());
            }
            else {
                System.out.println(" статистика после еды " + islandMap.getCell0());
                continue;
            }
            }
        }
    }
//}
