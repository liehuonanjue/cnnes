package io;

import java.io.*;

/**
 * 字节流
 * InputStream        OutputStream  基类
 * 都不能实例化
 */
public class ByteDemo {

    public static void main(String[] args) {
        //创建输入流和输出流对象
        InputStream   inputStream=null;
        OutputStream   outputStream=null;
        try {
            inputStream=new FileInputStream("e:/a.txt");
            // true 代表是否向文件中拼接，不删除之前的内容
            outputStream=new FileOutputStream("e:/a.txt",true);
            //先向文件写入内容
            outputStream.write("54321".getBytes()); //outputStream.flush();  自己没有实现
            // read 方法将返回0-255之间的数字 如果流读到了最后，将返回-1
             int num=0;
           while ((num=inputStream.read())!=-1){
               System.out.println((char)num);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
