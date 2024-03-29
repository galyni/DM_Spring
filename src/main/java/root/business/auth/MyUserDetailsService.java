package root.business.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import root.business.core.UtilisateurService;
import root.business.models.Utilisateur;

import java.util.HashSet;
import java.util.Set;

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
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (utilisateur.getRole() != null && utilisateur.getRole().equals("ADMIN")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new User(utilisateur.getUserName(), utilisateur.getPassword(), grantedAuthorities);
    }
}
