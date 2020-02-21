package org.designModel.ProxyModel.Myinterceptor;

import net.sf.cglib.proxy.MethodProxy;


public class InterceptorImpl implements Interceptor {
    @Override
    public boolean before(Object Proxy, Object target, MethodProxy method, Object[] args) {
        System.out.println("执行前操作");
        return true;
    }

    @Override
    public Object replace(Object Proxy, Object target, MethodProxy method, Object[] args) {
        System.out.println("替代执行操作");
        return null;
    }

    @Override
    public Object after(Object Proxy, Object target, MethodProxy method,Object[] args) {
        System.out.println("执行后操作");
        return null;
    }
}
