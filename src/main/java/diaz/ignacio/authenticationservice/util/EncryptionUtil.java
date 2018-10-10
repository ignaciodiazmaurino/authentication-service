package diaz.ignacio.authenticationservice.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptionUtil
{

    
    public static String encrypt(String password)
    {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean validatePassword(String password, String storedPassword)
    {
        return BCrypt.checkpw(password, storedPassword);
    }

    public static String createToken() {
        return "";
    }

}
