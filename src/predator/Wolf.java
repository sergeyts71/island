package predator;

import entity.Predator;
import config.Settings;
public class Wolf extends Predator {
    public Wolf() {
        super.setWeight(Settings.weightWolf);
        super.setMaxSpeed(Settings.maxSpeedWolf);
        super.setMaxSatiety(Settings.maxSatietyWolf);
        super.setActualSatiety(Settings.actualSatietyWolf);
        super.setCountOnOneCell(Settings.countWolfOnOneCell);
        super.setProbabilityEaten(Settings.ProbabilityBeingEatenWolf);
    }
//    private int index = 0;
//    private String image = "\uD83D\uDC3A";
//    private double weight = 50;
//    private final int maxItemsPerCell = 30;
//    private final int cellMovesPerCycle = 3;
//    private final double saturationAmount = 8;
//    private final int numberOfCubs = 7;
//
////    public Wolf(String image, double weight) {
////        this.image = image;
////        this.weight = weight;
////    }
//
//    @Override
//    public  int getIndex() {
//        return index;
//    }
//
//    @Override
//    public  String getImage() {
//        return image;
//    }
//
//    @Override
//    public double getWeight() {
//        return weight;
//    }
//
//    @Override
//    public int getMaxItemsPerCell() {
//        return maxItemsPerCell;
//    }
//
//
//    @Override
//    public int getCellMovesPerCycle() {
//        return cellMovesPerCycle;
//    }
//
//    @Override
//    public double getSaturationAmount() {
//        return saturationAmount;
//    }
//
//    @Override
//    public int getnumberOfCubs() {
//        return numberOfCubs;
//    }

}
