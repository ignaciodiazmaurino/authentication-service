package diaz.ignacio.authenticationservice.controller;

import diaz.ignacio.authenticationservice.dataTransferObject.UserDTO;
import diaz.ignacio.authenticationservice.exceptions.EntityNotFoundException;
import diaz.ignacio.authenticationservice.exceptions.UserNotAllowedException;
import diaz.ignacio.authenticationservice.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ( "v1/" )
public class AuthenticationController
{
    AuthenticationService authenticationService;


    @Autowired
    public AuthenticationController(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }


    @PostMapping ( "/token" )
    @ResponseStatus ( HttpStatus.OK )
    @ApiOperation(
        value = "Checks the password and returns a valid token for the user"
    )
    @ApiResponses(
        value = {
            @ApiResponse(code = 401, message = "User not allowed.")
        }
    )
    public String generateToken(@Valid @RequestBody UserDTO userDTO) throws EntityNotFoundException, UserNotAllowedException
    {
        return authenticationService.authenticateUser(userDTO.getUserName(), userDTO.getPassword());
    }

}
