package knowledge.contend1;

import java.io.*;

public class IndexNum4 {
    public static void main(String[] args) {

        //创建输入和输出流
        Writer writer = null;
        try {
            writer = new FileWriter("d:/c.txt", true);
            writer.write(se("d:/a.txt") + "\n" + se("d:/b.txt"));
            writer.close();
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static String se(String string) {
        String in = null;
        //创建输入和输出流
        Reader reader = null;
        BufferedReader br = null;
        try {
            //读取
            reader = new FileReader(string);
            br = new BufferedReader(reader);//封装
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            in = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return in;
    }


}
