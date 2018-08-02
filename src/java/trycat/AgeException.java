package trycat;

/**
 * 密码的异常类
 */
public class AgeException extends  UserException {
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
