package ru.job4j.ood.lsp.parking;

public class ParkingLotImpl implements ParkingLot {
    private int carSpaces;
    private int truckSpaces;

    public ParkingLotImpl(int carSpaces, int truckSpaces) {
        this.carSpaces = carSpaces;
        this.truckSpaces = truckSpaces;
    }

    @Override
    public void parkCar(Car car) {
        if (carSpaces >= car.getSize()) {
            carSpaces -= car.getSize();
            System.out.println("Car parked. Available car spaces: " + carSpaces);
        } else {
            System.out.println("No available car spaces.");
        }
    }

    @Override
    public void parkTruck(Truck truck, int adjacentCarSpaces) {
        if (truck.getSize() <= 1) {
            parkCar(new CarImpl());
        } else if (truckSpaces >= truck.getSize() || carSpaces >= truck.getSize() + adjacentCarSpaces) {
            if (truckSpaces >= truck.getSize()) {
                truckSpaces -= truck.getSize();
            } else {
                carSpaces -= (truck.getSize() + adjacentCarSpaces);
            }
            System.out.println("Truck parked. Available truck spaces: " + truckSpaces);
        } else {
            System.out.println("No available truck spaces.");
        }
    }

    @Override
    public void removeCar(Car car) {
        carSpaces += car.getSize();
        System.out.println("Car removed. Available car spaces: " + carSpaces);
    }

    @Override
    public void removeTruck(Truck truck, int adjacentCarSpaces) {
        if (truck.getSize() <= 1) {
            removeCar(new CarImpl());
        } else if (truckSpaces < truck.getSize()) {
            carSpaces += (truck.getSize() + adjacentCarSpaces);
        } else {
            truckSpaces += truck.getSize();
        }
        System.out.println("Truck removed. Available truck spaces: " + truckSpaces);
    }

    @Override
    public int availableCarSpaces() {
        return carSpaces;
    }

    @Override
    public int availableTruckSpaces() {
        return truckSpaces;
    }



    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLotImpl(10, 5);

        Car car = new CarImpl();
        parkingLot.parkCar(car);

        Truck truck = new TruckImpl(2);
        parkingLot.parkTruck(truck, 1);
    }
}
