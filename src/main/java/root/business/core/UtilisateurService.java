package root.business.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.business.models.Product;
import root.business.models.Utilisateur;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private SessionFactory sessionFactory;

    public UtilisateurService() {
    }

    public void test(){
        System.out.println("On est contents");
    }

    public List<Utilisateur> getAllUtilisateurs(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> rootEntry = cq.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> all = cq.select(rootEntry);

        TypedQuery<Utilisateur> allQuery = session.createQuery(all);
        return allQuery.getResultList();

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
        session.save(utilisateur);
    }
}
