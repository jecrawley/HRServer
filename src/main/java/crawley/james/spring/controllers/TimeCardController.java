package crawley.james.spring.controllers;

import crawley.james.spring.domain.TimeCard;
import crawley.james.spring.repository.TimeCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by jamescrawley on 10/26/16.
 */

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class TimeCardController {

    @Autowired
    TimeCardRepository repo;

    @RequestMapping(value = "/timecards", method = RequestMethod.GET)
    public String getAllTimeCards () {
        StringBuilder builder = new StringBuilder("[");

        repo.findAll().forEach(timeCard -> {
            builder.append(timeCard.toString());
        });

        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    @RequestMapping(value = "/timecards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateTimeCards (@RequestBody TimeCard request) {

        try {
            repo.saveAndFlush(new TimeCard(request.getStartTime(), request.getEndTime(), request.getUsername(), request.getDateAsShort()));
        } catch (ParseException e) {
            return "{\"message\":\"Error! Time could not be parsed!\"}";
        }
        return "{\"message\":\"Success!\"}";
    }

    @RequestMapping(value = "/timecards/{id}", method = RequestMethod.DELETE)
    public void deleteTimeCard (Long id) {
        repo.delete(id);
    }
}
