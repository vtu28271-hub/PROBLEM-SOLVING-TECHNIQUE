import java.util.*;

class Vehicle {
    String number;
    String type;

    Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }
}

class ParkingSpot {
    int spotNumber;
    boolean occupied;
    Vehicle vehicle;

    ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.occupied = false;
    }

    void park(Vehicle vehicle) {
        if (!occupied) {
            this.vehicle = vehicle;
            this.occupied = true;
            System.out.println("Vehicle parked at spot " + spotNumber);
        } else {
            System.out.println("Spot is already occupied.");
        }
    }

    void removeVehicle() {
        if (occupied) {
            System.out.println("Vehicle " + vehicle.number +
                               " removed from spot " + spotNumber);
            vehicle = null;
            occupied = false;
        } else {
            System.out.println("Spot is empty.");
        }
    }
}

class ParkingLot {
    List<ParkingSpot> spots;

    ParkingLot(int capacity) {
        spots = new ArrayList<>();

        for (int i = 1; i <= capacity; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    void parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.occupied) {
                spot.park(vehicle);
                return;
            }
        }

        System.out.println("Parking lot is full.");
    }

    void removeVehicle(int spotNumber) {
        if (spotNumber < 1 || spotNumber > spots.size()) {
            System.out.println("Invalid spot number.");
            return;
        }

        spots.get(spotNumber - 1).removeVehicle();
    }

    void displayAvailableSpots() {
        System.out.println("Available spots:");

        for (ParkingSpot spot : spots) {
            if (!spot.occupied) {
                System.out.print(spot.spotNumber + " ");
            }
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(5);

        Vehicle car1 = new Vehicle("TN01AB1234", "Car");
        Vehicle car2 = new Vehicle("TN02CD5678", "Car");
        Vehicle bike = new Vehicle("TN03EF9999", "Bike");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(bike);

        parkingLot.displayAvailableSpots();

        parkingLot.removeVehicle(2);

        parkingLot.displayAvailableSpots();
    }
}
