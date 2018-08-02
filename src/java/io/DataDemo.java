package io;

import java.io.*;

/**
 * 二进制流
 * DataInputStream    DataOutputStream
 * 不单独使用  一般需要与 InputStream   OutputStream 联用
 */
public class DataDemo {

    public static void main(String[] args) {
        //创建输入流和输出流对象
        InputStream inputStream=null;
        OutputStream outputStream=null;
        DataInputStream  dis=null;
        DataOutputStream dos=null;
        try {
            //获取了输入流   猫咪进内存了
            inputStream=new FileInputStream("e:/小猫咪.jpg");
            dis=new DataInputStream(inputStream);
            //获取输出流
            outputStream=new FileOutputStream("e:/u1/cat.jpg");
            dos=new DataOutputStream(outputStream);
            //先读取
            int num=0;
             while ((num=dis.read())!=-1){
                 dos.write(num);  //复制
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {  //释放资源
            try {
                dos.close();
                dis.close();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
