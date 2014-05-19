package com.ulebank.step.domain;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Cuenta: " + id + ";");
        buffer.append("Comision: " + comision);
        return buffer.toString();
    }

	public void setId(String id) {
		this.id = id;
	}
	
}
