package northwind.com.Core;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;

public class Result {
    private boolean success;
    private String message;
    private String ipAddress;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public Result(boolean success, String message, String ipAddress) {
        this.success = success;
        this.message = message;
        this.ipAddress = ipAddress;
    }
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Result(String message) {
        this.message = message;
    }
    public Result(boolean success) {
        this.success = success;
    }
    public boolean isSuccess()
    {
        return this.success;
    }
    public String getMessage()
    {
        return this.message;
    }
}