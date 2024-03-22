package northwind.com.Business.Abstracts;

import northwind.com.Business.Request.MailRequest;
import northwind.com.Core.Result.Result;

public interface MailService
{
    Result sendMail(MailRequest request);
}
