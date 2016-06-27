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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "debits")
@XmlRootElement
public class Debit extends Finance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_debit")
    private Long id;
    private Boolean paid;
    //@Column(name = "payable_until")
    //private Date payableUntil;

    public Debit() {
    }

    public Debit(Long id, Boolean paid, String name, Subject subject, String type, Double financeValue) {
        super(name, subject, type, financeValue);
        this.id = id;
        this.paid = paid;
        //this.payableUntil = payableUntil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

//	  public Date getPayableUntil() {
//        return paid;
//    }
//
//    public void setPayableUntil(Date payableUntil) {
//        this.payableUntil = payableUntil;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.paid);
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
        final Debit other = (Debit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.paid, other.paid)) {
            return false;
        }
        return true;
    }
}
