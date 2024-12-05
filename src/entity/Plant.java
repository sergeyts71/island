package entity;

public abstract class Plant extends Entity {
    private String image;
    private double weight;
    private int maxItemsPerCell;

    public String getImage() {
        return image;
    }

    public double getWeight() {
        return weight;
    }

     public int getMaxItemsPerCell() {
        return maxItemsPerCell;
    }
}
