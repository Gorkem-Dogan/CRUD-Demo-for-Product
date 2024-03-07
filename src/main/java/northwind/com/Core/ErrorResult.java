package northwind.com.Core;

public class ErrorResult extends Result {
    public ErrorResult(boolean success, String message) {
        super(false, message);
    }

    public ErrorResult(String message) {
        super(message);
    }

    public ErrorResult(boolean success) {
        super(false);
    }
}
