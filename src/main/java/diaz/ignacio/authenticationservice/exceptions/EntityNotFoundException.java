package diaz.ignacio.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Could not find entity with name")
public class EntityNotFoundException extends Exception
{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
