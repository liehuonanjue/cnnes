package jvm;

public class C extends B {
    public static int Num = 1; //静态变量
    public static final int NUMBER = 2; //静态常量
    public C() {
        System.out.println("C类的初始化");
    }

    static {
        System.out.println("C的静态代码块");
    }
}
