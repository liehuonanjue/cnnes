package inner;

public class Father { //外部类


    static  String  userName="aaa";
      String  password="aaa";
    public  class  Son{ //成员内部类
        String name="内部类属性"; //内部类属性

        public  void  sayHello(){//内部类方法
            System.out.println("这是内部类方法");
        }
    }


    public  void  testSon(){ //father类的方法
         class Son2{  //局部内部类
             String name="局部内部类属性"; //局部内部类属性
         }
         Son2 son2=new Son2();
        System.out.println(son2.name);
    }


    private static  class StaticSon1{ //私有静态内部类
        public  void  sayHello1(){//内部类方法
            System.out.println("私有静态内部类");
        }
    }

    public static  class StaticSon2{ //公有静态内部类
        public  void  sayHello2(){//内部类方法
            System.out.println(userName); //可以访问外部类的静态属性和方法
            // System.out.println(password); 不可以访问外部类的非静态属性和方法
        }

    }








}
