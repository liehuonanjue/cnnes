package Reflect;

import com.sun.org.apache.xml.internal.security.Init;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class IndexNum1 {

    @Test
    public void text01() {
        try {
//            全类名 又叫 完整限定名
            System.out.println("类的完整限定名来加载类" + Class.forName("Reflect.Student"));
            System.out.println("任何类名。class获取类" + Student.class.getName());
            System.out.println("任何对象。getclass（）获取了class类" + new String().getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void text02() {
        try {
            Class c = Class.forName("Reflect.Student");
            System.out.println("Student类所在包" + c.getPackage().getName());
            System.out.println("Student全类名" + c.getName());
            System.out.println("Student简写类名" + c.getSimpleName());
//            获取类的访问修饰符
            int num = c.getModifiers();
            System.out.println("public访问修饰符对应数字" + num);
            System.out.println(Modifier.toString(num));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void text03() {
        try {
            Class c = Class.forName("Reflect.Student");
//            Field[] fields =c.getFields() public修饰字段
//            获取所有的字段
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i]);
                //            获取所有字段的访问修饰符
                System.out.println(Modifier.toString(fields[i].getModifiers()));
                System.out.println(fields[i].getModifiers());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类中所有的方法相关信息 不包含构造方法
     * 1.c.genNethod（方法名称，参数类型） 只能是public修饰的
     * 2. c.getMethods（） 只能说public修饰的
     * 3.c.getDeclareMethods（）所有
     */
    @Test
    public void text04() {
        try {
            Class c = Class.forName("Reflect.Student");  //加载
            Method[] methods = c.getDeclaredMethods(); //获取所有 包含private
            for (int i = 0; i < methods.length; i++) {
                System.out.println("方法的名字" + methods[i].getName());
                System.out.println("方法的修饰符值是" + methods[i].getModifiers());
                System.out.println("方法的修饰是" + Modifier.toString(methods[i].getModifiers()));
                System.out.println("方法的返回值类型是" + methods[i].getReturnType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void text05() {
        try {
            Class c = Class.forName("Reflect.Student");  //加载
            Constructor[] constructors = c.getDeclaredConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println("方法的名字" + constructors[i].getName());
                System.out.println("方法的名字" + constructors[i].getModifiers());
                System.out.println("方法的名字" + Modifier.toString(constructors[i].getModifiers()));
                System.out.println("方法的名字" + constructors[i].getParameterCount());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问类中私有的属性和方法并且让他执行
     */
    @Test
    public void text06() {
        try {
            Class c = Class.forName("Reflect.Student");// 加载
            Student student = (Student) c.newInstance(); //实例化
            Field field = c.getDeclaredField("userName"); //获取私有的字段
            String name = field.getName();
            System.out.println("字段名" + name);
            //打开字段开关
            field.setAccessible(true);
            System.out.println("字段的值是" + field.get(student));
//            获取私有的方法
            Method method = c.getDeclaredMethod("getSum", double.class);
            method.setAccessible(true);
            double result = (Double) method.invoke(student, 50.5);
            System.out.println(result);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
