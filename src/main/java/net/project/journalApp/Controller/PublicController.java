package net.project.journalApp.Controller;

import lombok.extern.slf4j.Slf4j;
import net.project.journalApp.Service.UserDetailsServiceImpl;
import net.project.journalApp.Service.UserService;
import net.project.journalApp.entity.User;
import net.project.journalApp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl  userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticateManager;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
    @PostMapping("/signup")
    public void signup(@RequestBody User user) {

//        userService.saveEntry(user);
        userService.saveNewUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        try{
            authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
                log.error("Exception occured while createAuthenticationToken: ", e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
