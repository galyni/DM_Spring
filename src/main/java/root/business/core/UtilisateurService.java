package root.business.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.business.models.Utilisateur;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UtilisateurService() {
    }

    public Utilisateur getUtilisateurById(String mail){
        Session session = sessionFactory.getCurrentSession();
        Utilisateur utilisateur = session.find(Utilisateur.class, mail);
        return utilisateur;
    }

    public void deleteUtilisateur(String mail){
        Session session = sessionFactory.getCurrentSession();
        Utilisateur utilisateur = getUtilisateurById(mail);
        session.delete(utilisateur);
    }

    public void updateUtilisateur(Utilisateur utilisateur){
        Session session = sessionFactory.getCurrentSession();
        session.update(utilisateur);
    }

    public void createUtilisateur(Utilisateur utilisateur){
        Session session = sessionFactory.getCurrentSession();
        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword())); //TB
        session.save(utilisateur);
    }
}
