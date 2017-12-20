package nandreyn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

public class Reader {
    private String passengerCarInput, busInput;
    private List<PassengerCar> pass;
    private List<Bus> bus;

    public Reader(String inp1, String inp2) {
        this.passengerCarInput = inp1;
        this.busInput = inp2;
        pass = new ArrayList<>();
        bus = new ArrayList<>();
    }

    public List<PassengerCar> getPassengerCarsList() throws FileNotFoundException, InvalidFileFormatException {

        File file = new File(passengerCarInput);
        if (!file.exists())
            throw new FileNotFoundException("File not found : " + passengerCarInput);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] splited = s.split("\\s+");
            // name color fuel seats
            if (splited.length != 4)
                throw new InvalidFileFormatException("name color fuel seats_material(spaces as separartors)");
            try {
                PassengerCar car = new PassengerCar(splited[0].toLowerCase(),
                        splited[1].toLowerCase(), (splited[2].toLowerCase().equals("petrol")) ? AbstractCar.Fuel.PETROL : AbstractCar.Fuel.DIESEL,
                        splited[3].toLowerCase().equals("leather") ? PassengerCar.SeatsMaterial.LEATHER : PassengerCar.SeatsMaterial.FABRIC);
                pass.add(car);
            } catch (IllegalArgumentException e) {
                throw new InvalidFileFormatException("name color fuel seats_material(spaces as separartors)");
            }
        }
        return pass;
    }

    public List<Bus> getBusList() throws FileNotFoundException, InvalidFileFormatException {
        File file = new File(busInput);
        if (!file.exists())
            throw new FileNotFoundException("File not found : " + busInput);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] splited = s.split("\\s+");
            // name color fuel seats
            if (splited.length != 5)
                throw new InvalidFileFormatException("name color fuel seats_count doors_cont(spaces as separrators)");
            try {
                bus.add(new Bus(splited[0].toLowerCase(),
                        splited[1].toLowerCase(), (splited[2].toLowerCase().equals("petrol")) ? AbstractCar.Fuel.PETROL : AbstractCar.Fuel.DIESEL,
                        Integer.parseInt(splited[3]), Integer.parseInt(splited[4])));
            } catch (IllegalArgumentException e) {
                throw new InvalidFileFormatException("name color fuel seats_count doors_cont(spaces as separrators)");
            }
        }

        return bus;
    }
}
