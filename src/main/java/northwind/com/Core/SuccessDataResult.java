package northwind.com.Core;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(boolean success, String message, T data) {
        super(true, message, data);
    }

    public SuccessDataResult(String message, T data) {
        super(true, data);
    }

    public SuccessDataResult(boolean success, T data) {
        super(true, data);
    }
}
