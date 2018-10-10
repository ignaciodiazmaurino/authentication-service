package diaz.ignacio.authenticationservice.domainObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleDO
{
    @Id
    private Long id;

    @Column
    private String name;

    public RoleDO () {
    }

    public RoleDO(String name) {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
