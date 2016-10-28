package crawley.james.spring.controllers;


import crawley.james.spring.domain.User;
import crawley.james.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jamescrawley on 10/26/16.
 */

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class UserController {

    @Autowired
    UserRepository repo;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers () {
        StringBuilder builder = new StringBuilder("[");

        repo.findAll().forEach(user -> {
            builder.append(user.toString());
        });

        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addUser (@RequestBody User request) {

        try {
            repo.saveAndFlush(new User(request.getUsername(), request.getPassword()));
        } catch (DataIntegrityViolationException e) {

            return "{\"message\":\"Error! User already exists!\"}";

        }
        return "{\"message\":\"Success!\"}";
    }
}
