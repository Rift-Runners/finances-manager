/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Guilherme
 */
@MappedSuperclass
public class Finance implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Column(length = 50, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;
    private String type;
    @Column(name = "finance_value")
    private Double financeValue;

    public Finance() {
    }

    public Finance(String name, Subject subject, String type, Double financeValue) {
        this.name = name;
        this.subject = subject;
        this.type = type;
        this.financeValue = financeValue;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.subject);
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + Objects.hashCode(this.financeValue);
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
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.financeValue, other.financeValue)) {
            return false;
        }
        return true;
    }
}
