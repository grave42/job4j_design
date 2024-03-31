package ru.job4j.ood.lsp.parking;

public interface ParkingLot {
    void parkCar(Car car);
    void parkTruck(Truck truck, int adjacentCarSpaces);
    void removeCar(Car car);
    void removeTruck(Truck truck, int adjacentCarSpaces);
    int availableCarSpaces();
    int availableTruckSpaces();
}
