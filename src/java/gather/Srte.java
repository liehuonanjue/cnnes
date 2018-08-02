package gather;

public class Srte {
    public static void main(String[] args) {
        String str = "吃葡萄不吐葡萄皮，不吃葡萄倒吐葡萄皮";
        //请用四种方法统计 葡萄 出现的次数
        // 第一种
        String str1 = str.replace("葡萄", " ");
        char[] data = str1.toCharArray();
        int count = 0;
        for (char a : data) {
            if (a == ' ') {
                count++;
            }
        }
        System.out.println(count);
        // 第二种
        int countt = 0;
        int x = 0;
        while (x != -1) {
            x = str.indexOf("葡萄");
            if (x != -1) {
                countt++;
                str = str.replaceFirst("葡萄", "");
            }
        }
        System.out.println(countt);
        // 第五种
        int counte = 0;
        int xx = 0;
        while (xx != -1) {
            xx = str.indexOf("葡萄");
            if (xx != -1) {
                if ((xx + 2) < str.length()) {
                    str = str.substring(xx + 2);
                }
                counte++;
            }
        }
        System.out.println(count);


    }
}