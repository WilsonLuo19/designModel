package org.designModel.ProxyModel.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cgProxy implements MethodInterceptor {



    public void SayHello(){
        System.out.println("hello");
    }


    Object getProxy(){
        Enhancer en = new Enhancer();
        en.setSuperclass(cgProxy.class);
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        cgProxy a = new cgProxy();
        cgProxy b = (cgProxy) a.getProxy();
        b.SayHello();
    }
}
