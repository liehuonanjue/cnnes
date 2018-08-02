package inner;

public class TestFather {


    public static void main(String[] args) {
        //创建外部类
        Father father=new Father();
        //通过外部类创建内部类
        Father.Son son=father.new Son();
        //调用子类属性或者方法
        System.out.println(son.name);
        son.sayHello();
        //调用局部内部类的属性
        father.testSon();
        //直接调用公有静态内部类
        Father.StaticSon2 son2= new Father.StaticSon2();
        System.out.println("=========================================");
        //创建匿名内部类
        Animal panda=new Animal() {
            @Override
            public void eat() {
                System.out.println("熊猫吃竹子.....");
            }
            @Override
            public void sleep() {
                System.out.println("熊猫在睡觉.....");
            }
        };
        panda.eat();

    }
}
