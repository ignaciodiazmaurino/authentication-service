package diaz.ignacio.authenticationservice.service;

import diaz.ignacio.authenticationservice.domainObject.UserDO;
import diaz.ignacio.authenticationservice.exceptions.EntityNotFoundException;
import diaz.ignacio.authenticationservice.exceptions.UserNotAllowedException;

public interface AuthenticationService
{

    String authenticateUser (String name, String password) throws EntityNotFoundException, UserNotAllowedException;
}
