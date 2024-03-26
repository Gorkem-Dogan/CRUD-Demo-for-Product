package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.MailService;
import northwind.com.Business.Request.MailRequest;
import northwind.com.Core.Result.Result;
import northwind.com.Core.Result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailManager implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Result sendMail(MailRequest request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(request.getSender());
        simpleMailMessage.setTo(request.getFromTo());
        simpleMailMessage.setText(request.getBody());
        simpleMailMessage.setSubject(request.getSubject());
        this.mailSender.send(simpleMailMessage);
        return new SuccessResult("has been sent successfully");
    }
}

