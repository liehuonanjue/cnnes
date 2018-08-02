package io;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class IoFile {
    public static void main(String[] args) {

//        jie();
        fu();
    }

    //字节流(不能有汉字否则乱码)
    public static void jie() {
//        创建输入和输出对象
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("d:/linkList - 副本.txt");
//           true代表文件中的拼接，不删除之前的内容
            outputStream = new FileOutputStream("d:/linkList - 副本.txt");
//         向文件写入内容
            outputStream.write("qqq".getBytes());   //outputStream.flush();自己没有实现
//            read方法返回0-255之间的数字，如果流读到最后将放回-1
            int num = 0;
            while ((num = inputStream.read()) != -1) {
                System.out.println((char) num);  //将ascii码变为缩写/字符
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字符流
    public static void fu() {
        //创建输入和输出流
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader("d:/linkList - 副本.txt");
            writer = new FileWriter("d:/linkList - 副本.txt", true);
            writer.write("字符流缓冲前");
            writer.flush();  // 清空缓冲区
            writer.write("字符流缓冲后\n");
            writer.close();
            //读取
            // 创建一次性读取多少个字符
            char[] data = new char[1024];
            int num = 0;
            StringBuffer sb = new StringBuffer();
            while ((num = reader.read(data)) != -1) {
                sb.append(data);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
