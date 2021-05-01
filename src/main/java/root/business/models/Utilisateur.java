package root.business.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    private String firstName;
    private String mail;
    private String password;
    private String billingAddress;
    private String userName;
    private Set<Role> roles;

    public Utilisateur(String firstName, String mail, String password, String billingAddress, String userName, Set<Role> roles) {
        this.firstName = firstName;
        this.mail = mail;
        this.password = password;
        this.billingAddress = billingAddress;
        this.userName = userName;
        this.roles = roles;
    }

    public Utilisateur(){

    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utilisateurs_roles", joinColumns = @JoinColumn (name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Basic(optional = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Basic(optional = false)
    public String getUserName() { return this.userName; }
    public void setUserName(String userName) { this.userName = userName; }

    @Basic(optional = false)
    public String getBillingAddress(){return billingAddress;}
    public void setBillingAddress(String billingAddress){this.billingAddress = billingAddress;}

}
