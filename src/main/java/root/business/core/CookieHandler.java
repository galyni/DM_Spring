package root.business.core;

import root.business.models.Utilisateur;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandler
{
    private CookieHandler(){}

    public static Cookie createCookie(Utilisateur utilisateur, HttpServletResponse response)
    {
        Cookie cookie = new Cookie("currentUser", utilisateur.getMail());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return cookie ;
    }

    public static Cookie createCookie(String username, HttpServletResponse response)
    {
        Cookie cookie = new Cookie("currentUser", username);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return cookie ;
    }

    public static Cookie getCookie(HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals("currentUser"))
                {
                    request.setAttribute("connexion", true);
                    return cookie;
                }
            }
        }
        return null;
    }
}
