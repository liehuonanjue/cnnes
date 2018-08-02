package trycat;


/**
 * 需求：
 01. 让用户分别输入两个数字
 02.求两个数字的商
 03.使用异常处理机制解决可能出现的异常情况

 大括号圣战
 *
 */
public class App {
    public static void main( String[] args ) {
        try {
            showUserName();
        }catch (UserNameException e){
           e.printStackTrace();
        }

    }
    private static void showUserName() throws  UserNameException {

        try {
            showPassword();
        }catch (PasswordException e){
            e.printStackTrace();
            throw new UserNameException("用户名异常",e);
        }

    }

    private static void showPassword() throws PasswordException {
        try {
            showAge();
        }catch (AgeException e){
            e.printStackTrace();
            throw new PasswordException("密码异常",e);
        }
        }


    private static void showAge() throws AgeException {
        throw new AgeException("年龄异常");
    }


}
