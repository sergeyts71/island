package entity;

import java.util.HashMap;
import java.util.Random;

public class IslandMap {
    HashMap<String, Integer> cell0 = new HashMap<>();
    HashMap<String, Integer> HungryPredator = new HashMap<>();

    public IslandMap() {
        cell0.put("Волк", 5);
        cell0.put("Заяц", 10);

        HungryPredator.put("Волк", 5);

    }

    public HashMap getCell() {
        return cell0;
    }

    public void deathAnimal(String key) {cell0.put(key, cell0.get(key) - 1);}

    public boolean probabilityOfBeingEaten(Integer randomEat) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100);
        if (rand_int1 <= randomEat) {
            return true;
        } else return false;
    }

    public Integer getCountLiveAnimal(String key) {
        Integer value = cell0.get(key);
        return value;
    }

    public Integer getCountHungryPredator(String key) {
        Integer value = HungryPredator.get(key);
        return value;
    }

    public void setCountHungryPredatorMinus1(String key) {
        HungryPredator.replace(key, (getCountHungryPredator(key) - 1));
    }

    public void eat(String predatorName, String herbivoreName) {
        while (getCountHungryPredator(predatorName) > 0) {
//            System.out.println("-----новый цикл-----");
            if (probabilityOfBeingEaten(60)) {
//                System.out.println("охота волка успешна");
                deathAnimal(herbivoreName);
//                System.out.println("удаляем травоядного из списка");
                setCountHungryPredatorMinus1(predatorName);
//                System.out.println("уменьшаем список голодных хищьников");
            }
            else{
                    deathAnimal(predatorName);
//                    System.out.println("если охота неуспешна хищьник умирает");
                    setCountHungryPredatorMinus1(predatorName);
//                    System.out.println("из-за смерти хищьника удаляем его из списка голодных хищьников");
                }
        }
    }

//    public void statistic(HashMap cell, String name){
//        if (getCountHungryPredator(name) == 0)
//        {System.out.println(" статистика после еды " + getCell(cell));}
//    }
}