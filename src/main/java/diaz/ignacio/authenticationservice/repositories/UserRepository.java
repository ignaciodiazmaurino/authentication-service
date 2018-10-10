package diaz.ignacio.authenticationservice.repositories;

import diaz.ignacio.authenticationservice.domainObject.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDO, Long>
{
    UserDO findByName(String name);
}
