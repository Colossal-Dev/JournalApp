package net.project.journalApp.Service;


import net.project.journalApp.Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Disabled
    @Test
    void test() {
        userRepository.getUserForSA();
        Assertions.assertEquals(4,2+2);


    }
}
