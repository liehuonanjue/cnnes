package weiyun;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;

public class Wei {

    //系统的函数 自动把十进制变为 2 8 16
    public static void function1(int n) {
        System.out.println("十转2 8 16");
        //  java进制转换
//        java中进行二进制，八进制，十六进制，十进制间进行相互转换
//        十进制转成十六进制：
        System.out.println(Integer.toHexString(n));
//        十进制转成八进制
        System.out.println(Integer.toOctalString(n));
//        十进制转成二进制
        System.out.println(Integer.toBinaryString(n));
    }

    //十进制变二进制
    public static StringBuffer ten(int n) {
//        自己算 十转二
        StringBuffer sb = new StringBuffer();
        int res = 0;
        while (n > 0) {
            res = n % 2; //除2 取余数作为二进制数
            sb.append(res);
            n = n / 2;
        }
        return sb;
    }

/*
    public static Integer two(int bi) {
        String binStr = bi + "";
        Integer sum = 0;
        int len = binStr.length();
        for (int i = 1; i <= len; i++) {
            int dt = Integer.parseInt(binStr.substring(i - 1, i));
            sum += (int) Math.pow(2, len - i) * dt;
        }
        return sum;
    }
*/

    //二转十的一个方法
    public static int two(int bi) {
        //        自己算 二转十
        StringBuffer sb = new StringBuffer().append(bi).reverse();
        int sum = 0;
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            //第i位 的数字为：  从左往右开始计算
            int dt = Integer.parseInt(sb.charAt(i) + "");
            sum += Math.pow(2, i) * dt;
        }
        return sum;
    }

    //   Math.pow(x,y)
// 参数	描述
//x	必需。底数。必须是数字。
//y	必需。幂数。必须是数字。
    //数据匹配
    public static void stringList() {
        Set set = new HashSet();
        set.add("abc");
        set.add(new String("abc"));
        set.add(new String("abc"));
        System.out.println(set.size());


        String a = "abc";
        String b = "a";
        String c = "bc";

        System.out.println(a == (b + c));
        b += c;
        final String d = b;
        System.out.println(a == d);
    }


    public static void bitOperation() {

        System.out.println((2 >> 1) + "2 >> 1算术右移"); //算术右移
        /*
         *   0000 0010  2
         *    0000 0010   2
         * _________________________
         *   0000 0001    1
         * */
        System.out.println((2 << 1) + "2 << 1算术左移");//算术左移
        /*
         *   0000 0010  2
         *  0000 0010   2
         * _________________________
         *   0000 0100    4
         * */
        System.out.println((2 >>> 1) + "2 >>> 1逻辑右移");//逻辑右移
        /*
         *   0000 0010  2
         *    0000 0010   2
         * _________________________
         *   0000 0001    1
         * */
        System.out.println((2 | 1) + "2 | 1或 两位有一个为1，结果为1"); //或 两位有一个为1，结果为1
        /*
         *   0000 0010  2
         *   0000 0001  1
         * _________________________
         *   0000 0011  3
         * */
        System.out.println((2 & 1) + "2 & 1且 两位都为1，结果为1");//或 两位都为1，结果为1
        /*
         *   0000 0010  2
         *   0000 0001  1
         * _________________________
         *   0000 0000 0
         * */
        System.out.println((~2) + "~2或高位反 然后补码");   //或 两位都为1，结果为1
        /*
         *   0000 0010  2  源码
         *   1000 0010  2  负数
         *   1111 1101  3  反码
         * */
        System.out.println(2 - 1);
        /*
         *   1000 0001   -1 源码
         *   1111 1110   -1 反码
         *   1111 1111   -1 补码
         *
         *   0000 0010   2 源码
         * + 1111 1111  -1 补码
         *  ------------------------
         *   0000 0001  1的源码
         * */
        System.out.println(1 - 2);
        /*
         *   1 0 0 0 0 0 1 0    -2的源码
         *   1 1 1 1 1 1 0 1    -2的反码
         *   1 1 1 1 1 1 1 0    -2的补码
         *   0 0 0 0 0 0 0 1     1的补码
         * + 1 1 1 1 1 1 1 0
         *  ----------------------
         *   1 1 1 1 1 1 1 1    -1结果的补码
         *   1 1 1 1 1 1 1 0    -1结果的反码
         *   1 0 0 0 0 0 0 1    -1结果的原码   -
         * */
    }

    public static void main(String[] args) {
        function1(15);
        System.out.println("__________________________");
        System.out.println("手工去二进制" + ten(15).toString());
        System.out.println("__________________________");
        System.out.println("手工取十进制" + two(1111));
        System.out.println("__________________________");
        bitOperation();
        System.out.println("__________________________");
        stringList();


    }
}
