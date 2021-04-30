package root.business.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import root.business.core.UtilisateurService;
import root.business.models.Utilisateur;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService srv;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Utilisateur utilisateur = srv.getUtilisateurById(mail);
        if (utilisateur == null) {
            throw new UsernameNotFoundException(mail);
        }
        return new MyUserPrincipal(utilisateur);
    }
}
