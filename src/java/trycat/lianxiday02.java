package trycat;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lianxiday02 {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("第一个数");
            int i1 = input.nextInt();
            System.out.println("第二个数");
            int i2 = input.nextInt();
            System.out.println(i1 / i2);
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("算数异常");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("顶级异常");
            e.printStackTrace();
            System.exit(0);

        }
        catch (Exception e) {
            System.out.println("顶级异常");
            e.printStackTrace();
        } finally {
            System.out.println("结束");
        }

    }
}
