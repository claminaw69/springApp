package com.ulebank.step.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChangeComision {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String id;
    private double comision;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

    public void setComision(double i) {
        this.comision = i;
        logger.info("comision set to " + i);
    }

    public double getComision() {
        return this.comision;
    }
}