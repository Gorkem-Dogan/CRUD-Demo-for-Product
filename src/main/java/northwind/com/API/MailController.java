package northwind.com.API;

import northwind.com.Business.Concretes.CategoryManager;
import northwind.com.Business.Concretes.MailManager;
import northwind.com.Business.Request.CreateCategoryRequest;
import northwind.com.Business.Request.DeleteCategoryRequest;
import northwind.com.Business.Request.MailRequest;
import northwind.com.Business.Request.UpdateCategoryRequest;
import northwind.com.Business.Response.GetAllCategoryResponse;
import northwind.com.Business.Response.GetByIdCategoryResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("api/mails")
public class MailController {
    @Autowired
    private MailManager mailManager;
    @PostMapping("/sendMail")
    public void sendMail(@RequestBody MailRequest mailRequest)
    {
        mailManager.sendMail(mailRequest);
    }
}
