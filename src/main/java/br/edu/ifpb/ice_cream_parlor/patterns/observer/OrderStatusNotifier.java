package br.edu.ifpb.ice_cream_parlor.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusNotifier implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId, String status) {
        for (Observer observer : observers) {
            observer.update(orderId, status);
        }
    }
}
