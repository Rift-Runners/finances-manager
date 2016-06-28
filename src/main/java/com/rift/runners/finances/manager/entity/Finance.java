/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@Entity
@Table(name = "finances")
@XmlRootElement
public class Finance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_finance")
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_subject", nullable = true)
    private Subject subject;
    private String type;
    @Column(name = "finance_value")
    private Double financeValue;
    @Column(nullable = true)
    private Boolean paid;
    //@Column(name = "payable_until")
    //private Date payableUntil;

    public Finance() {
    }

    public Finance(Long id, String name, Subject subject, String type, Double financeValue, Boolean paid) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.type = type;
        this.financeValue = financeValue;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getFinanceValue() {
        return financeValue;
    }

    public void setFinanceValue(Double financeValue) {
        this.financeValue = financeValue;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.subject);
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + Objects.hashCode(this.financeValue);
        hash = 47 * hash + Objects.hashCode(this.paid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Finance other = (Finance) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.financeValue, other.financeValue)) {
            return false;
        }
        if (!Objects.equals(this.paid, other.paid)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Finance{" + "id=" + id + ", name=" + name + ", subject=" + subject + ", type=" + type + ", financeValue=" + financeValue + ", paid=" + paid + '}';
    }
}
