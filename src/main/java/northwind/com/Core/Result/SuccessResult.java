package northwind.com.Core.Result;

public class SuccessResult extends Result{
    public SuccessResult(boolean success, String message) {
        super(true, message);
    }

    public SuccessResult(String message) {
        super(message);
    }

    public SuccessResult(boolean success) {
        super(true);
    }

    public SuccessResult(boolean b, String hasBeenDeletedSuccessfully, String hostAddress) {
        super(true, hasBeenDeletedSuccessfully ,hostAddress);
    }
}
