/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kozlovskaya.web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "class", catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gruppa.findAll", query = "SELECT g FROM Gruppa g")})
public class Gruppa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int classNumber;
    @JoinTable(name = "studentsclasses", joinColumns = {
        @JoinColumn(name = "class", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "customer", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Customer> customerList;
    @JoinColumn(name = "lang", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Lang lang;

    public Gruppa() {
    }

    public Gruppa(Integer id) {
        this.id = id;
    }

    public Gruppa(Integer id, int classNumber) {
        this.id = id;
        this.classNumber = classNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
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
        if (!(object instanceof Gruppa)) {
            return false;
        }
        Gruppa other = (Gruppa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gruppa[ id=" + id + " ]";
    }
    
}
