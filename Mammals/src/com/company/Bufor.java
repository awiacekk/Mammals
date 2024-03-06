package com.company;

import java.util.List;

public class Bufor {
    private double weight;
    private boolean isReady = false;

    public synchronized void put(double weight) {
        while (this.isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.weight=weight;
        this.isReady = true;
        notify();
    }

    public synchronized double get(){
        while (!this.isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isReady = false;
        notify();
        return this.weight;
    }

}
