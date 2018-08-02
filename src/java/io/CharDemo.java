package io;

import java.io.*;

/**
 * 字符流
 * Reader            Writer
 * FileReader       FileWriter
 */
public class CharDemo {


    public static void main(String[] args) {
        //创建输入和输出流
        Reader reader=null;
        Writer writer=null;
        try {
            reader=new FileReader("e:/a.txt");
            writer=new FileWriter("e:/a.txt",true);
            writer.write("大家辛苦了1111！");
            writer.write("大家辛苦了2222！");
            writer.write("大家辛苦了3333！");
            writer.flush();  // 清空缓冲区
            writer.write("大家辛苦了4444！");
            writer.write("大家辛苦了5555！");
            writer.write("大家辛苦了6666！");
            writer.close();
             //读取
            // 创建一次性读取多少个字符
            char [] data=new char[1024];
             int num=0;
             StringBuffer sb=new StringBuffer();
           while((num=reader.read(data))!=-1)  {
               sb.append(data);
           }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
               // writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
