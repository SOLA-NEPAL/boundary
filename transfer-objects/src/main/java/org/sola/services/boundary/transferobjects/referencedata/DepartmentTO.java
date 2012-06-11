package org.sola.services.boundary.transferobjects.referencedata;

import org.sola.services.common.contracts.AbstractCodeTO;

public class DepartmentTO extends AbstractCodeTO {
    private String officeCode;
    
    public DepartmentTO(){
        super();
    }

    public String getOfficeCode() {
        return officeCode;
}

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
