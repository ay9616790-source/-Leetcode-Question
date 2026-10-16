
import java.util.*;

class LRUCache {

    int capacity;
    HashMap<Integer, Integer> map;
    LinkedList<Integer> q;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        q = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // Key ko queue se hatao
        q.remove(Integer.valueOf(key));

        // Recently used hai, isliye end mein add karo
        q.addLast(key);

        return map.get(key);
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            q.remove(Integer.valueOf(key));
        } 
        else if (map.size() == capacity) {
            int lru = q.removeFirst();
            map.remove(lru);
        }

        map.put(key, value);
        q.addLast(key);
    }
}
