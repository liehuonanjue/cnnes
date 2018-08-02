package knowledge.contend1;


import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class IndexNum1 {


    static Scanner intput = new Scanner(System.in);

    public static void main(String[] args) {

        String next = intput.next();
        int num = intput.nextInt();
        System.out.println(split(next, num));
    }

    public static String split(String str, Integer len) {
        try {
            if (len > str.getBytes("gbk").length) {
                return str;
            }
            if (len < 0) {
                return "";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        char[] arr = str.toCharArray();
        String s = "";
        int l = 0;
        for (char a : arr) {
            try {
                l = l + (a + "").getBytes("gbk").length;
                if (l == len) {
                    s += a;
                    return s;
                }
                if (l > len) {
                    return s;
                }
                s += a;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
