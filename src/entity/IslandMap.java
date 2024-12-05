package entity;
import java.util.HashMap;
public class IslandMap {
    HashMap<String, Integer> cell0 = new HashMap<>();
    public IslandMap() {
        cell0.put("Волк", 10);
        cell0.put("Заяц", 100);
   }
        public HashMap<String, Integer> getCell0 () {
        return cell0;
            }
        public void  replaseValue (String key) {
            cell0.put(key, cell0.get(key) -1);
        }

        public void eat(String name){
            replaseValue(name);
        }
    }