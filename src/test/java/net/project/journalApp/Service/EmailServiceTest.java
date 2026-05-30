package net.project.journalApp.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {


    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    public void testEmailService() {
        emailService.sendEmail("chaurasiyaveer05@gmail.com","sending email","Hi,What are you doing ?");
    }

}
