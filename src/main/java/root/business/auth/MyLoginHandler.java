package root.business.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import root.business.core.CookieHandler;
import root.business.core.UtilisateurService;
import root.business.models.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class MyLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UtilisateurService srv;

    public MyLoginHandler() {
        super();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = request.getParameter("mail");
        // est-il normal d'un point de vue métier que username soit null ?
        // si non, on peut :
        // - soit logger l'erreur
        // - soit (a priori meilleur) renvoyer une exception
        if (username != null) {
            CookieHandler.createCookie(username, response );
            Utilisateur utilisateur = srv.getUtilisateurById(username);
            // même question : est-il normal de ne pas trouver d'utilisateur ? il peut êtr plus intéressant de laisser
            // crasher le code pour le corriger facilement, plutôt que de passer l'erreur sous silence
            if(utilisateur != null) {
                request.getSession().setAttribute("prenom", utilisateur.getFirstName());
            }
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
