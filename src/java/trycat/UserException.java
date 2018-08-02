package trycat;

/**
 * 针对于User的异常处理类
 */
public class UserException  extends  RuntimeException{

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
