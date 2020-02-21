package org.designModel.ObserverModel.jdk;

import java.util.Observable;
import java.util.Observer;

public class observers implements Observer,panel {

    private String date;
    private int tem;
    private Observable observable;

    public observers(Observable o){
        o.addObserver(this);
        this.observable = o;
    }

    @Override
    public void update(Observable o, Object arg) {
        object obj = (object)o;
        this.date = obj.getDate();
        this.tem = obj.getTem();
        display();
    }

    @Override
    public void display() {
        System.out.println("date: "+this.date);
        System.out.println("tem: "+this.tem);
    }
}
