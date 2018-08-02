package knowledge.contend1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexNum2 {
    public static String[] strArr = null;

    public static void main(String[] args) {
        se();
        int count = 0;
        for (int i = 0; i < strArr.length; i++) {
            count = 0; //重新归零
            if (isChinese(strArr[i])) { //中文的进来
                for (int h = 0; h < strArr.length; h++) {
                    if (strArr[i].equals(strArr[h])) // 判断外圈的值和内圈的值是否一样
                        count++;
                }
                if (count != 0)
                    System.out.println("姓名中叫" + strArr[i] + "有" + count + "个");
            }
        }
    }

    //正则表达式判断是不是中文
    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find())
            flg = true;
        return flg;
    }

    private static void se() {
        //创建输入和输出流
        Reader reader = null;
        BufferedReader br = null;
        try {
            //读取
            reader = new FileReader("d:/a.txt");
            br = new BufferedReader(reader);//封装
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            strArr = sb.toString().split(",");
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
    }


}
