package designMode.SingleCase;

public class Strdent {
    //创建本类的静态变量
    private static Strdent strdent;

    //私有构造函数
    private Strdent() {
    }


    //饿汉模式创建本类的静态变量
    /*    private static Strdent strdent= new Strdent();*/

/*
    //饿汉模式
    public static synchronized Strdent getStrdent() {

        return strdent;
    }
*/


/*
    //懒汉模式
    public static synchronized Strdent getStrdent() {
        if (strdent == null) {
            strdent = new Strdent();
        }
        return strdent;
    }
*/

    //提供对外访问接口
    public static synchronized Strdent getStrdent() {
        if (strdent == null) {
            synchronized (Strdent.class) {
                if (strdent == null) {
                    strdent = new Strdent();
                }
            }
        }
        return strdent;
    }
}
