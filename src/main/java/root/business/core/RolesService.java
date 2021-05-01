package root.business.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.business.models.Role;
import root.business.models.Utilisateur;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class RolesService {

    @Autowired
    private SessionFactory sessionFactory;

    public RolesService() {
    }

    public void test(){
        System.out.println("On est contents");
    }

    public List<Role> getAll(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> rootEntry = cq.from(Role.class);
        CriteriaQuery<Role> all = cq.select(rootEntry);

        TypedQuery<Role> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}

