package cn.news.String;

public class Strsan {
    public static void main(String[] args) {
        String text = "";

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
            text = text + i;
        long endTime = System.currentTimeMillis();
        System.out.println("普通字符串直接相加的执行时间：" + (endTime - beginTime));

        StringBuffer sbf = new StringBuffer();
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            sbf.append(String.valueOf(i));
        endTime = System.currentTimeMillis();
        System.out.println("使用StringBuffer的append()方法的执行时间：" + (endTime - beginTime));

        StringBuilder sb = new StringBuilder();
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            sb.append(String.valueOf(i));
        endTime = System.currentTimeMillis();
        System.out.println("使用StringBuilder的append()方法的执行时间：" + (endTime - beginTime));
    }
}
