package net.project.journalApp.Controller;

import net.project.journalApp.Service.UserService;
import net.project.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {

//        userService.saveEntry(user);
        userService.saveNewUser(user);
    }

}
