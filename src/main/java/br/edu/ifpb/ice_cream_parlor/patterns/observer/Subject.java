package br.edu.ifpb.ice_cream_parlor.patterns.observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String orderId, String status);
}
