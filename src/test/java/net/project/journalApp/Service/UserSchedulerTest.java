package net.project.journalApp.Service;

import net.project.journalApp.scheduler.UserScheduler;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTest {


    @Autowired
    private UserScheduler userScheduler;


    @Disabled
    @Test
    public  void schedulerTest() {

        userScheduler.fetchUserAndSendSaMail();
    }

}
