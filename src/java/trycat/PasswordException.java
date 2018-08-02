package trycat;

/**
 * 密码的异常类
 */
public class PasswordException extends  UserException {
    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }

    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
