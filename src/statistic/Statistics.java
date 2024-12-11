package statistic;
import entity.*;
import predator.*;
import herbivore.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Statistics {

    public static void collectingStatistics(Island island) {

//        int sizePlant = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).mapToInt(cell -> cell.listPlant.size()).sum();
        int sizeWolf = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Wolf).map(c -> (Wolf) c).collect(Collectors.toList()).size();
//        int sizeBear = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Bear).map(c -> (Bear) c).toList().size();
//        int sizeBoa = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Boa).map(c -> (Boa) c).toList().size();
//        int sizeFox = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Fox).map(c -> (Fox) c).toList().size();
//        int sizeEagle = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Eagle).map(c -> (Eagle) c).toList().size();
//        int sizeSheep = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Sheep).map(c -> (Sheep) c).toList().size();
//        int sizeDeer = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Deer).map(c -> (Deer) c).toList().size();
//        int sizeBuf = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Buffalo).map(c -> (Buffalo) c).toList().size();
        int sizeRabbit = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream()).
                filter(c -> c instanceof Rabbit).map(c -> (Rabbit) c).collect(Collectors.toList()).size();
//        int sizeGoat = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Goat).map(c -> (Goat) c).toList().size();
//        int sizeMouse = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Mouse).map(c -> (Mouse) c).toList().size();
//        int sizeDuck = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Duck).map(c -> (Duck) c).toList().size();
//        int sizeHorse = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Horse).map(c -> (Horse) c).toList().size();
//        int sizeBoar = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Boar).map(c -> (Boar) c).toList().size();
//        int sizeCaterpillar = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
//                .filter(c -> c instanceof Caterpillar).map(c -> (Caterpillar) c).toList().size();
        int sizePredator = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Predator).map(c -> (Predator) c).collect(Collectors.toList()).size();
        int sizeHerbivore = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Herbivore).map(c -> (Herbivore) c).collect(Collectors.toList()).size();
        System.out.print("Wolf: " + sizeWolf +  "  Rabbit: " + sizeRabbit + "\n");
//        System.out.print( "Plant: " + sizePlant + "||" + "Herbivore: " + sizeHerbivore + "||" + "Predator: " + sizePredator + "\n");

    }

    public static int countNumberAnimal(Island island) {
        int sizePredator = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Predator).map(c -> (Predator) c).collect(Collectors.toList()).size();
        int sizeHerbivore = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Herbivore).map(c -> (Herbivore) c).collect(Collectors.toList()).size();
        return sizeHerbivore + sizePredator;
    }
}