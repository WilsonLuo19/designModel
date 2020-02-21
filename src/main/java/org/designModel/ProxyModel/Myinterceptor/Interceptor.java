package org.designModel.ProxyModel.Myinterceptor;

import net.sf.cglib.proxy.MethodProxy;


public interface Interceptor {

    boolean before(Object Proxy, Object target, MethodProxy method, Object[] args);
    Object replace(Object Proxy, Object target, MethodProxy method,Object[] args);
    Object after(Object Proxy, Object target, MethodProxy method,Object[] args);

}
