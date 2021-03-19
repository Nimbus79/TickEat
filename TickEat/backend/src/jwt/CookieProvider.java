package jwt;

import org.apache.commons.codec.binary.Base64;
import io.jsonwebtoken.Claims;
import javax.servlet.http.Cookie;
import static jwt.TokenProvider.getTokenFromCookie;
import static jwt.TokenProvider.verifyToken;
import static main.Crypto.encryptTokenString;


public class CookieProvider {

    public static Claims getClaimsFromCookies(Cookie[] cookies) {
        Cookie cookie = null;

        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                cookie = (Cookie) c.clone();
            }
        }

        if (cookie == null) {
            return null;
        }

        String token = getTokenFromCookie(cookie);
        Claims claims = verifyToken(token);

        return claims;
    }

    public static Cookie createCookie(String token, boolean sessao) {
        byte[] encrypt = encryptTokenString(token);
        String encryptString = Base64.encodeBase64URLSafeString(encrypt);

        Cookie cookie = new Cookie("token", encryptString);
        cookie.setHttpOnly(true);

        if (!sessao) {
            cookie.setMaxAge(2 * 60 * 60); // 2 horas
        }
        else {
            cookie.setMaxAge(7 * 24 * 60 * 60); // 1 semana
        }

        return cookie;
    }
}