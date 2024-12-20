package entity;

import entity.*;
import config.Settings;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {

    Lock lock = new ReentrantLock();

    @Override
    public boolean eat(Cell cell) {
        lock.lock();
        try {
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return true;
            }
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            if (listAnimal.isEmpty()) {
                return false;
            }
            List <Animal> listFilter = listAnimal.stream().filter(animal -> this.probabilityEaten.getOrDefault
                            (animal.getClass().getSimpleName(), 0) > 0).sorted((a1, a2) -> Integer.compare(
                            this.probabilityEaten.getOrDefault(a2.getClass().getSimpleName(), 0),
                            this.probabilityEaten.getOrDefault(a1.getClass().getSimpleName(), 0)
                    ))
                    .collect(Collectors.toList());
            if (listFilter.isEmpty()) {
                return false;
            }
            Animal first = listFilter.get(0);
            Integer probability = this.probabilityEaten.get(first.getClass().getSimpleName());
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (probability >= randomNum) {
                Double weightFood = Settings.weightOfAllEdibleAnimals.get(first.getClass().getSimpleName());
                if (weightFood > maxSatiety) {
                    actualSatiety = maxSatiety;
                } else {
                    actualSatiety += weightFood + (maxSatiety * Settings.onTopWeightAnimalAndPlant);
                }
                cell.listAnimal.remove(first);
            }
        } finally {
            lock.unlock();
        }
        return true;
    }
//    private final boolean eatRredatorHerbivores = true;
//    private final boolean eatHerbivoresPlants = false;
}
