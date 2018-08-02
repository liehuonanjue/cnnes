package io;

import java.io.*;
import java.util.Scanner;

/**
 * 序列化和反序列化
 * ObjectInputStream  ObjectOutputStream
 */
public class ObjectDemo {

    static Scanner  input=new Scanner(System.in);
    //创建需要的输入和输出流对象
    static   InputStream inputStream=null;
    static  OutputStream outputStream=null;
    static ObjectInputStream objectInputStream=null;
    static ObjectOutputStream  objectOutputStream=null;

    public static void main(String[] args) {
         //注册   序列化
        //register();
        //登录  反序列化
        login();
    }

    //注册
    private static void register()  {
        User user=new User();
        System.out.println("请输入您的用户名：");
        user.setUserName(input.next());
        System.out.println("请输入您的密码：");
        user.setPassword(input.next());

        try {
            outputStream=new FileOutputStream("e:/user.txt");
            objectOutputStream=new ObjectOutputStream(outputStream);
            //把对象输出到文件中
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //登录
    private static void login() {
        try {
            inputStream=new FileInputStream("e:/user.txt");
            objectInputStream=new ObjectInputStream(inputStream);
            //读取对象
            User user= (User) objectInputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
