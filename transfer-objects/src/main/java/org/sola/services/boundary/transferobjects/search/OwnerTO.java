package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractBasicIdTO;

public class OwnerTO extends AbstractBasicIdTO {
    private String fullName;
    private String address;
    private String fatherName;
    private String grandfatherName;
    
    public OwnerTO(){
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGrandfatherName() {
        return grandfatherName;
    }

    public void setGrandfatherName(String grandfatherName) {
        this.grandfatherName = grandfatherName;
    }
}
