package northwind.com.API;

import northwind.com.Business.Concretes.MailManager;
import northwind.com.Business.Request.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
