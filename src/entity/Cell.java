package entity;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    public Lock lock = new ReentrantLock();
    public CopyOnWriteArrayList<Animal> listAnimal = new CopyOnWriteArrayList<>();
}
