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
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String content;
    @Basic(optional = false)
    private short accept;
    @JoinColumn(name = "sender", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer sender;
    @JoinColumn(name = "taker", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer taker;

    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, String content, short accept) {
        this.id = id;
        this.content = content;
        this.accept = accept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getAccept() {
        return accept;
    }

    public void setAccept(short accept) {
        this.accept = accept;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getTaker() {
        return taker;
    }

    public void setTaker(Customer taker) {
        this.taker = taker;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", accept=" + accept +
                ", sender=" + sender +
                ", taker=" + taker +
                '}';
    }
}
