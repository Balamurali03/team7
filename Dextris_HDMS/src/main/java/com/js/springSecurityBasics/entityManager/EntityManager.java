package com.js.springSecurityBasics.entityManager;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class EntityManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mId;
	private String mName;
	private String mDepartment;
	private String mMailId;
	private long mPhone;
	
	
	private double mSal;
	private LocalDate mDOJ;	
	
	
	
	
	public long getmId() {
		return mId;
	}
	public void setmId(long mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmDepartment() {
		return mDepartment;
	}
	public void setmDepartment(String mDepartment) {
		this.mDepartment = mDepartment;
	}
	public String getmMailId() {
		return mMailId;
	}
	public void setmMailId(String mMailId) {
		this.mMailId = mMailId;
	}
	public long getmPhone() {
		return mPhone;
	}
	public void setmPhone(long mPhone) {
		this.mPhone = mPhone;
	}
	@Override
	public String toString() {
		return "EntityManager [mId=" + mId + ", mName=" + mName + ", mDepartment=" + mDepartment + ", mMailId="
				+ mMailId + ", mPhone=" + mPhone + ", getmId()=" + getmId() + ", getmName()=" + getmName()
				+ ", getmDepartment()=" + getmDepartment() + ", getmMailId()=" + getmMailId() + ", getmPhone()="
				+ getmPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public EntityManager(long mId, String mName, String mDepartment, String mMailId, long mPhone) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mDepartment = mDepartment;
		this.mMailId = mMailId;
		this.mPhone = mPhone;
	}
	
	
	
	

}
