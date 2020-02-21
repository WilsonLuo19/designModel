package org.designModel.ObserverModel.Self;

public interface Object {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();

}
