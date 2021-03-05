package business.models;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

    public String login;
    public String password;

    @Basic(optional = false)
    @Id
    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Basic(optional = false)
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
