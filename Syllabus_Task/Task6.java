import java.util.Scanner;

abstract class Vehicle {
    private String type;
    private double ratePerKm;

    public Vehicle(String type, double ratePerKm) {
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    public String getType() {
        return type;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Bike extends Vehicle {
    public Bike() {
        super("Bike", 5.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto() {
        super("Auto", 12.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Cab extends Vehicle {
    public Cab() {
        super("Cab", 12.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rider {
    private String name;

    public Rider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) throws InvalidBookingException {
        if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        } else if (type.equalsIgnoreCase("Auto")) {
            return new Auto();
        } else if (type.equalsIgnoreCase("Cab")) {
            return new Cab();
        } else {
            throw new InvalidBookingException("Invalid ride type: " + type);
        }
    }
}

class Trip {
    private Driver driver;
    private Rider rider;
    private Vehicle vehicle;
    private double distance;

    public Trip(Driver driver, Rider rider, Vehicle vehicle, double distance) throws InvalidBookingException {
        if (distance <= 0) {
            throw new InvalidBookingException("Distance must be greater than zero.");
        }
        this.driver = driver;
        this.rider = rider;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    public double calculateTotalFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Driver dummyDriver = new Driver("Default Driver");
        Rider dummyRider = new Rider("Default Rider");

        for (int i = 0; i < n; i++) {
            String rideType = scanner.next();
            double distance = scanner.nextDouble();

            try {
                Vehicle vehicle = VehicleFactory.createVehicle(rideType);
                Trip trip = new Trip(dummyDriver, dummyRider, vehicle, distance);
                System.out.println((long) trip.calculateTotalFare());
            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}