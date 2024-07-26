package com.dextris.hrms.manager.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mId;

    private String mName;
    private String mDepartment;
    private String mMailId;
    private String mPhone;
    private double mSal;
    private LocalDate mDOJ;
    private String officeMailId;
    private String officeMailIdPassword;

    // Getters and Setters
    public Long getMId() {
        return mId;
    }

    public void setMId(Long mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMDepartment() {
        return mDepartment;
    }

    public void setMDepartment(String mDepartment) {
        this.mDepartment = mDepartment;
    }

    public String getMMailId() {
        return mMailId;
    }

    public void setMMailId(String mMailId) {
        this.mMailId = mMailId;
    }

    public String getMPhone() {
        return mPhone;
    }

    public void setMPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public double getMSal() {
        return mSal;
    }

    public void setMSal(double mSal) {
        this.mSal = mSal;
    }

    public LocalDate getMDOJ() {
        return mDOJ;
    }

    public void setMDOJ(LocalDate mDOJ) {
        this.mDOJ = mDOJ;
    }

    public String getOfficeMailId() {
        return officeMailId;
    }

    public void setOfficeMailId(String officeMailId) {
        this.officeMailId = officeMailId;
    }

    public String getOfficeMailIdPassword() {
        return officeMailIdPassword;
    }

    public void setOfficeMailIdPassword(String officeMailIdPassword) {
        this.officeMailIdPassword = officeMailIdPassword;
    }
}

