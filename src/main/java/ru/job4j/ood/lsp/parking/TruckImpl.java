package ru.job4j.ood.lsp.parking;

public class TruckImpl implements Truck {
    private int size;

    public TruckImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
