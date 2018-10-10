package diaz.ignacio.authenticationservice.dataTransferObject;

import javax.validation.constraints.NotNull;

public class UserDTO
{
    private Long id;

    @NotNull (message = "userName can not be null")
    private String userName;

    @NotNull (message = "password can not be null")
    private String password;

    private UserDTO() {}

    private UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public static class UserDTOBuilder {
        private String userName;
        private String password;

        public UserDTOBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(userName,password);
        }
    }
}
