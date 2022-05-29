package cross1usf.firstproject.config.jwt;

import cross1usf.firstproject.config.filters.JwtTokenFilter;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
@AllArgsConstructor
public class JwtProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    /*@Value("${app.jwt.secret}")
    private String secretKey;
   *//* SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(bas))*/

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("cross1usf")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(new Date(System.currentTimeMillis() + 3000000L))
                .compact();
    }

    public boolean validateJWTToken(String token) {
        try{
        Jwts.parser().parseClaimsJws(token);
        return true;
        }
        catch (Exception e){
            LOGGER.error("JWT No Work!", e);
            return false;
        }
    }

    public String getSubject(String token) {
        return Jwts
                .parser()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

}


  /*return jwt
                .setSubject(user.getUsername())
                .setIssuer("cross1")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 3000000L))
                .compact()*/;
