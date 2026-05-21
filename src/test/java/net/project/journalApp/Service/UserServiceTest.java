package net.project.journalApp.Service;

import net.project.journalApp.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserServiceTest {

    @Autowired
     private UserRepository userRepository;

    @Disabled
    @Test
    public void addtest() {
        assertEquals(4,3+1);
        assertNotNull(userRepository.findByUsername("Ram"));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,3,4",
            "5,4,9",
            "1,1,1"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected,a+b);
    }
}
