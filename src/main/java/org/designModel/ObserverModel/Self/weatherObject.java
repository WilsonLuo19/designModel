package org.designModel.ObserverModel.Self;

import java.util.ArrayList;

public class weatherObject implements Object{


    private ArrayList<Observer> observerArrayList;
    private String data;
    private int tem;

    public weatherObject(){
        observerArrayList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerArrayList.add(observer);
        observer.update(this.data,this.tem);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerArrayList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o :
                observerArrayList) {
            o.update(this.data,this.tem);
        }
    }

    public void dataChanged(){
        notifyObserver();
    }

    public void setData(String data,int tem){
        this.data = data;
        this.tem = tem;
        dataChanged();
    }


    public String getData(){
        return this.data;
    }

    public int getTem(){
        return this.tem;
    }

    public static void main(String[] args) {
        weatherObject weatherObject = new weatherObject();
        weatherObject.data = "2020-1-5";
        weatherObject.tem = 5;
        testPanel t1 = new testPanel(weatherObject);
        testPanel t2 = new testPanel(weatherObject);
        weatherObject.setData("2020-1-4",10);
    }

}
