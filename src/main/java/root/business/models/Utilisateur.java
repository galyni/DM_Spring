package root.business.models;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    private String login;
    private String mail;
    private String password;


    public Utilisateur(String name, String mail, String password) {
        this.login = name;
        this.mail = mail;
        this.password = password;
    }

    public Utilisateur(){

    }

    @Basic(optional = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic(optional = false)
    @Id
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic(optional = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
