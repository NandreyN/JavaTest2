package nandreyn;

import java.util.*;

class AbstractCarComparator implements Comparator<AbstractCar> {

    @Override
    public int compare(AbstractCar o1, AbstractCar o2) {
        int p1 = o1.getName().compareTo(o2.getName());
        if (p1 != 0) return p1;

        return -o1.getFuel().compareTo(o2.getFuel());
    }
}

public class Container<T extends AbstractCar> extends ArrayList<T>{
    public Container() {
        super();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T car : this) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }

    public int getMatchCount(T t) {
        return Collections.frequency(this, t);
    }

    public T getMax() {
        return Collections.max(this, new AbstractCarComparator());
    }

    public T binSearch(T toSearch) {
        List<T> copy = new ArrayList<>(this);
        copy.sort(new AbstractCarComparator());

        int idx = Collections.binarySearch(copy, toSearch, new AbstractCarComparator());
        if (idx < 0) return null;
        return copy.get(idx);
    }
}