
package com.kozlovskaya.web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String secondName;
    @Basic(optional = false)
    private String firstName;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private String numberPhone;
    @Basic(optional = false)
    private String login;
    @Basic(optional = false)
    private String pass;
    @Basic(optional = false)
    private String userRole;
    @ManyToMany(mappedBy = "customerList", fetch = FetchType.EAGER)
    private List<Gruppa> gruppaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Request> requestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Review> reviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender", fetch = FetchType.EAGER)
    private List<Message> messageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taker", fetch = FetchType.EAGER)
    private List<Message> messageList1;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String secondName, String firstName, String email, String numberPhone, String login, String pass, String userRole) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.email = email;
        this.numberPhone = numberPhone;
        this.login = login;
        this.pass = pass;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<Gruppa> getGruppaList() {
        return gruppaList;
    }

    public void setGruppaList(List<Gruppa> gruppaList) {
        this.gruppaList = gruppaList;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Message> getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(List<Message> messageList1) {
        this.messageList1 = messageList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer[ id=" + id + " ]";
    }
    
}
