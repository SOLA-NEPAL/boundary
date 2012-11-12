package org.sola.services.boundary.transferobjects.cadastre;

import org.sola.services.common.contracts.AbstractBasicIdTO;

public class DatasetTO extends AbstractBasicIdTO {

    private String name;
    private int srid;
    private String officeCode;
    private String vdcCode;
    
    public DatasetTO(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public int getSrid() {
        return srid;
    }

    public void setSrid(int srid) {
        this.srid = srid;
    }

    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }
}
