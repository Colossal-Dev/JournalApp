package net.project.journalApp.Service;


import lombok.extern.slf4j.Slf4j;
import net.project.journalApp.Repository.UserRepository;

import net.project.journalApp.entity.User;
import org.bson.types.ObjectId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

   // private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public void saveEntry (User user) {
        userRepository.save(user);

    }
    public boolean saveNewUser (User user) {
       try {
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRoles(Arrays.asList("User"));
           userRepository.save(user);
           return true;
       } catch (Exception e) {
//           logger.error("Error while saving user", e);
//           logger.warn("hhhhhhhhhhhhaaaaaaaaaa");
//           logger.info("hhhhhhhhhhhhaaaaaaaaaa");
           log.error("Error while saving user", e);
           log.warn("hhhhhhhhhhhhaaaaaaaaaa");
           log.info("hhhhhhhhhhhhaaaaaaaaaa");
           log.debug("hhhhhhhhhhhhaaaaaaaaaa");

           return false;
       }

    }
    public void saveAdmin (User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User","ADMIN"));
        userRepository.save(user);

    }
    public List<User> getAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }
    public void  deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
