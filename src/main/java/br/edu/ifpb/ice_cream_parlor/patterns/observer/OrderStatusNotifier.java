package br.edu.ifpb.ice_cream_parlor.patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class OrderStatusNotifier implements Subject {
//
//    private final List<Observer> observers = new ArrayList<>();
//
//    @Override
//    public void addObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    @Override
//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(String orderId, String status) {
//        for (Observer observer : observers) {
//            observer.update(orderId, status);
//        }
//    }
//}
public class OrderStatusNotifier {
    private final Map<String, List<Observer>> observers = new HashMap<>();

    public void addObserver(String orderId, Observer observer) {
        observers.computeIfAbsent(orderId, k -> new ArrayList<>()).add(observer);
    }

    public void notifyObservers(String orderId, String status) {
        List<Observer> orderObservers = observers.get(orderId);
        if (orderObservers != null) {
            for (Observer observer : orderObservers) {
                observer.update(orderId, status);
            }
        }
    }

    public void removeObservers(String orderId) {
        observers.remove(orderId);
    }
}
