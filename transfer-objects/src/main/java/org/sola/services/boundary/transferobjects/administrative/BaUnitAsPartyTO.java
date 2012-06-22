/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.administrative;

import org.sola.services.common.contracts.AbstractTO;

/**
 *
 * @author KumarKhadka
 */
public class BaUnitAsPartyTO extends AbstractTO {

    private String baUnitId;
    private String partyId;
    
    public String getBaUnitId() {
        return baUnitId;
    }

    public void setBaUnitId(String baUnitId) {
        this.baUnitId = baUnitId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
    
    
}
