/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kozlovskaya.web.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private short accept;
    @Basic(optional = false)
    private String commentary;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

    public Request() {
    }

    public Request(Integer id) {
        this.id = id;
    }

    public Request(Integer id, short accept, String commentary) {
        this.id = id;
        this.accept = accept;
        this.commentary = commentary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getAccept() {
        return accept;
    }

    public void setAccept(short accept) {
        this.accept = accept;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Request[ id=" + id + " ]";
    }
    
}
