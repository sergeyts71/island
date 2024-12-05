package entity;

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

//    public int getId(){
//        return id;
//    }
//
//    public int[] getCell(){
//        return cell;
//    }
//
//    public String getGender(){
//        return gender;
//    }


    public void eat(){

    }

    public void move(){

    }
}
