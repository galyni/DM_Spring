package root.business.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
@Component
public class CookieFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(CookieFilter.class.getName());

    //@Autowired
    //private UserManager userManager;
 
    public CookieFilter()
    {
        String fred ="pouchan";
    }
 
    @Override
    public void init(FilterConfig fConfig)
    {
        String autreFred = "dopplePouchan";
    }
 
    @Override
    public void destroy() {
        String toujoursFred = "claire";
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
	// To retrieve / store cookies :
	Cookie[] cookies = req.getCookies();
	for(Cookie cookie : cookies){
	    if(cookie.getName().equals("utilisateur")){
	        request.setAttribute("connexion", true);
        }
    }
	//
	// new Cookie(...)
	// response.addCookie(...)
	
	// To retrieve / store information in the session :
	// session.setAttribute(...)


        chain.doFilter(request, response);
    }
 
}
