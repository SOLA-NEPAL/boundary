package org.sola.services.boundary.transferobjects.referencedata;

import org.sola.services.common.contracts.AbstractCodeTO;

public class DistrictTO extends AbstractCodeTO {
    private int zoneCode;
    
    public DistrictTO(){
        super();
    }

    public int getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(int zoneCode) {
        this.zoneCode = zoneCode;
    }
}
