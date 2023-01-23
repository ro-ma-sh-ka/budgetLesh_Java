package com.example.budgetLesh.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

// annotation which responsible for table into DB
@Entity
public class Budget {

    // annotation which show it's an unique field
    @Id

    // annotation which automatically generate a new unique id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String what_is, section, currency;

    private Float total;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhat_is() {
        return what_is;
    }

    public void setWhat_is(String what_is) {
        this.what_is = what_is;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    // in any models must be constructor without any parameters!!
    public Budget() {
    }

    public Budget(Date date, String what_is, String section, Float total, String currency) {
        this.date = date;
        this.what_is = what_is;
        this.section = section;
        this.total = total;
        this.currency = currency;
    }
}
