package gather;

public class d2 {
    public static void main(String[] args) {

        String str1 = "Lance";
        String str2 = new String("Lance");
        String str3 = str2; //引用传递，str3直接指向st2的堆内存地址
        String str4 = "Lance";
        String str5 = new String("Lance");
        System.out.println(str1+str4);
        /**
         *  ==:
         * 基本数据类型：比较的是基本数据类型的值是否相同
         * 引用数据类型：比较的是引用数据类型的地址值是否相同
         * 所以在这里的话：String类对象==比较，比较的是地址，而不是内容
         */
        System.out.println(str2==str5);
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str4.equals(str3));
        System.out.println(str1 == str2);//false
        System.out.println(str1 == str3);//false
        System.out.println(str3 == str2);//true
        System.out.println(str1 == str4);//true
        System.out.println(str4.toUpperCase());
    }
}
