/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.casemanagement;

import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class VdcTO extends AbstractIdTO {

    private int vdcCode;
    private String vdcName;
    private int districtCode;

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public int getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(int vdcCode) {
        this.vdcCode = vdcCode;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }
    
    
}
