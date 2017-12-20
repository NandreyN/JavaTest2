package nandreyn;

public abstract class AbstractCar {
    private String name ;
    private String color;
    private Fuel fuel;

    public enum Fuel {
        PETROL, DIESEL;
    };

    public AbstractCar(String name, String color, Fuel fuel)
    {
        this.name = name.toLowerCase();
        this.color = color.toLowerCase();
        this.fuel = fuel;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }


    public String getFuel()
    {
        return fuel.toString();
    }

    @Override
    public String  toString()
    {
        return "Name: " + getName() + ", Color: " + getColor() + ", Fuel: " + getFuel();
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null) return false;
        if (other == this) return false;
        if (!(other instanceof AbstractCar)) return false;
        AbstractCar c = (AbstractCar)other;
        return getColor().equals(c.getColor()) && getFuel().equals(c.getFuel()) && getName().equals(c.getName());
    }
}
