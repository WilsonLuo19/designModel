package org.designModel.ProxyModel.Myinterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MymethodInterceptor implements MethodInterceptor {


    private String InterceptorCrib = null; // 描述拦截器的字段
    private Object target; // 代理目标，真实目标


    /**
     * @param target 将目标绑定在代理中
     * @param interceptorCrib 描述拦截器的字段初始化
     */
    public MymethodInterceptor(Object target,String interceptorCrib){
        this.target = target;
        this.InterceptorCrib = interceptorCrib;
    }



    public Object getProxy(){
        Enhancer en  = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(this.InterceptorCrib == null) return method.invoke(target,objects);
        Object result = null;
        Interceptor intercep = (Interceptor) Class.forName(this.InterceptorCrib).newInstance();
        if(intercep.before(o,target,methodProxy,objects)){
            result = method.invoke(target,objects);
        }else{
            intercep.replace(o,target,methodProxy,objects);
        }

        intercep.after(o,target,methodProxy,objects);
        return result;
    }

    public static void main(String[] args) {
        helloWorld imp = new helloWorld();
        MymethodInterceptor inter = new MymethodInterceptor(imp,InterceptorImpl.class.getName());
        helloWorld i = (helloWorld) inter.getProxy();
        i.SayHelloWorld();

    }
}
