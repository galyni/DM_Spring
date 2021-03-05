package business.models;


import org.springframework.context.annotation.Primary;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

    public String email;
    public String password;

    @Basic(optional = false)
    @Id
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String login) {
        this.email = login;
    }

    @Basic(optional = false)
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
