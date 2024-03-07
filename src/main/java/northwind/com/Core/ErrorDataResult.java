package northwind.com.Core;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(boolean success, String message, T data) {
        super(success, message, data);
    }

    public ErrorDataResult(String message, T data) {
        super(message, data);
    }

    public ErrorDataResult(boolean success, T data) {
        super(success, data);
    }
}
