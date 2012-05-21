package org.sola.services.boundary.transferobjects.referencedata;

import org.sola.services.common.contracts.AbstractCodeTO;

public class OfficeTO extends AbstractCodeTO {
    
    private int districtCode;
    
    public OfficeTO(){
        super();
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }
}
