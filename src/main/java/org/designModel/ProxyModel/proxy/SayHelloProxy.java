package org.designModel.ProxyModel.proxy;

public class SayHelloProxy implements ISayHello {
    private ISayHello obj;

    public SayHelloProxy(ISayHello ifSayHello){
        this.obj = ifSayHello;
    }

    @Override
    public void SayHello() {
        System.out.println("代理对象预处理 hello");
        obj.SayHello();
    }


    public static void main(String[] args) {
        SayHello a = new SayHello();
        SayHelloProxy b = new SayHelloProxy(a);
        b.SayHello();
    }
}
