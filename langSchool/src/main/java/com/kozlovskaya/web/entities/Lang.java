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
@Table(catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lang.findAll", query = "SELECT l FROM Lang l")})
public class Lang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String languageName;
    @Basic(optional = false)
    private double costCourse;
    @Basic(optional = false)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lang", fetch = FetchType.EAGER)
    private List<Review> reviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lang", fetch = FetchType.EAGER)
    private List<Gruppa> gruppaList;

    public Lang() {
    }

    public Lang(Integer id) {
        this.id = id;
    }

    public Lang(Integer id, String languageName, double costCourse, String description) {
        this.id = id;
        this.languageName = languageName;
        this.costCourse = costCourse;
        this.description = description;
    }

    public double getCostCourse() {
        return costCourse;
    }

    public void setCostCourse(double costCourse) {
        this.costCourse = costCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Gruppa> getGruppaList() {
        return gruppaList;
    }

    public void setGruppaList(List<Gruppa> gruppaList) {
        this.gruppaList = gruppaList;
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
        if (!(object instanceof Lang)) {
            return false;
        }
        Lang other = (Lang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lang{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                ", costCourse=" + costCourse +
                ", description='" + description + '\'' +
                '}';
    }
}
