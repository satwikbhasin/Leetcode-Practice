import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> elementIndexMap;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        this.elementIndexMap = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (elementIndexMap.containsKey(val)) {
            return false;
        } else {
            elementIndexMap.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (elementIndexMap.containsKey(val)) {
            int temp = list.get(list.size() - 1);
            
            list.set(elementIndexMap.get(val), temp);
            elementIndexMap.put(temp, elementIndexMap.get(val));

            list.remove(list.size() - 1);
            elementIndexMap.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
