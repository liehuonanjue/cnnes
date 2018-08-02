package trycat;

/**
 * 用户名的异常类
 */
public class UserNameException extends  UserException {
    public UserNameException() {
    }

    public UserNameException(String message) {
        super(message);
    }

    public UserNameException(String message, Throwable cause) {
        super(message, cause);
    }
}

