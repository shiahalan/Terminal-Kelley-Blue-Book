package model;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Iterator;

public class LHMAuto<T extends Automobile> {
    private LinkedHashMap<String, T> LHM;
    
    public LHMAuto() {
        this.LHM = new LinkedHashMap<String, T>();
    }

    public synchronized void addAuto(String key, T car) { // sync
        this.LHM.put(key, car);
    }

    public synchronized void removeAuto(String key) {  // sync
        this.LHM.remove(key);
    }

    public T findAuto(String key) {
        return this.LHM.get(key);
    }

    public String iterateFromInt(int x) {
        Collection collect = this.LHM.keySet();
        Object[] keys = collect.toArray();
        String modelName = keys[x].toString();
        return modelName;
    }

    public String iterate() {
        Collection collect = this.LHM.keySet();
        Iterator itr = collect.iterator();

        String cars = "";

        int count = 0;
        while (itr.hasNext()) {
            count += 1;
            cars += Integer.toString(count) + ") " + itr.next() + " \n";
        }

        return cars;
    }

    

}
