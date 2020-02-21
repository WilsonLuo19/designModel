package org.designModel.ProxyModel.proxy;

public class SayHello implements ISayHello {
    @Override
    public void SayHello() {
        System.out.println("原本对象方法 hello");
    }
}
