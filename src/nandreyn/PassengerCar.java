package nandreyn;

public class PassengerCar extends AbstractCar {

    private SeatsMaterial seatsMaterial;

    public enum SeatsMaterial {
        LEATHER, FABRIC;
    }

    public PassengerCar(String name, String color, Fuel fuel, SeatsMaterial material) {
        super(name, color, fuel);
        seatsMaterial = material;
    }

    public String getSeatsMaterial() {
        return seatsMaterial.toString();
    }

    public String toString() {
        return super.toString() + ", Material: " + getSeatsMaterial();
    }

    @Override
    public boolean equals(Object o) {
        boolean preResult = super.equals(o);
        if (!preResult)
            return false;

        if (!(o instanceof PassengerCar)) return false;
        PassengerCar b = (PassengerCar) o;
        return (getSeatsMaterial().equals(((PassengerCar) o).getSeatsMaterial()));
    }
}
