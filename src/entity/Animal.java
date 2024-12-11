package entity;


import  java.util.stream.Collectors;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import entity.*;
import factory.*;
import config.Settings;

public abstract class Animal extends Entity {
    private int index;
    private String image; // изображение животного
    private double weight; // вес
    private int maxItemsPerCell; // Максимальное количество животных этого вида на одной клетке
    private int cellMovesPerCycle; // Скорость перемещения, не более чем, клеток за ход
    private double saturationAmount; //Сколько килограммов пищи нужно животному для полного насыщения
    private int numberOfCubs; // количество рождённого потомства за одит раз
//    private int id; // уникальный номер животного
//    private int cell [] ; // ячейка в которой находится животное
//    private String gender; // пол животного

    public int maxSpeed;
    public double maxSatiety;
    public double actualSatiety;
    public int countOnOneCell;
    public Map<String, Integer> probabilityEaten;

    public  int getIndex() {
        return index;
    }

    public String getImage() {
        return image;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxItemsPerCell() {
        return maxItemsPerCell;
    }


     public int getCellMovesPerCycle() {
        return cellMovesPerCycle;
    }

    public double getSaturationAmount() {
        return saturationAmount;
    }

    public int getReproduction(){
       return numberOfCubs;
    }

    public int getnumberOfCubs() {
        return numberOfCubs;
    }

    Lock lock = new ReentrantLock();

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setProbabilityEaten(Map<String, Integer> probabilityEaten) {
        this.probabilityEaten = probabilityEaten;
    }

    public void setCountOnOneCell(int countOnOneCell) {
        this.countOnOneCell = countOnOneCell;
    }

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void worker() {
        lock.lock();
        this.actualSatiety = this.actualSatiety - (this.maxSatiety * Settings.workerPercent) - 0.1;
        lock.unlock();
    }

    public boolean eat(Cell cell) {
        return true;
    }

    public void move(Island island) {
        lock.lock();
        try {
            Cell[][] islandArrays = island.islandArrays;
            for (int i = 0; i < islandArrays.length; i++) {
                for (int j = 0; j < islandArrays.length; j++) {
                    if (islandArrays[i][j].listAnimal.contains(this)) {
                        int randomStep = ThreadLocalRandom.current().nextInt(0, this.maxSpeed + 1);
                        int randomDirection = ThreadLocalRandom.current().nextInt(1, 9);
                        int newI = i;
                        int newJ = j;
                        switch (randomDirection) {
                            case 1 :
                                newI -= randomStep; // Вверх
                                break;
                            case 2 : {
                                newI -= randomStep;
                                newJ += randomStep;
                            } // Вверх вправо
                            break;
                            case 3 : newJ += randomStep; // Вправо
                                break;
                            case 4 : {
                                newI += randomStep;
                                newJ += randomStep;
                            } // Вниз вправо
                            break;
                            case 5 : newI += randomStep; // Вниз
                                break;
                            case 6 : {
                                newI += randomStep;
                                newJ -= randomStep;
                            } // Вниз влево
                            break;
                            case 7 : newJ -= randomStep; // Влево
                                break;
                            case 8 : {
                                newI -= randomStep;
                                newJ -= randomStep;
                            } // Вверх влево
                            break;
                        }
                        newI = (newI + islandArrays.length) % islandArrays.length;
                        newJ = (newJ + islandArrays[i].length) % islandArrays[i].length;
                        int sizeAnimal = islandArrays[newI][newJ].listAnimal.stream().filter(animal -> this.getClass()
                                .equals(animal.getClass())).collect(Collectors.toList()).size();
                        if (sizeAnimal >= this.countOnOneCell) {
                            return;
                        }
                        islandArrays[newI][newJ].listAnimal.add(this);
                        islandArrays[i][j].listAnimal.remove(this);
                        return;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        } finally {
            lock.unlock();
        }
    }

    public void reproduce(Cell cell) {
        lock.lock();
        try {
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (randomNum >= Settings.randomMating) {
                int sizeIndividual = listAnimal.stream().filter(count -> this.getClass()
                        .equals(count.getClass())).collect(Collectors.toList()).size();
                if (sizeIndividual < 2) {
                    return;
                }
                if (sizeIndividual >= countOnOneCell) {
                    return;
                }
                String simpleName = this.getClass().getSimpleName();
                listAnimal.add(AnimalFactory.giveBirthAnimal(simpleName));
            }
        } finally {
            lock.unlock();
        }
    }

    public void dei(Cell cell) {
        lock.lock();
        try {
            if (actualSatiety <= 0) {
                cell.listAnimal.remove(this);
            }
        } finally {
            lock.unlock();
        }
    }


}
