package cn.news.String;

import java.lang.reflect.Type;

public class Stringg {
    public static void main(String[] args) {
        String str = "服微端云入加迎欢|welcome join us !";
        //1

        /*
        StringBuffer reStr = new StringBuffer(str).reverse();//将String类型转化为StringBuffer类型
        reStr.append(str.substring(9));
        System.out.println("倒置后字符串为：" + reStr.toString().substring(18));
        */
        int gen = str.indexOf("|");
        String sub = str.substring(0, gen);
        StringBuffer reStr = new StringBuffer(sub).reverse();
        reStr.append(str.substring(gen));
        System.out.println(reStr.toString());
        //   2
        /*
        int num = 0;
        for (int i = 0; i <= str.trim().length(); i++) {
            char c = str.charAt(i);
            if ((byte) c > 65 && (byte) c < 122) {
                num++;
            }
        }
        System.out.println(num);
        */
        System.out.println((char)65535);
        int count = 0;
        char chs[] = str.toCharArray();
        for (char ch = 'A'; ch < 'z'; ch++) {
            count = 0;
            for (int i = 0; i < chs.length; i++) {
                if (ch == chs[i])
                    count++;
            }
            if (count != 0)
                System.out.println("字符中" + ch + "有" + count + "个");

        }
    }
}
