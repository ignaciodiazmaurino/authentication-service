package diaz.ignacio.authenticationservice.service.impl;

import diaz.ignacio.authenticationservice.domainObject.UserDO;
import diaz.ignacio.authenticationservice.exceptions.EntityNotFoundException;
import diaz.ignacio.authenticationservice.exceptions.UserNotAllowedException;
import diaz.ignacio.authenticationservice.repositories.UserRepository;
import diaz.ignacio.authenticationservice.service.AuthenticationService;
import diaz.ignacio.authenticationservice.util.JwtUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;
import static diaz.ignacio.authenticationservice.util.EncryptionUtil.validatePassword;


@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthenticationServiceImpl(UserRepository userRepository, JwtUtil jwtUtil)
    {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public String authenticateUser (String name, String password) throws EntityNotFoundException, UserNotAllowedException
    {

        UserDO user = Optional.ofNullable(userRepository.findByName(name))
            .orElseThrow(() -> new EntityNotFoundException(""));

        if (validatePassword(password, user.getPassword())) {
            return jwtUtil.generateToken(user);
        } else {
            throw new UserNotAllowedException("User not allowed");
        }

    }
}
