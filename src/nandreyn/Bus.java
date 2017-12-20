package nandreyn;

/**
 * Created by andre on 03.12.2017.
 */
public class Bus extends AbstractCar {
    private int doorsCount, seatsCount;

    public Bus(String name, String color, Fuel fuel, int doorsCount, int seatsCount) {
        super(name, color, fuel);
        this.seatsCount = seatsCount;
        this.doorsCount = doorsCount;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Seats: " + getSeatsCount() + ", Doors: " + getDoorsCount();
    }

    @Override
    public boolean equals(Object o) {
        boolean preResult = super.equals(o);
        if (!preResult)
            return false;

        if (!(o instanceof Bus)) return false;
        Bus b = (Bus) o;
        return (getDoorsCount() == b.getDoorsCount() && getSeatsCount() == b.getSeatsCount());
    }
}
