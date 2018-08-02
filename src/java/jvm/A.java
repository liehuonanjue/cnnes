package jvm;

public class A {
    public A() {
        System.out.println("A类的初始化");
    }

    static {
        System.out.println("A的静态代码块");
    }
}
