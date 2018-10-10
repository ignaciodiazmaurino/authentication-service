package diaz.ignacio.authenticationservice.domainObject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDO
{
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String password;

    @ManyToOne ( cascade = CascadeType.ALL )
    private RoleDO role;


    public UserDO()
    {
    }


    public UserDO(Long id, String name, String password, RoleDO role)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public RoleDO getRole()
    {
        return role;
    }


    public void setRole(RoleDO role)
    {
        this.role = role;
    }
}
