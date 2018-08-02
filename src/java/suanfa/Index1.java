package suanfa;

import sun.java2d.pipe.SpanIterator;

public class Index1 {
    public static void main(String[] args) {
     /*   jian();
        System.out.println("====================================");
        suns();
        System.out.println("====================================");*/
        yidao();
/*        System.out.println("====================================");
        strint();
        System.out.println("====================================");
        function1(50);
        System.out.println("====================================");
        System.out.println(ten(55));
        System.out.println("====================================");
        System.out.println(two(0010010));*/
    }

    private static void strint() {
        String ss = "1234";
        int result = 0;
        for (int i = 0; i < ss.length(); i++) {
            result = result * 10 + ss.charAt(i) - '0';
        }
        System.out.println(result);

        String num = "200110102"; // 3进制的数字转换成5进制的
        int resul = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            resul = resul * 3 + (c - '0');
        }
        System.out.println(resul);  //十进制  13457
        String str = "";
        while (true) {
            if (result == 0) break;
            str += result % 5;
            result = result / 5;
        }
        System.out.println(str);
    }


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


    //二转十的一个方法
    public static int two(int bi) {
        //     自己算 二转十
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


    private static void yidao() {

//        1：一刀切上式（事先补齐）
        String a = "ab bc,cd,ef gh";
        String result = ""; //保存结果
        a += ","; //事先补齐  ab bc,cd,ef gh,
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i); //获取每一个字符
            if (' ' == c || ',' == c) {
                System.out.print(result + " ");
                result = "";
            } else {
                result += c;
            }
        }
        System.out.println();
//        1：一刀切下式（事后修正）
        String b = "abcdefg"; //结果a,b,c,d,e,f,g
        String re = "";
        for (int i = 0; i < b.length(); i++) {
            re += "," + b.charAt(i);//获取每一个字符
        }
        re = re.substring(1);
        System.out.println(re);

//        2. 字符串的常用API  （假设修正法）
        boolean flag = false; // 假设不重复
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);//获取每一个字符
            if (b.lastIndexOf(c) != i) {
                flag = true; //重复
                break;
            }
        }

//        3. 字符串的常用API  （正则表达式）split
/**
 *  + :代表 一到N次 ｛1，｝
 ？：代表 0到1次 ｛0，1｝
 *：代表 0到N次 ｛0，｝
 */
        String c = "a b  c   d e f  g";
        String[] str = c.split(" +"); //a.split(" {1,}");
        for (String s : str) {
            System.out.print(s);
        }

        System.out.println();
//        4. 字符串的常用API  （正则表达式）replaceAll()
//        在小括号里面的内容我们称之为子组，用$获取子组内容
        String dat = "asasasa 2018-07-16 sasa sasas sasa";
//实现的效果是asasasa 07/16/2018年 sasa sasas sasa
        dat = dat.replaceAll("([0-9]{4})-([0-9]{2})-([0-9]{2})", "$2/$3/$1 年");
        System.out.print(dat);

/*        5. 正则表达式常用的两个类
                Pattern
        01：代表正则表达式本身
        02：对我们书写的正则表达式进行预处理
        03:提高我们代码的运行效率
                Matcher
        01:代表正则表达式的计算结果
        02：实现了对正则复杂的操作

        6. 判断某个字符串是否满足我们定义的正则表达式*/
        String zz = "ABC01234";
        zz.matches("[A-Z]{1,3}[0-9]{3,5}"); //返回boolean
        System.out.println();
    }

    private static void jian() {
        String a = "ab bc,cd,ef gh";
        for (int i = 0; i < a.length(); i += 3) {
            System.out.print(a.substring(i, i + 2) + " ");
        }


        System.out.println();

        String b = "abcdefg";
        char[] ss = b.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (i == ss.length - 1)
                System.out.print(ss[i]);
            else
                System.out.print(ss[i] + ",");

        }
        System.out.println();


        String c = "a b c d   e f    g";
        char[] cc = c.replace(" ", "").toCharArray();
        for (int i = 0; i < cc.length; i++) {
            if (i == cc.length - 1)
                System.out.print(cc[i]);
            else
                System.out.print(cc[i] + ",");
        }
        System.out.println();


    }

    private static void suns() {
        int HEAD = 50;//定义头的数量
        int FOOT = 120;//定义头的数量
        for (int i = 0; i <= HEAD; i++) { //假设鸡 最少0 最多50
            int y = 50 - i;  //得到兔子的数量
            if (i * 2 + y * 4 == FOOT) {
                System.out.println("鸡的数量：" + i);
                System.out.println("兔子的数量：" + y);
            }
        }
        System.out.println();
        for (int i = 1000; i <= 1500; i++) {
            if (i % 3 == 2 && i % 5 == 4 && i % 7 == 6) {
                System.out.println("现在剩下的兵力是：" + i);
            }
        }

        int MONEY = 80; //统一单位  80角
        for (int a = 0; a <= 80 / 50; a++) {//5元出现的次数
            for (int c = 0; c <= 80 / 10; c++) {//1元出现的次数
                if ((80 - (a * 50 + c * 10)) < 0) break;   //剪枝操作  减少计算机的计算次数
                int d = (80 - (a * 50 + c * 10)) / 5;//5角出现的次数
                if (a * 50 + c * 10 + d * 5 == 80) {
                    System.out.println("5元数量：" + a + "===>" + "1元数量：" + c + "5角数量：" + d);
                }
            }
        }
        for (int i = 0; i <= 100000; i++) {
            //得到i的平方
            int n = i * i;
            //之后发现规律  数字于10取余之后的结果是  0 1 5 6 才需要计算
            int m = i % 10;
            if (m != 0 && m != 1 && m != 5 && m != 6) continue;   //剪枝
            if (n % 10 == i || n % 100 == i || n % 1000 == i || n % 10000 == i || n % 100000 == i) {
                System.out.println("数字本身是：" + i + "平方之后的数字是：" + n);
            }
        }
    }

}

