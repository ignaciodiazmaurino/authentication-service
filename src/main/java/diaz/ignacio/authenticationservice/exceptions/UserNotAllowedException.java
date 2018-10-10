package diaz.ignacio.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "User not allowed")
public class UserNotAllowedException extends Exception
{
    public UserNotAllowedException(String message) {
        super(message);
    }
}
