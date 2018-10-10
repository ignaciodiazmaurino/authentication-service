package diaz.ignacio.authenticationservice.util;

import diaz.ignacio.authenticationservice.domainObject.UserDO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil
{
    @Value ( "${token.secret.key}" )
    private String secretKey;

    @Value ( "${token.expiration.time}" )
    private String expirationTime;


    public String generateToken(UserDO user)
    {

        return Jwts.builder()
            .setId(Long.toString(user.getId()))
            .setIssuer(user.getName())
            .setIssuedAt(new Date())
            .setExpiration(getExpirationDate())
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }


    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parser().setSigningKey(secretKey).parse(token);
            return true;
        }
        catch (ExpiredJwtException e)
        {

        }
        catch (UnsupportedJwtException e)
        {

        }
        catch (MalformedJwtException e)
        {

        }
        catch (SignatureException e)
        {

        }
        catch (IllegalArgumentException e)
        {

        }
        return false;

    }


    private Date getExpirationDate()
    {

        ZonedDateTime expirationZonedDateTime = ZonedDateTime.now()
            .plusSeconds(Long.parseLong(expirationTime));

        return Date.from(expirationZonedDateTime.toInstant());
    }


}
