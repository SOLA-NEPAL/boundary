/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.casemanagement;

import org.sola.services.common.contracts.AbstractTO;

/**
 * Allows to transfer basic information about application to take action on it.
 */
public class ActionedApplicationTO extends AbstractTO {
    private String applicationId;
    private int rowVerion;
    
    public ActionedApplicationTO(){
        super();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getRowVerion() {
        return rowVerion;
    }

    public void setRowVerion(int rowVerion) {
        this.rowVerion = rowVerion;
    }
}
