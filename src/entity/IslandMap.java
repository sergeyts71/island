package entity;

import java.util.HashMap;
import java.util.Random;

public class IslandMap {
    HashMap<String, Integer> cell0 = new HashMap<>();
    public IslandMap() {
        cell0.put("Волк", 2);
        cell0.put("Заяц", 10);
   }
        public HashMap<String, Integer> getCell0 () {
        return cell0;
            }

        public void  replaseValue (String key) {
            cell0.put(key, cell0.get(key) -1);
        }

        public boolean probabilityOfBeingEaten (Integer randomEat){
            Random rand = new Random();
            int rand_int1 = rand.nextInt(100);
            if (rand_int1 <= randomEat) {
                return true;
            }
            else return false;
    }

        public Integer getCountLiveAnimal (String key) {
            Integer value = cell0.get(key);
            return value;
    }

        public void eat(String name){
            replaseValue(name);
        }
    }