package model;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Iterator;

public class LHMAuto<T extends Automobile> {
    private LinkedHashMap<String, T> LHM;
    
    public LHMAuto() {
        this.LHM = new LinkedHashMap<String, T>();
    }

    public void addAuto(String key, T car) {
        this.LHM.put(key, car);
    }

    public void removeAuto(String key) {
        this.LHM.remove(key);
    }

    public T findAuto(String key) {
        return this.LHM.get(key);
    }

    public void iterate() {
        Collection collect = this.LHM.values();
        Iterator itr = collect.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    

}
