package org.designModel.ObserverModel.jdk;
import java.util.Observable;


public class object extends Observable {

    private String date;
    private int tem;

    public object(String date,int tem){
        this.date = date;
        this.tem = tem;
    }

    public void setDate(String date,int tem){
        this.tem = tem;
        this.date = date;
        dataChanged();
    }

    public void dataChanged(){
        this.setChanged();
        this.notifyObservers();
    }

    public String getDate() {
        return date;
    }

    public int getTem() {
        return tem;
    }


    public static void main(String[] args) {
        object o = new object("2020-1-4",5);
        observers o1 = new observers(o);
        observers o2 = new observers(o);
        o1.display();
        o2.display();

        o.setDate("2020-1-5",10);

    }
}
