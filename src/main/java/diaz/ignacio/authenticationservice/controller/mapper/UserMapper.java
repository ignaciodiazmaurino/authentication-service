package diaz.ignacio.authenticationservice.controller.mapper;

import diaz.ignacio.authenticationservice.domainObject.UserDO;

public class UserMapper
{
    public static UserDO makeUserDTO(UserDO userDO)
    {
        return new UserDO(
            userDO.getId(),
            userDO.getName(),
            userDO.getPassword(),
            userDO.getRole()
        );
    }
}
