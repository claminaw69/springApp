package com.ulebank.step.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts") 
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
	private String id;
	private double comision;

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Cuenta: " + id + ";");
        buffer.append("Comision: " + comision);
        return buffer.toString();
    }


	
}
