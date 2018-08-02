package jvm;

public class B extends A {
    public static int Num = 1; //静态变量
    public static final int NUMBER = 1; //静态常量

    public B() {
        System.out.println("B类的初始化");
    }

    static {
        System.out.println("B的静态代码块");
    }
}
