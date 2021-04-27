package root.business.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.CookieHandler;
import root.business.core.UtilisateurService;
import root.business.models.Utilisateur;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UtilisateurController {

    private UtilisateurService srv;

    public UtilisateurController(UtilisateurService srv)
    {
        this.srv = srv;
    }

    @RequestMapping(path="/disconnect", method=RequestMethod.GET)
    public ModelAndView disconnect(HttpServletRequest request)
    {
        request.getSession().setAttribute("connected", false);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @RequestMapping(path="/login", method=RequestMethod.GET)
    public ModelAndView gotToLoginForm(ServletRequest request)
    {
        Utilisateur user = new Utilisateur();
        Cookie cookie = CookieHandler.getCookie((HttpServletRequest)request);
        if(cookie != null)
        {
            user.setMail(cookie.getValue());
        }
        return new ModelAndView("login", "utilisateur", user);
    }

    @RequestMapping(path="login", method=RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute("utilisateur") Utilisateur utilisateur, HttpServletRequest request, ServletResponse response)
    {
        if (utilisateur != null) {
            request.getSession().setAttribute("connected", true);
            // TODO connect user if exist
        }
        return new ModelAndView("redirect:/GetProductsList");//TODO redirect elsewhere (landing page?)
    }

    @RequestMapping(path="/register", method= RequestMethod.GET)
    public ModelAndView goToRegisterForm(){

        return new ModelAndView("register", "utilisateur", new Utilisateur());
    }

    @RequestMapping(path="/register", method=RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("utilisateur") Utilisateur utilisateur, HttpServletRequest request, HttpServletResponse response){

        String firstName = utilisateur.getFirstName();
        String mail = utilisateur.getMail();
        String password = utilisateur.getPassword();
        String userName = utilisateur.getUserName();
        String billingAddress = utilisateur.getBillingAddress();
        request.getSession().setAttribute("connected", true);
        CookieHandler.createCookie(utilisateur, response);

        if (utilisateur != null) {

            srv.createUtilisateur(utilisateur);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }
}