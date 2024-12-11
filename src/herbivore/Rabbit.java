package herbivore;
import entity.Herbivore;
import config.Settings;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super.setWeight(Settings.weightRabbit);
        super.setMaxSpeed(Settings.maxSpeedRabbit);
        super.setMaxSatiety(Settings.maxSatietyRabbit);
        super.setActualSatiety(Settings.actualSatietyRabbit);
        super.setCountOnOneCell(Settings.countRabbitOnOneCell);
    }
//    private int index = 1;
//    private final String image = "\uD83D\uDC07"; // изображение животного
//    private final double weight = 2; //вес
//    private final int maxItemsPerCell = 150; // Максимальное количество животных этого вида на одной клетке
//    private final int cellMovesPerCycle = 2; // Скорость перемещения, не более чем, клеток за ход
//    private final double saturationAmount = 0.45; // Сколько килограммов пищи нужно животному для полного насыщения
//    private final int numberOfCubs = 5; // количество рождённого потомства за одит раз
//
//    @Override
//    public  int getIndex() {
//        return index;
//    }
//
//    @Override
//    public String getImage() {
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
//    public int getReproduction(){
//            return numberOfCubs;
//        }
//
}
