package org.designModel.ObserverModel.Self;

public class testPanel implements panel,Observer {

    private String data;
    private int tem;
    private Object object;


    public testPanel(Object o){
        this.object = o;
        o.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("data: "+data);
        System.out.println("tem: "+tem);
    }

    @Override
    public void update(String data,int tem) {
        this.data = data;
        this.tem =tem;
        display();
    }
}
