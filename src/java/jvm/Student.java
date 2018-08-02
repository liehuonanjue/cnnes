package jvm;

public class Student {
    public static void main(String[] args) throws ClassNotFoundException {
//      new B();   //实例化B类的对象
//        System.out.println(B.Num);  //类名.静态变量
//        Class.forName("jvm.B");  //通过反射加载B类
//        System.out.println(B.NUMBER);  //类名。静态常量 常量在编译期间就被放进常量池中
//        B[] bs = new B[2];  //数组 不会有任何输出因为没有初始化
        System.out.println(C.NUMBER); // 子调度父
    }
}
