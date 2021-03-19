package jwt;

import org.apache.commons.codec.binary.Base64;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureException;
import main.Crypto;
import javax.servlet.http.Cookie;
import java.security.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static main.Crypto.decryptTokenString;


public class TokenProvider {

    public static String createToken(String email, String nome, String tipo, boolean sessao) {
        PrivateKey privateKey = Crypto.loadPrivateKey();
        String token = null;
        Date now = new Date();
        Date expiryDate;

        Header header = Jwts.header();
        header.setType("JWT");
        Map<String, String> nomeTipo = new HashMap<>();
        nomeTipo.put("name", nome);
        nomeTipo.put("type", tipo);

        Claims claims = Jwts.claims();
        claims.setSubject(email);
        claims.putAll(nomeTipo);

        if (!sessao) {
            expiryDate = new Date(now.getTime() + 2 * 60 * 60 * 1000); // 2 horas
        }
        else {
            expiryDate = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000); // 1 semana
        }

        claims.setIssuer("tickeat")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate);

        try {
            token = Jwts.builder().setHeader((Map<String, Object>) header)
                    .setClaims((Map<String, Object>) claims)
                    .signWith(SignatureAlgorithm.RS512, privateKey)
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    public static String getTokenFromCookie(Cookie cookie) {
        String token = null;

        try {
            String value = cookie.getValue();
            byte[] decryptArray = Base64.decodeBase64(value);
            token = decryptTokenString(decryptArray);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return token;
    }

    public static Claims verifyToken(String token) {
        PublicKey publicKey = Crypto.loadPublicKey();
        Claims claims = null;

        try {
            claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
            String sig = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getSignature();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        return claims;
    }
}