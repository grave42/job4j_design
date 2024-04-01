package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    void testParkCar() {
        ParkingLot parkingLot = new ParkingLotImpl(10, 5);
        Car car = new CarImpl();
        parkingLot.parkCar(car);
        assertEquals(9, parkingLot.availableCarSpaces());
    }

    @Test
    void testParkTruck() {
        ParkingLot parkingLot = new ParkingLotImpl(10, 5);
        Truck truck = new TruckImpl(2);
        parkingLot.parkTruck(truck, 0);
        assertEquals(10, parkingLot.availableCarSpaces());
        assertEquals(3, parkingLot.availableTruckSpaces());
    }

    @Test
    void testParkTruckThenUseCarSpaces() {
        ParkingLot parkingLot = new ParkingLotImpl(5, 2);
        Truck truck = new TruckImpl(3);
        parkingLot.parkTruck(truck, 1);
        assertEquals(1, parkingLot.availableCarSpaces());
        assertEquals(2, parkingLot.availableTruckSpaces());
    }

    @Test
    void testRemoveCar() {
        ParkingLot parkingLot = new ParkingLotImpl(10, 5);
        Car car = new CarImpl();
        parkingLot.parkCar(car);
        parkingLot.removeCar(car);
        assertEquals(10, parkingLot.availableCarSpaces());
    }

    @Test
    void testRemoveTruck() {
        ParkingLot parkingLot = new ParkingLotImpl(10, 5);
        Truck truck = new TruckImpl(2);
        parkingLot.parkTruck(truck, 1);
        parkingLot.removeTruck(truck, 1);
        assertEquals(10, parkingLot.availableCarSpaces());
        assertEquals(5, parkingLot.availableTruckSpaces());
    }

    @Test
    void testParkCarWhenNoSpace() {
        ParkingLot parkingLot = new ParkingLotImpl(0, 5);
        Car car = new CarImpl();
        parkingLot.parkCar(car);
        assertEquals(0, parkingLot.availableCarSpaces());
    }

    @Test
    void testParkTruckWhenNoSpace() {
        ParkingLot parkingLot = new ParkingLotImpl(0, 0);
        Truck truck = new TruckImpl(2);
        parkingLot.parkTruck(truck, 1);
        assertEquals(0, parkingLot.availableTruckSpaces());
    }

}