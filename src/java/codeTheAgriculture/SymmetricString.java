package codeTheAgriculture;


/**
 * 对称字符串
 */
public class SymmetricString {
    public static void main(String[] args) {
        System.out.println(ispStr("abccba"));
        System.out.println(ispSt_2("abccba"));

    }

    public static boolean ispStr(String pStr) {
        if (pStr == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer(pStr);
        stringBuffer.reverse();
        return stringBuffer.toString().equals(pStr);
    }

    public static boolean ispSt_2(String Str) {
        if (Str == null) {
            return false;
        }
        int lengt = Str.length();
        for (int i = 0; i < lengt / 2; i++) {
            if (Str.charAt(i) != Str.charAt(lengt - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
