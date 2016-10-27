package crawley.james.spring.exceptions;

import crawley.james.spring.domain.User;

/**
 * Created by jamescrawley on 10/27/16.
 */
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException () {
        super();
    }

    public UserAlreadyExistsException (String message) {
        super(message);
    }
}
