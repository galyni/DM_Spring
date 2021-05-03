package root.business.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.CookieHandler;
import root.business.core.UtilisateurService;
import root.business.models.Utilisateur;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UtilisateurController {

    private UtilisateurService srv;

    public UtilisateurController(UtilisateurService srv)
    {
        this.srv = srv;
    }

    @RequestMapping(path="/userInfo", method=RequestMethod.GET)
    public ModelAndView goToInfoPage(HttpServletRequest request)
    {
       // if (redirection(request)) {
       //     return new ModelAndView("redirect:/login");
      //  }
        //Utilisateur user = srv.getUtilisateurById(CookieHandler.getCookie(request).getValue()) ;
        return new ModelAndView("userInfo", "utilisateur", srv.getUtilisateurById(CookieHandler.getCookie(request).getValue()) );
    }

    @RequestMapping(path="/disconnect", method=RequestMethod.GET)
    public ModelAndView disconnect(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.getSession().setAttribute("connected", false);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @RequestMapping(path="/login", method=RequestMethod.GET)
    public ModelAndView gotToLoginForm(ServletRequest request, String error)
    {
        if(error != "") {
            request.setAttribute("error", "login failed");
        }
        Utilisateur user = new Utilisateur();
        Cookie cookie = CookieHandler.getCookie((HttpServletRequest)request);
        if(cookie != null)
        {
            user.setMail(cookie.getValue());
        }
        return new ModelAndView("login", "utilisateur", user);
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute("utilisateur") Utilisateur utilisateur, HttpServletRequest request, HttpServletResponse response)
    {

        if (utilisateur != null) {
            request.getSession().setAttribute("connected", true);
            CookieHandler.createCookie(utilisateur, response );
            //TODO connect user if exist
        }
        return new ModelAndView("redirect:/GetProductsList");//TODO redirect elsewhere (landing page?)
       // return "login";
    }

    @RequestMapping(path="/register", method= RequestMethod.GET)
    public ModelAndView goToRegisterForm(){

        return new ModelAndView("register", "utilisateur", new Utilisateur());
    }

    @RequestMapping(path="/register", method=RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("utilisateur") Utilisateur utilisateur, HttpServletRequest request, HttpServletResponse response){

        request.getSession().setAttribute("connected", true);
        CookieHandler.createCookie(utilisateur, response);

        if (utilisateur != null) {

            srv.createUtilisateur(utilisateur);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }

    private boolean redirection(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("connected") == null) {
            return true;
        } else if (!(boolean)request.getSession().getAttribute("connected")){
            return true;
        };
        return false;
    }
}