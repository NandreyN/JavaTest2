package nandreyn;

import java.io.FileNotFoundException;
import java.util.*;

// Passenger car input - input1.txt
// BUs input - input2.txt
// Object to search is assigned in code directly

public class Main {

    public static void main(String[] args) {
        // pass as parameters
        // args[0] = input1.txt
        // args[1] = input2.txt
        if (args.length != 2)
            throw new IllegalArgumentException("Illegal count of file paths");
        Reader reader = new Reader(args[0], args[1]);
        try {
            List<PassengerCar> cars = reader.getPassengerCarsList();
            List<Bus> buses = reader.getBusList();

            Container<PassengerCar> passengerContainer = new Container<>();
            for(PassengerCar car : cars)
                passengerContainer.add(car);

            Container<Bus> busContainer = new Container<>();
            for (Bus bus : buses)
                busContainer.add(bus);

            System.out.println("Containers content: ");
            System.out.println("Cars :\n" + passengerContainer.toString());
            System.out.println("Buses :\n" + busContainer.toString());

            Bus busToSearch = new Bus("Maz",  "white",  AbstractCar.Fuel.PETROL, 3,50);
            PassengerCar passengerCarToSearch = new PassengerCar("Opel", "yellow", AbstractCar.Fuel.DIESEL, PassengerCar.SeatsMaterial.FABRIC);

            System.out.println("Passenger car :  "+ passengerCarToSearch.toString() + " , " + passengerContainer.getMatchCount(passengerCarToSearch) + " hits");
            System.out.println("Bus :  " + busToSearch.toString() + " , " + busContainer.getMatchCount(busToSearch) + " hits");

            System.out.println("\nMax in Passenger : " + passengerContainer.getMax().toString());
            System.out.println("Max in Bus : " + busContainer.getMax().toString());

            System.out.println("\nBin search of " + busToSearch.toString() + " is : " + busContainer.binSearch(busToSearch));
            System.out.println("Bin search of " + passengerCarToSearch.toString() + " is : " + passengerContainer.binSearch(passengerCarToSearch));

        } catch (FileNotFoundException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

    }
}
