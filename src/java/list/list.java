package list;

import java.text.Collator;
import java.util.*;

public class list {

    private final static Comparator CHINA_COMPARE = Collator.getInstance(Locale.CHINA);

    public static void main(String[] args) {
/*        Set set=new HashSet();
        set.add("abc");
        System.out.println(set.hashCode());*/
sortList();
    }

    private static void sortList() {
        List<String> list = Arrays.asList("啊三", "张三", "步三");
        Collections.sort(list, CHINA_COMPARE);
        for (String str : list) {
            System.out.println(str);
        }
    }
}

