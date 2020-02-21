package org.designModel.ProxyModel.JDKreflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHelloWorld implements InvocationHandler {

    private helloWorldImp target;

    ProxyHelloWorld(helloWorldImp target){
        this.target = target;
    }

    public Object getProxy(){
        return  Proxy.newProxyInstance (target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object o = method.invoke(target,args);
        System.out.println("after");
        return o;
    }


    public static void main(String[] args) {
        helloWorldImp a = new helloWorldImp();
        ProxyHelloWorld b = new ProxyHelloWorld(a);
        helloWorld c = (helloWorld) b.getProxy();
        c.printHelloWorld();
    }
}
