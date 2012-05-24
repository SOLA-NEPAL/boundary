/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.system;

import org.sola.services.common.contracts.AbstractCodeTO;

/**
 *
 * @author KumarKhadka
 */
public class VdcTO extends AbstractCodeTO {

    private String vdcCode;
   
    private String districtCode;

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }
    

    
    
    
}
