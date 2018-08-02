package io;

import java.io.*;

/**
 * 缓冲流
 * BufferReader       BufferWriter  不单独使用
 * 一般和Reader  Writer 联用
 *
 */
public class BufferDemo {


    public static void main(String[] args) {
        //创建输入和输出流
        Reader reader=null;
        Writer writer=null;
        BufferedReader  br=null;
        BufferedWriter bw=null;
        try {
            writer=new FileWriter("e:/a.txt",true);
            bw=new BufferedWriter(writer); //封装
            bw.write("大家辛苦了！");
            bw.newLine();  //换行
            bw.write("大家别眨眼！");
            bw.flush();
            bw.write("大家别眨眼22！");
            bw.write("大家别眨眼33！");
            bw.close();
            writer.close();  //如果不关闭  后续两句话没法获取
            //读取
            reader=new FileReader("e:/a.txt");
            br=new BufferedReader(reader);//封装
            String line=null;
            StringBuffer sb=new StringBuffer();
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
